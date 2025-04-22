package one.digitalInnovation.personapi.mapper;

import one.digitalInnovation.personapi.dto.request.PhoneDTO;
import one.digitalInnovation.personapi.entity.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    @Mapping(target = "person", ignore = true)
    Phone toModel(PhoneDTO phoneDTO);
    PhoneDTO toDTO(Phone phone);
    
}
