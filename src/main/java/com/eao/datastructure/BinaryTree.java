package com.eao.datastructure;


import java.util.Objects;

public class BinaryTree  {

    TreeNode rootNode;
    TreeNode parentNode;

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.add(1);
        binaryTree.add(6);
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(3);
        binaryTree.add(2);

        System.out.println(binaryTree.search(2));
        System.out.println(binaryTree.searchParent(2).data);
    }

    public void add(Integer data) {
        if (rootNode == null) {
            this.rootNode = new TreeNode(data);
            return;
        }

        addNode(rootNode, data);
    }

    private void addNode(TreeNode node, Integer data) {

        if (node != null && node.data > data) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode(data));
            } else {
                addNode(node.getLeft(), data);
            }

        } else if (node != null && node.data < data){
            if (node.getRight() == null) {
                node.setRight(new TreeNode(data));
            } else {
                addNode(node.getRight(), data);
            }
        }
    }

    public boolean search(Integer data) {
        if (rootNode == null) {
            return false;
        }
        return Objects.equals(searchNode(rootNode, data).data, data);
    }

    private TreeNode searchNode(TreeNode node, Integer data) {
        if (node.data.equals(data))
            return node;
        else if (node.data > data && node.getLeft() != null) {
            return searchNode(node.getLeft(), data);
        } else if (node.data < data && node.getRight() != null){
            return searchNode(node.getRight(), data);
        }
        return node;
    }

    public TreeNode searchParent(Integer data){
        if (rootNode == null) {
            return null;
        }
        TreeNode treeNode = searchParentNode(rootNode, data);
        return treeNode;
    }

    private TreeNode searchParentNode(TreeNode node, Integer data) {
        if (node.data.equals(data))
            return parentNode;
        else if (node.data > data && node.getLeft() != null) {
            parentNode = node;
            return searchParentNode(node.getLeft(), data);
        } else if (node.data < data && node.getRight() != null) {
            parentNode = node;
            return searchParentNode(node.getRight(), data);
        }
        return parentNode;
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    Integer data;

    public TreeNode(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}