package org.gfg.springbootdemo.dbdemo.service;

import org.gfg.springbootdemo.CustomException;
import org.gfg.springbootdemo.dbdemo.model.Author;
import org.gfg.springbootdemo.dbdemo.model.MyPerson;
import org.gfg.springbootdemo.dbdemo.repository.AuthorJPARepository;
import org.gfg.springbootdemo.dbdemo.repository.PersonJpaRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Service
public class MyPersonService {

    @Autowired
    private PersonJpaRepository personJpaRepository;

    @Autowired
    private AuthorJPARepository authorJPARepository;

    @PersistenceContext
    private EntityManager em;


    @Transactional(rollbackOn = {CustomException.class} )
    public MyPerson saveMyPerson(MyPerson person ) throws CustomException {
//        person.setId(1); // this is the way when we want to set the set id
        // we can have custom logic for creation of an id


        MyPerson person1 = personJpaRepository.save(person); // saving data

        personJpaRepository.getById(person.getId());// getting data
        Session session = (Session) em.getDelegate();
        MyPerson myPerson2 = (MyPerson) session.get(MyPerson.class , person.getId());


        if(person.getAge()==31){
            throw new CustomException("not allowed");
        }
        return person1;
    }

    public Author saveAuthor(Author author) {
        return authorJPARepository.save(author);
    }
}
// controller -> object -> getting data from user
// controller -> returning an object to user
// no

// dto -> data transfer object

