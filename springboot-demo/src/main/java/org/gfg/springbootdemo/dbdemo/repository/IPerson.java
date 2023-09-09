package org.gfg.springbootdemo.dbdemo.repository;

import org.gfg.springbootdemo.dbdemo.Person;

import java.util.List;

public interface IPerson {
    List<Person> getAllPerson();
    int updatePerson(int id, String name);

    Person addPersonWithPreparedStatement(Person person);
     Person addPerson(Person person);
}
