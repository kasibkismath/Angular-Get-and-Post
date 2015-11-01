package com.kasibsblog.spring.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kasibsblog.spring.web.dao.Person;
import com.kasibsblog.spring.web.service.PersonService;

@Controller
public class MainController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/")
	public String showIndex(Model model){
		
		List<Person> person = personService.getPerson();
		model.addAttribute("person", person);
		
		return "index";
	}
	
	@RequestMapping(value="/getPerson", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Person> getPerson(){
		List<Person> person = new ArrayList<Person>();
		person = personService.getPerson();
		
		return person;
	}
	
	@RequestMapping(value="/sendPerson", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public List<Person> sendPerson(@RequestBody Person person){
		
		String firstname = person.getFirstname();
		String lastname = person.getLastname();
		String occupation = person.getOccupation();
		
		personService.addPerson(firstname, lastname, occupation);
		
		return getPerson();
	}
}
