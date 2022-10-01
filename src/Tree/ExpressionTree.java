package Tree;

import java.util.Map;

public class ExpressionTree<T>{

    private final Node<T> root;
    public T defaultValue;

    public ExpressionTree(Node<T> root){
        this.root = root;
    }

    public ExpressionTree(Node<T> root, T defaultValue){
        this.root = root;
        this.defaultValue = defaultValue;
    }

    public Node<T> getRoot(){
        return this.root;
    }

    public T evaluate(Interpretation<T> interpretation){
        return this.root.evaluate(interpretation);
    }
}
