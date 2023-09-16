package org.gfg.springbootdemo.dbdemo.repository;

import org.gfg.springbootdemo.dbdemo.model.MyPerson;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonJpaRepository extends JpaRepository<MyPerson,Integer> {

    // internally method
    // custom method  ??
}
