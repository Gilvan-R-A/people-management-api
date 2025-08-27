package one.digitalInnovation.personapi.service;

import lombok.AllArgsConstructor;
import one.digitalInnovation.personapi.dto.request.PersonDTO;
import one.digitalInnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalInnovation.personapi.entity.Person;
import one.digitalInnovation.personapi.entity.Phone;
import one.digitalInnovation.personapi.exception.PersonNotFoundException;
import one.digitalInnovation.personapi.mapper.PersonMapper;
import one.digitalInnovation.personapi.mapper.PhoneMapper;
import one.digitalInnovation.personapi.repository.PersonRepository;
import one.digitalInnovation.personapi.repository.PhoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;
    private final PhoneRepository phoneRepository;
    private final PersonMapper personMapper;
    private final PhoneMapper phoneMapper;

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        validateCpfUniqueness(personDTO.getCpf().trim(), null);
        Person personToSave = personMapper.toModel(personDTO);

        List<Phone> phones = personToSave.getPhones();
        personToSave.setPhones(null);

        Person savedPerson = personRepository.save(personToSave);

        if (phones != null && !phones.isEmpty()) {
            for (Phone phone : phones) {
                phone.setPerson(savedPerson);
            }
            phoneRepository.saveAll(phones);
        }

        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAllWithPhones();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {

        validateCpfUniqueness(personDTO.getCpf().trim(), id);

        Person existingPerson = verifyIfExists(id);

        existingPerson.setFirstName(personDTO.getFirstName());
        existingPerson.setLastName(personDTO.getLastName());
        existingPerson.setCpf(personDTO.getCpf());
        existingPerson.setBirthDate(personDTO.getBirthDate());

        existingPerson.getPhones().clear();
        if (personDTO.getPhones() != null) {
            List<Phone> updatedPhones = personDTO.getPhones().stream()
            .map(phoneDTO -> {
                Phone phone = phoneMapper.toModel(phoneDTO);
                phone.setPerson(existingPerson);
                return phone;
            })
            .collect(Collectors.toList());

            existingPerson.getPhones().addAll(updatedPhones);
        }

        Person updatedPerson = personRepository.save(existingPerson);

        return createMessageResponse(updatedPerson.getId(), "Updated person with ID");
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException{
        return personRepository.findByIdWithPhones(id)
                .orElseThrow(()-> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private void validateCpfUniqueness(String cpf, Long currentId) {
        personRepository.findByCpf(cpf.trim()).ifPresent(existingPerson -> {
            if (currentId == null || !existingPerson.getId().equals(currentId)) {
                throw new RuntimeException("CPF already registered.");
            }
        });
    }

}
