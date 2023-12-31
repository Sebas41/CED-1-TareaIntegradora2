package com.example.ced1integradora2.model.structure.tree;

import java.util.NoSuchElementException;

public class NaryTree <T extends Comparable<T>>{

    public Node<T> root;

    public boolean add(T parent, T toAdd){
        boolean status = false;
        Node<T> referenceParent = searchNode(parent);
        Node<T> temp = new Node<>(toAdd);

        if (root == null) {
            root = temp;
            status = true;
        }else if(referenceParent != null){
            referenceParent.add(temp);
            status = true;
        }

        return status;
    }

    public boolean delete(T child, T parent){
        boolean status = false;

        if(root.getValue().compareTo(child) == 0){
            if(root.isLeaf()){
                root = null;
                status = true;
            }
        }else{
            Node<T> referenceParent = searchNode(parent);
            if(referenceParent != null){
                status = referenceParent.deleteChild(child);
            }
        }
        return status;
    }

    private Node<T> searchNode(T t){
        Node<T> toReturn;
        if(root == null){
            toReturn = null;
        }else if(t != null){
            toReturn = root.searchNode(t);
        }else{
            toReturn=null;
        }
        return toReturn;
    }

    /*---------------------------------------------------------*/
    // Print methods
    public String preOrder(){
        String message;
        if (root == null){
            message = "The tree is empty";
        }else{
            message = root.preOrder();
        }
        return message;
    }

    public String postOrder(){
        String message;
        if (root == null){
            message = "The tree is empty";
        }else{
            message = root.postOrder();
        }
        return message;
    }

    public boolean isEmpty() {
        return true;
    }

    public double getValue(T i) {
        if (root == null) {
            throw new NoSuchElementException("The tree is empty");
        } else {
            Double value = root.getValue(i);
            if (value != null) {
                return value;
            } else {
                throw new NoSuchElementException("No element with the given key found");
            }
        }
    }

    public Node<T> getRoot() {
        return root;
    }
}
