package one.digitalinnovation.personalapi.service;

import one.digitalinnovation.personalapi.dto.MessageResponseDTO;
import one.digitalinnovation.personalapi.dto.request.PersonDTO;
import one.digitalinnovation.personalapi.entity.Person;
import one.digitalinnovation.personalapi.exception.PersonNotFoundException;
import one.digitalinnovation.personalapi.mapper.PersonMapper;
import one.digitalinnovation.personalapi.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // - Mark the class like service, the busines laws;
public class PersonService {


    private PersonRepository personRepository;
    private PersonMapper personMapper  = PersonMapper.INSTANCE;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson( PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created personDTO with ID" + savedPerson.getId())
                .build();

    }




    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();

  return allPeople.stream()
          .map(personMapper::toDTO)
          .collect(Collectors.toList());
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));



    }

    public PersonDTO findById(long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);


        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        personRepository.deleteById(id);
    }
}
