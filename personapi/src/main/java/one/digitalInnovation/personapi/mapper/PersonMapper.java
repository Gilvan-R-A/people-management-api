package one.digitalInnovation.personapi.mapper;

import one.digitalInnovation.personapi.dto.request.PersonDTO;
import one.digitalInnovation.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
// import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", uses = {PhoneMapper.class})
public interface PersonMapper {

    // PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "phones", source = "phones")
    Person toModel(PersonDTO personDTO);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "phones", source = "phones")
    PersonDTO toDTO(Person person);
}
