package org.gfg.springbootdemo.dbdemo.repository;

import org.gfg.springbootdemo.dbdemo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class SpringJdbcDemo implements IPerson{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> getAllPerson() {
     return jdbcTemplate.query("select * from person", new RowMapper<Person>() {
         @Override
         public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
             return new Person(resultSet.getString("name"), resultSet.getInt("id"));
         }
     });
    }

    @Override
    public int updatePerson(int id, String name) {
        return 0;
    }

    @Override
    public Person addPersonWithPreparedStatement(Person person) {
        return null;
    }

    @Override
    public Person addPerson(Person person) {
        return null;
    }
}
// 1) snapshot, m2, release etc

// 2) try prepared statement with sping jdbc template

// 3) for update ( do it a lock on one row or the complete table)

// 4) create a get request which will return u the specific data id =2, id =1

// 5) configure no of  connections u want to create hikari ?



