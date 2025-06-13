package com.dev.modelviewcontroller.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.modelviewcontroller.Entity.UserTable;
import com.dev.modelviewcontroller.Service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class MyController {
    @Autowired
    private UserService userservice;
@GetMapping("/regPage")
public String openRegPage(Model model)
{
    model.addAttribute("user",new UserTable());
    return "registration";
}
@PostMapping("/regform")
public String submitRegForm(@ModelAttribute("user")UserTable userTable,Model model)
{
   boolean status = userservice.registeruser(userTable);
   if(status)
   {
    model.addAttribute("successmsg","user register Successfully");
   }
   else
   {
    model.addAttribute("errormsg","user not register due to some error");
   }
    return "registration";
}
@GetMapping("/logInPage")
public String openLoginPage(Model model)
{ 
    model.addAttribute("user",new UserTable());
    return "login";
}

  

@PostMapping("/logInForm")
public String submitLoginForm(@ModelAttribute("user") UserTable userTable,Model model,HttpSession session)
{
    UserTable validUser = userservice.loginUser(userTable.getEmail(),userTable.getPassword());
    if(validUser != null)
    { model.addAttribute("modelName", validUser.getName());
      session.setAttribute("loggedInUser", validUser);
      session.setAttribute("userId",validUser.getId());
        return "profile";
    }
    else{
      model.addAttribute("errorMsg",validUser);
      return "login";
    }
}
@GetMapping("/profile")
public String showProfile(Model model, HttpSession session) {
    UserTable loggedInUser = (UserTable) session.getAttribute("loggedInUser");

    if (loggedInUser != null) {
        model.addAttribute("modelName", loggedInUser.getName());
        return "profile";
    } else {
        // Not logged in — redirect to login
        return "redirect:/logInPage";
    }
}

@GetMapping("/logout")
public String logout(HttpSession session) {
    session.invalidate(); // remove session data
    return "redirect:/logInPage";
}
@GetMapping("/aboutas")
public String AboutAs() {
    return "aboutas";
}

}
