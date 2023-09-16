package org.gfg.springbootdemo.dbdemo.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "person_data")
public class MyPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    // int default value =0
    // Integer null
    // because in jpa& hibernate, we have methods which are implememted on @Id
    @Column(name = "first_name", length =30)
    private String fName;
    private String lName;
    @Column(length = 30, unique = true )
    private String email;

    private String dob;
    private Integer age;
    @Transient
    private  String country;


}
// hibernate replaces capital with _small of that word

// fetch the previous id, 101+1 =102
// ask my mysql u generate it by your own
// hibernate to generate ids for me

//select
// update -> for update l1 & db
//select -> cache /session
// aborting

// session
// acheive from session
// where the session is present?
// em??
// jpa ->session factory ->  em