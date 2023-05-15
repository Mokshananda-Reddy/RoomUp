package com.roomup.backend.repository;

import com.roomup.backend.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockRepository extends JpaRepository<Block,Long> {
}
