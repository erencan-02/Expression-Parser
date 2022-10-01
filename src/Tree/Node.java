package Tree;

import java.util.Map;

public class Node<T>{
    public Node<T> left;
    public Node<T> right;
    protected String identifier;


    public Node(){
        this.identifier = "";
    }

    public Node(String identifier){
        this.identifier = identifier;
    }

    public Node(Node<T> left, Node<T> right){
        this.left = left;
        this.right = right;
    }

    public Node(String identifier, Node<T> left, Node<T> right){
        this.identifier = identifier;
        this.left = left;
        this.right = right;
    }

    public String getIdentifier(){
        return this.identifier;
    }

    public void setIdentifier(String identifier){
        this.identifier = identifier;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public T evaluate(Interpretation<T> interpretation){
        throw new RuntimeException();
    }
}
