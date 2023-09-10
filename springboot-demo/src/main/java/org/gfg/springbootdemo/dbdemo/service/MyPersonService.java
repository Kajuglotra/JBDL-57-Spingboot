package org.gfg.springbootdemo.dbdemo.service;

import org.gfg.springbootdemo.dbdemo.Person;
import org.gfg.springbootdemo.dbdemo.model.MyPerson;
import org.gfg.springbootdemo.dbdemo.repository.PersonJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPersonService {

    @Autowired
    private PersonJpaRepository personJpaRepository;

    public MyPerson saveMyPerson(MyPerson person ){
//        MyPerson person = MyPerson.builder().fName(fname).lName(lName).build();

         personJpaRepository.save(person);

         // builder -> gives u a way to create a object of this class using the builder method


    }
}
