package com.roomup.backend.controller;

import com.roomup.backend.model.Block;
import com.roomup.backend.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(BlockController.class);

    @PostMapping("/block")
    Block newBlock(@RequestBody Block newBlock)
    {
        try
        {
            logger.info("[BLOCK] - " + "Received New Manager Creation Request: {}", newBlock);
            Block savedBlock = blockRepository.save(newBlock);
            logger.info("[RESULT - BLOCK] - " + "Successfully Created New Manager: {}", savedBlock);
            return blockRepository.save(savedBlock);

        } catch(Exception e)
        {
            logger.error("[ERROR - BLOCK] - " + "Error occurred while creating a New Manager: {}", e.getMessage());
            throw e;
        }
    }

    @GetMapping("/blocks")
    List<Block> getAllBlocks()
    {
        try {
            logger.info("[BLOCKS] - Received Request to Get All Managers");
            List<Block> blocks = blockRepository.findAll();
            logger.info("[RESULT - BLOCKS] - " + "Successfully Retrieved {} Managers", blocks.size());
            return blocks;
        } catch (Exception e) {
            logger.error("[ERROR - BLOCKS] - " + "Error occurred while retrieving Managers: {}", e.getMessage());
            throw e;
        }
    }

}
