package com.example;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;   
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.bind.annotation.RequestParam;  
  
@Controller  
public class LoginCtrl {  
  
    @RequestMapping("/save")  
   public String display(@RequestParam("username") String name,@RequestParam("password") String pass,Model m)   {
	   
	   String s=Just.data(name,pass);
	   if(s.equals("none"))
	   {
		    m.addAttribute("message", "No such user found! Try Again...");
			return "hello";
	   }
	   else
	   {
		   m.addAttribute("username",name);
		   m.addAttribute("message",s);
		   return "sample";
	   }
   }
      
    
}  