package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LiteralNode<T> extends Node<T>{

    public T value;

    public LiteralNode(){
        super();
    }

    public LiteralNode(String identifier) {
        super(identifier);
    }

    public LiteralNode(Node<T> left, Node<T> right) {
        super(left, right);
    }

    public LiteralNode(String identifier, Node<T> left, Node<T> right) {
        super(identifier, left, right);
    }

    @Override
    public T evaluate(Interpretation<T> interpretation){
        try{
            T obj = (T) new Double(Double.parseDouble(this.identifier));
            return obj;
        }
        catch(Exception e){
            //System.out.println(e.getMessage());
        }



        
        return interpretation.getLiteralValueByIdentifier(this.identifier);
    }
}
