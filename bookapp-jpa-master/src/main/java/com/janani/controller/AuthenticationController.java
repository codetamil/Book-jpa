package com.janani.controller;

import java.util.List;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.janani.model.Book;
import com.janani.model.User;
import com.janani.service.BookService;
import com.janani.service.UserService;
import com.janani.util.EmailUtil;

@Controller
@RequestMapping("auth")
public class AuthenticationController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@Autowired
	private EmailUtil emailUtil;

	@PostMapping("/login")
	public String login(@RequestParam("emailId") String emailId, @RequestParam("password") String password,
			ModelMap modelMap, HttpSession session) {

		System.out.println("Login controller called");
		User user = userService.findByEmailAndPassword(emailId, password);
		if (user != null) {
			List<Book> books = bookService.findAll();
			session.setAttribute("LOGGED_IN_USER", user);
			session.setAttribute("books", books);
			return "book/list";
		} else {
			modelMap.addAttribute("ERROR_MESSAGE", "Invalid Email Id/Password");
			return "home";
		}
	}

	@GetMapping("/register")
	public String showRegsiter() {
		System.out.println("Inside Registration");
		return "user/register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute User user, ModelMap modelMap, HttpSession session) throws Exception {
		try {

			userService.register(user);
			// Send Registration Notification Mail
			String subject = "Your account has been created";
			String body = "Welcome to Revature ! You can login to your account !";
			emailUtil.send(user.getEmail(), subject, body);
			return "redirect:../";
		} catch (Exception e) {
			e.printStackTrace();
			modelMap.addAttribute("ERROR_MESSAGE", e.getMessage());
			return "user/register";
		}

	}
}
