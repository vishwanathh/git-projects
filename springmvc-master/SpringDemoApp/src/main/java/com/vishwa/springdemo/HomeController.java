package com.vishwa.springdemo;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vishwa.entity.User;
import com.vishwa.springdemo.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/user")
public class HomeController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
		
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Locale locale, Model model) {
		String loggedIn = System.getProperty("user.name");		
		model.addAttribute("loginUser", loggedIn );
		return "home";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseBody
	public HttpStatus create(@RequestBody User user) {
		userService.createUser(user);
		return HttpStatus.OK;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public HttpStatus edit(@RequestBody User user) {
		userService.updateUser(user);
		return HttpStatus.OK;
	}
	
	@RequestMapping(value="/search", method = RequestMethod.GET)
	@ResponseBody
	public List<User> search() {
		return userService.getUser();
	}
	
	@RequestMapping(value="/search/{id}", method=RequestMethod.GET)
	@ResponseBody
	public User search(@PathVariable int id) {
		return userService.getUserById(id);		
	}	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	@ResponseBody
	public HttpStatus delete(@PathVariable int id) {
		userService.removeUser(id);
		return HttpStatus.OK;
	}
	
}
