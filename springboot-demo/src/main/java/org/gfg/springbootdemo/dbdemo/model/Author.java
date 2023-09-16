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
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // int default value =0
    // Integer null
    // because in jpa& hibernate, we have methods which are implememted on @Id
    @Column(length =30)
    private String name;
}
