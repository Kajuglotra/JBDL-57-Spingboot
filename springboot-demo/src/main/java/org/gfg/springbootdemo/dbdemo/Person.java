package org.gfg.springbootdemo.dbdemo;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {


    private String name;

    private Integer id;

}

// real world prob

// backend id ?
// txn id -> frontend
// ref id -> backend
