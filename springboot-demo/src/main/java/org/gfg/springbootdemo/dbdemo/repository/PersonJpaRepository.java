package org.gfg.springbootdemo.dbdemo.repository;

import org.gfg.springbootdemo.dbdemo.model.MyPerson;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonJpaRepository extends JpaRepository<MyPerson,Long> {

    // internally method
    // custom method  ??
}
