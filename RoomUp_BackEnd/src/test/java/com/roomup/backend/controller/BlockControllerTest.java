package com.roomup.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roomup.backend.model.Block;
import com.roomup.backend.repository.BlockRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BlockControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BlockRepository blockRepository;

    private BlockController blockController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        blockController = new BlockController(blockRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(blockController).build();
    }

    @Test
    public void testNewBlock() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob = dateFormat.parse("2001-01-01");

        Block newBlock = new Block();
        newBlock.setBlockID(1L);
        newBlock.setDob(dob);
        newBlock.setName("Anil");
        newBlock.setPassword("anil");
        newBlock.setUsername("anil");
        newBlock.setEmail("anil@gmail.com");
        newBlock.setGender("Male");
        newBlock.setRegisteredID("IIITB-BM-001");


        when(blockRepository.save(any(Block.class))).thenReturn(newBlock);

        mockMvc.perform(MockMvcRequestBuilders.post("/block")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newBlock)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.blockID").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Anil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.dob").value(dob))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("anil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("anil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender").value("Male"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.registeredID").value("IIITB-BM-001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("anil@gmail.com"));

        verify(blockRepository, times(2)).save(any(Block.class));
    }

    @Test
    public void testGetAllBlocks() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dob1 = dateFormat.parse("2001-01-01");
        Date dob2 = dateFormat.parse("2001-02-02");

        Block block1 = new Block();
        block1.setBlockID(1L);
        block1.setDob(dob1);
        block1.setName("Anil");
        block1.setPassword("anil");
        block1.setUsername("anil");
        block1.setEmail("anil@gmail.com");
        block1.setGender("Male");
        block1.setRegisteredID("IIITB-BM-001");

        Block block2 = new Block();
        block2.setBlockID(2L);
        block2.setDob(dob2);
        block2.setName("Kajal");
        block2.setPassword("kajal");
        block2.setUsername("kajal");
        block2.setEmail("kajal@gmail.com");
        block2.setGender("Female");
        block2.setRegisteredID("IIITB-BM-002");

        List<Block> blockList = new ArrayList<>();
        blockList.add(block1);
        blockList.add(block2);

        when(blockRepository.findAll()).thenReturn(blockList);

        mockMvc.perform(MockMvcRequestBuilders.get("/blocks"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].blockID").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Anil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].dob").value(dob1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("anil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].password").value("anil"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].gender").value("Male"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].registeredID").value("IIITB-BM-001"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("anil@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].blockID").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Kajal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].dob").value(dob2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].username").value("kajal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].password").value("kajal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].gender").value("Female"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].registeredID").value("IIITB-BM-002"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].email").value("kajal@gmail.com"));

        verify(blockRepository, times(1)).findAll();
    }

    // Helper method to convert objects to JSON string
    private static String asJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

