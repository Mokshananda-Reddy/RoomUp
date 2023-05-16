package com.roomup.backend.controller;

import com.roomup.backend.model.Admin;
import com.roomup.backend.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping("/admin")
    Admin newAdmin(@RequestBody Admin newAdmin)
    {
        try
        {
            logger.info("[ADMIN] - " + "Received New Admin Creation Request: {}", newAdmin);
            Admin savedAdmin = adminRepository.save(newAdmin);
            logger.info("[RESULT - ADMIN] - " + "Successfully Created New Admin: {}", savedAdmin);
            return adminRepository.save(savedAdmin);

        } catch(Exception e)
        {
            logger.error("[ERROR - ADMIN] - " + "Error occurred while creating a new admin: {}", e.getMessage());
            throw e;
        }

    }

    @GetMapping("/admins")
    List<Admin> getAllAdmins()
    {
        try {
            logger.info("[ADMINS] - Received Request to Get All Admins");
            List<Admin> admins = adminRepository.findAll();
            logger.info("[RESULT - ADMINS] - " + "Successfully Retrieved {} admins", admins.size());
            return admins;
        } catch (Exception e) {
            logger.error("[ERROR - ADMINS] - " + "Error occurred while retrieving admins: {}", e.getMessage());
            throw e;
        }
    }

}
