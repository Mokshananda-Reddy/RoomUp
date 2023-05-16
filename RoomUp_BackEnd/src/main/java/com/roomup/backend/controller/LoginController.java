package com.roomup.backend.controller;

import com.roomup.backend.model.LoginDetails;
import com.roomup.backend.repository.LoginRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    LoginDetails newLogin(@RequestBody LoginDetails newLogin)
    {
        try
        {
            logger.info("[LOGIN] - " + "Received New Login Creation Request: {}", newLogin);
            LoginDetails savedLogin = loginRepository.save(newLogin);
            logger.info("[RESULT - LOGIN] - " + "Successfully Created New Login: {}", savedLogin);
            return loginRepository.save(savedLogin);

        } catch(Exception e)
        {
            logger.error("[ERROR - LOGIN] - " + "Error occurred while creating a New Login: {}", e.getMessage());
            throw e;
        }
    }

    @GetMapping("/logins")
    List<LoginDetails> getAllLogins()
    {
        try {
            logger.info("[LOGINS] - Received Request to Get All Logins");
            List<LoginDetails> logins = loginRepository.findAll();
            logger.info("[RESULT - LOGINS] - " + "Successfully Retrieved {} Logins", logins.size());
            return logins;
        } catch (Exception e) {
            logger.error("[ERROR - LOGINS] - " + "Error occurred while retrieving Logins: {}", e.getMessage());
            throw e;
        }
    }

    @PostMapping("/validate")
    ResponseEntity<Boolean> validateLogin(@RequestBody(required = true) Map<String,String> logindetails)
    {
        try
        {
            String username = logindetails.get("username");
            String role = logindetails.get("role");
            String password = logindetails.get("password");
            logger.info("[VALIDATE] - Received Request to validate the Login: {}", logindetails);
            LoginDetails l = loginRepository.getPasswordByUsername(username,role);
            if(l != null)
            {
                if(l.getPassword().equals(password))
                {
                    logger.info("[RESULT - VALIDATE] - " + "Password Matches, Login Successful: {}", logindetails);
                    return new ResponseEntity<Boolean>(true, HttpStatus.OK) ;
                }
                else
                    logger.info("[RESULT - VALIDATE] - " + "Password Does not matches, Login Failed: {}", logindetails);
                    return new ResponseEntity<Boolean>(false, HttpStatus.OK) ;
            }
            logger.info("[RESULT - VALIDATE] - " + "Login Details is Empty, Login Failed: {}", logindetails);
            return new ResponseEntity<Boolean>(false, HttpStatus.OK) ;

        }
        catch(Exception e)
        {
            logger.error("[ERROR - VALIDATE] - " + "Error occurred while validating Login: {}", e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR) ;
    }
}
