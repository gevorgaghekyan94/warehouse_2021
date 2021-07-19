package com.example.spring1607.service.person;

import com.example.spring1607.facade.person.PersonDTO;
import com.example.spring1607.persistance.entities.Person;

import java.util.ArrayList;

public interface PersonService {

    PersonDTO create(PersonDTO dto);

    PersonDTO getById(Long id);

    ArrayList<PersonDTO> findAll();

    PersonDTO findByName(String name);

    ArrayList<PersonDTO> findAllByAge(Integer age);

    PersonDTO updateById(PersonDTO dto);

    void deleteById(Long id);

}
