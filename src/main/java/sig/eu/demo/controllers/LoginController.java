package sig.eu.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sig.eu.demo.entities.User;
import sig.eu.demo.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@Controller
//@RequestMapping({"authenticate"})
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = {RequestMethod.POST})
    public boolean login(@RequestBody User user) {
        System.out.println("Login controller");
        System.out.println("[User login controller] " + user.toString());

        return userService.authenticate(user);
    }

    @RequestMapping("/user")
    public String user(HttpServletRequest request) {
        Principal user = request.getUserPrincipal();
        return user.getName();
    }

}
