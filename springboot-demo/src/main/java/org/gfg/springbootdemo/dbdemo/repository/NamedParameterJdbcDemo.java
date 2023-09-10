package org.gfg.springbootdemo.dbdemo.repository;

import org.gfg.springbootdemo.dbdemo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NamedParameterJdbcDemo implements IPerson{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public List<Person> getAllPerson() {
        return null;
    }

    @Override
    public int updatePerson(int id, String name) {
        return 0;
    }
    // i can use prepared statement with named templated from spring jdbc
    @Override
    public Person addPersonWithPreparedStatement(Person person) {
//        ? -> index
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name" , person.getName());
        mapSqlParameterSource.addValue("id" , person.getId());
        namedParameterJdbcTemplate.update("insert into person (name, id) VALUES (:name , :id)", mapSqlParameterSource);

//        namedParameterJdbcTemplate.execute("insert into person (name, id) VALUES (:name , :id)", mapSqlParameterSource, new PreparedStatementCallback<Object>() {
//            @Override
//            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
//              return ps.execute();
//            }
//        });
        return person;
    }

    @Override
    public Person addPerson(Person person) {
        return null;
    }
}
