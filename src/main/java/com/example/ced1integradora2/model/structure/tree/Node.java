package com.example.ced1integradora2.model.structure.tree;

import java.util.ArrayList;

public class Node <T extends Comparable<T>>{

    private T value;
    private ArrayList<Node<T>> children;

    public Node(T value){
        this.value = value;
        children = new ArrayList<>();
    }

    public boolean add(Node<T> node){
        children.add(node);
        return true;
    }

    public boolean deleteChild(T value){
        boolean status = false;
        if(isLeaf()){
            for(int i = 0; i<children.size() && !status; i++){
                if(children.get(i).getValue().compareTo(value) == 0){
                    children.remove(i);
                    status = true;
                }
            }
        }
        return status;
    }

    public Node<T> searchNode(T value){
        Node<T> toReturn = null;
        if(this.value.compareTo(value) == 0){
            toReturn = this;
        }else if(isLeaf()){
            boolean exit = false;
            for(int i = 0; i<children.size() && !exit; i++){
                toReturn = children.get(i).searchNode(value);
                if(toReturn!=null){
                    exit = true;
                }
            }
        }
        return toReturn;
    }

    public boolean isLeaf(){
        return children.isEmpty();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ArrayList<Node<T>> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node<T>> children) {
        this.children = children;
    }

    /*-------------------------------------------------------------------*/
    // Print methods
    public String preOrder() {
        String message = this.toString() + " ";

        for (Node<T> child : children) {
            message += child.preOrder();
        }

        return message;
    }

    public String postOrder() {
        String message = "";

        for (Node<T> child : children) {
            message += child.postOrder();
        }

        message += this.toString() + " ";

        return message;
    }

    public String toString(){
        return value.toString();
    }

    public Double getValue(T i) {
        Double value = null;
        if (this.value.compareTo(i) == 0) {
            value = (Double) this.value;
        } else if (isLeaf()) {
            boolean exit = false;
            for (int j = 0; j < children.size() && !exit; j++) {
                value = children.get(j).getValue(i);
                if (value != null) {
                    exit = true;
                }
            }
        }
        return value;
    }
}
