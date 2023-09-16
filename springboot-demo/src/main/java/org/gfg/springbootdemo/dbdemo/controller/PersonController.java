package org.gfg.springbootdemo.dbdemo.controller;

import org.gfg.springbootdemo.CustomException;
import org.gfg.springbootdemo.dbdemo.Person;
import org.gfg.springbootdemo.dbdemo.model.Author;
import org.gfg.springbootdemo.dbdemo.model.MyPerson;
import org.gfg.springbootdemo.dbdemo.service.MyPersonService;
import org.gfg.springbootdemo.dbdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private MyPersonService myPersonService;

    @GetMapping("/getPersons")
    public ResponseEntity<List<Person>> getPersonData(){
        //validation -> for this case, u do not have any validations to put on
        // HTTP request -> we can return anything
        // HTTP provides us a class to get returned

        //
        List<Person> list = personService.getPersonData();
        ResponseEntity<List<Person>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);

        return responseEntity;
    }
    @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        if(person.getId() == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Person p = personService.addPerson(person);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/updatePerson")
    public ResponseEntity<Integer> updatePerson(@RequestBody Person person){
        if(person.getId() == null){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(personService.updatePerson(person.getName(), person.getId()), HttpStatus.OK);
    }
    @PostMapping("/addMyPerson")
    public MyPerson addMyPerson(@RequestBody MyPerson person) throws CustomException {
        return myPersonService.saveMyPerson(person);

    }
    @PostMapping("/addMyAuthor")
    public Author addMyAuthor(@RequestBody Author author){
        return myPersonService.saveAuthor(author);

    }
}
//create table person_data (id integer not null,
//create table person_data (id integer not null auto_increment,

// from fe-> order creation -> multiple data
// backend -> separate out the data ->> storing the data into multiple tables