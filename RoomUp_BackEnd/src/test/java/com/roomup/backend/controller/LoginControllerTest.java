package com.roomup.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roomup.backend.model.LoginDetails;
import com.roomup.backend.repository.LoginRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class LoginControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LoginRepository loginRepository;

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    void newLogin() throws Exception {
        LoginDetails loginDetails = new LoginDetails(); // Create your login details object
        loginDetails.setUsername("testuser");
        loginDetails.setPassword("testpassword");
        loginDetails.setRole("testrole");

        when(loginRepository.save(any(LoginDetails.class))).thenReturn(loginDetails);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(loginDetails));

        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("testuser"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("testpassword"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.role").value("testrole"));
    }

    @Test
    void getAllUsers() throws Exception {
        LoginDetails login1 = new LoginDetails(); // Create your login details objects
        login1.setUsername("testuser1");
        login1.setPassword("testpassword1");
        login1.setRole("testrole1");

        LoginDetails login2 = new LoginDetails();
        login2.setUsername("testuser2");
        login2.setPassword("testpassword2");
        login2.setRole("testrole2");

        List<LoginDetails> loginList = Arrays.asList(login1, login2);

        when(loginRepository.findAll()).thenReturn(loginList);

        mockMvc.perform(MockMvcRequestBuilders.get("/logins"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("testuser1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].password").value("testpassword1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].role").value("testrole1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].username").value("testuser2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].password").value("testpassword2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].role").value("testrole2"));
    }

    @Test
    public void testValidateLogin() throws Exception {
        Map<String, String> loginDetails = new HashMap<>();
        loginDetails.put("username", "testUser");
        loginDetails.put("role", "admin");
        loginDetails.put("password", "testPassword");

        LoginDetails mockLoginDetails = new LoginDetails();
        mockLoginDetails.setUsername("testUser");
        mockLoginDetails.setPassword("testPassword");

        when(loginRepository.getPasswordByUsername("testUser", "admin")).thenReturn(mockLoginDetails);

        mockMvc.perform(MockMvcRequestBuilders.post("/validate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(loginDetails)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string("true"));
    }

    // Helper method to convert object to JSON string
    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
