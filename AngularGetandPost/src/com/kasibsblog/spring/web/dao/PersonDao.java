package com.kasibsblog.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("personDao")
public class PersonDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Person> getPerson() {
		return jdbc.query("select * from persons", new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();

				person.setId(rs.getInt("id"));
				person.setFirstname(rs.getString("firstname"));
				person.setLastname(rs.getString("lastname"));
				person.setOccupation(rs.getString("occupation"));

				return person;
			}

		});

	}

	public void addPerson(String firstname, String lastname, String occupation) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("firstname", firstname);
		params.addValue("lastname", lastname);
		params.addValue("occupation", occupation);
		
		jdbc.update("insert into persons(firstname, lastname, occupation) values(:firstname, :lastname, :occupation)", params);
		
	}
}
