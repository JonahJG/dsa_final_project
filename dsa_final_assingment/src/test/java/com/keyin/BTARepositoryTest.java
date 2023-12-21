package com.keyin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BTARepositoryTest {

    @Autowired
    private BTARepository btaRepository;

    @Test
    void findFirstByOrderByIdDesc() {
        NumberEntity entity1 = new NumberEntity();
        entity1.setValue(1);
        btaRepository.save(entity1);

        NumberEntity entity2 = new NumberEntity();
        entity2.setValue(2);
        btaRepository.save(entity2);

        NumberEntity result = btaRepository.findFirstByOrderByIdDesc().orElse(null);

        assertNotNull(result);
        assertEquals(2, result.getValue());
    }

    @Test
    void findAll() {
        NumberEntity entity1 = new NumberEntity();
        entity1.setValue(1);
        btaRepository.save(entity1);

        NumberEntity entity2 = new NumberEntity();
        entity2.setValue(2);
        btaRepository.save(entity2);

        List<NumberEntity> resultList = btaRepository.findAll();

        assertEquals(2, resultList.size());
        assertTrue(resultList.stream().anyMatch(entity -> entity.getValue() == 1));
        assertTrue(resultList.stream().anyMatch(entity -> entity.getValue() == 2));
    }
}

//