package Parser;

import Tree.ExpressionTree;
import Tree.Interpretation;

public interface Parser<T> {

    boolean hasCorrectSyntax(String s);

    ExpressionTree<T> buildExpressionTree(String s);

    default T evaluate(String s, Interpretation<T> interpretation){
        return this.buildExpressionTree(s).evaluate(interpretation);
    }
}
