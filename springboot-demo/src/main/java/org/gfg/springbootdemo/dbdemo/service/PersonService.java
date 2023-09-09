package org.gfg.springbootdemo.dbdemo.service;

import org.gfg.springbootdemo.dbdemo.Person;
import org.gfg.springbootdemo.dbdemo.repository.IPerson;
import org.gfg.springbootdemo.dbdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    @Qualifier("springJdbcDemo")
    private IPerson iPerson;
    public List<Person> getPersonData() {
        // business logic
        return iPerson.getAllPerson();
    }

    public Person addPerson(Person person) {
        // business logic
        return  iPerson.addPersonWithPreparedStatement(person);
    }
    public int updatePerson(String name, int id){
        return iPerson.updatePerson(id, name);
    }
    // business logic
    // different method
    // variables
}
