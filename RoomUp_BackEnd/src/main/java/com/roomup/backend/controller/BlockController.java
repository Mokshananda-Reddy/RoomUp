package com.roomup.backend.controller;

import com.roomup.backend.model.Block;
import com.roomup.backend.repository.AdminRepository;
import com.roomup.backend.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BlockController {
    @Autowired
    private BlockRepository blockRepository;

    @Autowired
    public BlockController(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @PostMapping("/block")
    Block newDoctor(@RequestBody Block newBlock)
    {
        return blockRepository.save(newBlock);
    }

    @GetMapping("/blocks")
    List<Block> getAllDoctors()
    {
        // return "Hello World";
        return blockRepository.findAll();
    }

}
