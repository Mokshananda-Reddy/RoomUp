package com.roomup.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roomup.backend.model.Admin;
import com.roomup.backend.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AdminControllerTest {
    private MockMvc mockMvc;

    @Mock
    private AdminRepository adminRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        AdminController adminController = new AdminController(adminRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    void testNewAdmin() throws Exception {
        Admin admin = new Admin();
        admin.setAdminID(1L);
        admin.setUsername("vishnu");
        admin.setName("Srivishnu");

        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        mockMvc.perform(MockMvcRequestBuilders.post("/admin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(admin)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.adminID").value(admin.getAdminID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value(admin.getUsername()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(admin.getName()));

        verify(adminRepository, times(1)).save(any(Admin.class));
    }

    @Test
    void testGetAllAdmins() throws Exception {
        Admin admin1 = new Admin();
        admin1.setAdminID(1L);
        admin1.setUsername("vishnu");
        admin1.setName("Srivishnu");

        Admin admin2 = new Admin();
        admin2.setAdminID(2L);
        admin2.setUsername("Satwik Sama");
        admin2.setName("satwik");

        List<Admin> admins = Arrays.asList(admin1, admin2);

        when(adminRepository.findAll()).thenReturn(admins);

        mockMvc.perform(MockMvcRequestBuilders.get("/admins"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].adminID").value(admin1.getAdminID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value(admin1.getUsername()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(admin1.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].adminID").value(admin2.getAdminID()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].username").value(admin2.getUsername()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value(admin2.getName()));

        verify(adminRepository, times(1)).findAll();
    }
}

