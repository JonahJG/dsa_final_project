package com.keyin;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchTree {
    private BinaryTreeNode root;

    public void constructBST(List<NumberEntity> numberEntities) {
        Collections.sort(numberEntities, Comparator.comparingInt(NumberEntity::getValue));

        for (NumberEntity entity : numberEntities) {
            root = insert(root, entity.getValue());
        }
    }

    private BinaryTreeNode insert(BinaryTreeNode node, int value) {
        if (node == null) {
            BinaryTreeNode newNode = new BinaryTreeNode();
            newNode.setValue(value);
            return newNode;
        }

        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        } else {
        }

        return node;
    }

    private String convertToJson(BinaryTreeNode node, boolean isRoot, int indentLevel) {
        if (node == null) {
            return "null";
        }

        StringBuilder json = new StringBuilder();
        if (isRoot) {
            json.append("\"root\": ");
        }

        json.append("{\n");
        json.append(" ".repeat(indentLevel * 2));

        json.append("\"value\": ").append(node.getValue());

        if (node.getLeft() != null || node.getRight() != null) {
            json.append(",\n");
            json.append(" ".repeat((indentLevel + 1) * 2));
            json.append("\"left\": ").append(convertToJson(node.getLeft(), false, indentLevel + 1)).append(",\n");
            json.append(" ".repeat((indentLevel + 1) * 2));
            json.append("\"right\": ").append(convertToJson(node.getRight(), false, indentLevel + 1));
        }

        json.append("\n");
        json.append(" ".repeat(indentLevel * 2));
        json.append("}");

        return json.toString();
    }

    public String getJsonRepresentation() {
        if (root == null) {
            return "null";
        }

        return convertToJson(root, true, 0);
    }

    public void resetRoot() {
        this.root = null;
    }

    public Integer getRoot() {
        return root.getValue();
    }
}

//