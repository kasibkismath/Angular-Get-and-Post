package com.kasibsblog.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kasibsblog.spring.web.dao.Person;
import com.kasibsblog.spring.web.dao.PersonDao;

@Service("personService")
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	public List<Person> getPerson(){
		return personDao.getPerson();
	}

	public void addPerson(String firstname, String lastname, String occupation) {
		personDao.addPerson(firstname, lastname, occupation);
		
	}
}
