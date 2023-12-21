package com.keyin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NumberEntityTest {

    @Test
    void getId() {
        NumberEntity numberEntity = new NumberEntity();

        assertNull(numberEntity.getId());
    }

    @Test
    void setId() {
        NumberEntity numberEntity = new NumberEntity();

        Long id = 1L;
        numberEntity.setId(id);

        assertEquals(id, numberEntity.getId());
    }

    @Test
    void getValue() {
        NumberEntity numberEntity = new NumberEntity();

        assertEquals(0, numberEntity.getValue());
    }

    @Test
    void setValue() {
        NumberEntity numberEntity = new NumberEntity();

        int value = 42;
        numberEntity.setValue(value);

        assertEquals(value, numberEntity.getValue());
    }

    @Test
    void getTreeJson() {
        NumberEntity numberEntity = new NumberEntity();

        assertNull(numberEntity.getTreeJson());
    }

    @Test
    void setTreeJson() {
        NumberEntity numberEntity = new NumberEntity();

        String treeJson = "{\"root\": {\"value\": 42}}";
        numberEntity.setTreeJson(treeJson);

        assertEquals(treeJson, numberEntity.getTreeJson());
    }
}

//