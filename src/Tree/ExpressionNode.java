package Tree;

import java.util.Map;

public class ExpressionNode<T> extends Node<T> {

    public ExpressionNode(){
        super();
    }

    public ExpressionNode(String identifier) {
        super(identifier);
    }

    public ExpressionNode(Node<T> left, Node<T> right) {
        super(left, right);
    }

    public ExpressionNode(String identifier, Node<T> left, Node<T> right) {
        super(identifier, left, right);
    }

    @Override
    public T evaluate(Interpretation<T> interpretation) {
        T leftValue = interpretation.getDefaultLiteralValue();
        T rightValue = interpretation.getDefaultLiteralValue();

        if (left != null) {
            leftValue = left.evaluate(interpretation);
        }

        if (right != null) {
            rightValue = right.evaluate(interpretation);
        }

        return interpretation.getOperationByIdentifier(this.identifier).apply(leftValue, rightValue);
    }
}
