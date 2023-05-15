package com.roomup.backend.controller;

import com.roomup.backend.model.Admin;
import com.roomup.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @PostMapping("/admin")
    Admin newAdmin(@RequestBody Admin newAdmin)
    {
        return adminRepository.save(newAdmin);
    }

    @GetMapping("/admins")
    List<Admin> getAllAdmins()
    {
        // return "Hello World";
        return adminRepository.findAll();
    }

}
