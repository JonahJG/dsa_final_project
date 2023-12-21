package com.keyin;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

    public interface BTARepository extends JpaRepository<NumberEntity, Long> {
        Optional<NumberEntity> findFirstByOrderByIdDesc();

        List<NumberEntity> findAll();

    }

    //