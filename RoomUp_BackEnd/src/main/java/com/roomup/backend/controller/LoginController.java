package com.roomup.backend.controller;

import com.roomup.backend.model.LoginDetails;
import com.roomup.backend.repository.LoginRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @PostMapping("/login")
    LoginDetails newLogin(@RequestBody LoginDetails newLogin)
    {
        return loginRepository.save(newLogin);
    }

    @GetMapping("/logins")
    List<LoginDetails> getAllUsers()
    {
        return loginRepository.findAll();
    }

    @PostMapping("/validate")
    ResponseEntity<Boolean> validateLogin(@RequestBody(required = true) Map<String,String> logindetails)
    {
        try
        {
//            System.out.println(logindetails);
            String username = logindetails.get("username");
            String role = logindetails.get("role");
            String password = logindetails.get("password");

//            System.out.println(username);
//            System.out.println(role);
//            System.out.println(password);
            LoginDetails l = loginRepository.getPasswordByUsername(username,role);
            if(l != null)
            {
                if(l.getPassword().equals(password))
                {
                    return new ResponseEntity<Boolean>(true, HttpStatus.OK) ;
                }
                else
                    return new ResponseEntity<Boolean>(false, HttpStatus.OK) ;
            }
            return new ResponseEntity<Boolean>(false, HttpStatus.OK) ;


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR) ;
    }
}
