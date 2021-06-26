package one.digitalinnovation.personalapi.controller;

import one.digitalinnovation.personalapi.dto.MessageResponseDTO;
import one.digitalinnovation.personalapi.dto.request.PersonDTO;
import one.digitalinnovation.personalapi.entity.Person;
import one.digitalinnovation.personalapi.repository.PersonRepository;
import one.digitalinnovation.personalapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService= personService;
    }

    @PostMapping

    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
    return personService.createPerson(personDTO);

    }


}
