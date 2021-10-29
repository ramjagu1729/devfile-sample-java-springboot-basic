package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@Controller
//@RestController
//@RequestMapping(path="/falcondemo")
public class FalconController {
	@Autowired
	private FalconuserRepository falconuserRepository;
	
//    @Autowired
//    private StreamingService service;

	@PostMapping(path="/falcondemo/add") // Map ONLY POST Requests
	  public @ResponseBody String addNewUser (@RequestParam String firstname
	      , @RequestParam String lastname, @RequestParam String email,@RequestParam String password) {
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

//	    User n = new User();
//	    n.setUsername(username);
//	    n.setPassword(password);
//	    userRepository.save(n);
//	    return "Saved";
		Falconuser f = new Falconuser(firstname,lastname,email,password);
//		f.setFirstname(firstname);
//		f.setLastname(lastname);
//		f.setEmail(email);
		falconuserRepository.save(f);
		return "Saved";
	  }

	  @GetMapping(path="/falcondemo/all")
	  public @ResponseBody Iterable<Falconuser> getAllUsers() {
	    // This returns a JSON or XML with the users
//	    return userRepository.findAll();
		  return falconuserRepository.findAll();
	  }
	  
	    @GetMapping("/")
	    public String viewHomePage() {
	        return "index";
	    }
	    @GetMapping("/logout")
	    public String viewLogoutPage() {
	        return "index";
	    }
	    @GetMapping("/register")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("falconuser", new Falconuser());
	         
	        return "signup_form";
	    }
	    @PostMapping("/process_register")
	    public String processRegister(Falconuser falconuser) {
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(falconuser.getPassword());
	        falconuser.setPassword(encodedPassword);
	         
	        falconuserRepository.save(falconuser);
	         
	        return "register_success";
	    }
	    
	    @GetMapping("/users")
	    public String listUsers(Model model) {
	    	Iterable<Falconuser> listUsers = falconuserRepository.findAll();
	        model.addAttribute("listUsers", listUsers);
	         
	        return "users";
	    }
//	    @GetMapping(value = "video/{title}", produces = "video/mp4")
//	    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
//	        System.out.println("range in bytes() : " + range);
//	        return service.getVideo(title);
//	    }
	    @GetMapping("/vidhome")
	    public String viewVideohomePage() {
	        return "vidhome";
	    }
	    @GetMapping("/vid")
	    public String viewVideoPage() {
	        return "vid";
	    }
	    
}
