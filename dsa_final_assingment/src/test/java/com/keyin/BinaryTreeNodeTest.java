package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    @Test
    void testGetId() {
        BinaryTreeNode node = new BinaryTreeNode();
        assertNull(node.getId());
    }

    @Test
    void testSetId() {
        BinaryTreeNode node = new BinaryTreeNode();
        Long id = 123L;
        node.setId(id);
        assertEquals(id, node.getId());
    }

    @Test
    void testGetValue() {
        BinaryTreeNode node = new BinaryTreeNode();
        assertNull(node.getValue());
    }

    @Test
    void testSetValue() {
        BinaryTreeNode node = new BinaryTreeNode();
        Integer value = 42;
        node.setValue(value);
        assertEquals(value, node.getValue());
    }

    @Test
    void testGetLeft() {
        BinaryTreeNode node = new BinaryTreeNode();
        assertNull(node.getLeft());
    }

    @Test
    void testSetLeft() {
        BinaryTreeNode node = new BinaryTreeNode();
        BinaryTreeNode leftNode = new BinaryTreeNode();
        node.setLeft(leftNode);
        assertEquals(leftNode, node.getLeft());
    }

    @Test
    void testGetRight() {
        BinaryTreeNode node = new BinaryTreeNode();
        assertNull(node.getRight());
    }

    @Test
    void testSetRight() {
        BinaryTreeNode node = new BinaryTreeNode();
        BinaryTreeNode rightNode = new BinaryTreeNode();
        node.setRight(rightNode);
        assertEquals(rightNode, node.getRight());
    }
}

//