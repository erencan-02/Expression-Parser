package Parser;

import Tree.*;

public class PrefixParser<T> implements Parser<T>{

    private T defaultValue;

    public PrefixParser(T defaultValue){
        this.defaultValue = defaultValue;
    }

    @Override
    public boolean hasCorrectSyntax(String input) {
        int i = 0;

        for(char c : input.toCharArray()){
            if(c == '('){
                i++;
            }
            else if (c == ')'){
                i--;
            }

            if(i < 0){
                return false;
            }
        }

        return (i==0);
    }

    @Override
    public ExpressionTree<T> buildExpressionTree(String input) {
        if(!hasCorrectSyntax(input)){
            throw new IllegalArgumentException("Wrong Syntax: " + input);
        }

        return new ExpressionTree<>(this.extractOuterOperation(input), this.defaultValue);
    }

    private ExpressionTree<T> buildExpressionTreeHelper(String input) {
        return null;
    }

    public Node<T> extractOuterOperation(String s){
        Node<T> node;

        if(s.split("\s").length > 1){
            node = new ExpressionNode<T>();

            String arg1 = this.extractFirstParameter(s);
            String arg2 = this.extractSecondParameter(s);

            node.setIdentifier(this.extractIdentifier(s));
            node.left = extractOuterOperation(arg1);
            node.right = extractOuterOperation(arg2);
        }
        else{
            node = new LiteralNode<T>();
            node.setIdentifier(s);
        }

        return node;
    }

    public String extractFirstParameter(String s){

        String firstPart = s.split("\s")[1];

        if(!firstPart.contains("(")){
            return firstPart;
        }

        StringBuilder sb = new StringBuilder();
        boolean secondBracketSeen = false;
        char[] c = s.toCharArray();
        int sum = 0;

        for(int i=1; i<c.length; i++){
            if(c[i] == '('){
                secondBracketSeen = true;
            }

            if(secondBracketSeen){
                sb.append(c[i]);

                sum += (c[i] == '(') ? 1 : (c[i] == ')') ? -1 : 0;

                if(sum == 0){
                    return sb.toString();
                }
            }
        }
        return sb.toString();
    }

    public String extractSecondParameter(String s){
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        //Direktwert oder Literal
        if(c[c.length-2] != ')'){
            for(int i=c.length-2; i>=0; i--){
                if(c[i] == ' '){
                    return sb.reverse().toString();
                }
                sb.append(c[i]);
            }
        }

        for(int i=c.length-2; i>=0; i--){
            sb.append(c[i]);

            sum += (c[i] == '(') ? -1 : (c[i] == ')') ? 1 : 0;

            if(sum == 0){
                return sb.reverse().toString();
            }
        }

        return sb.reverse().toString();
    }

    public String extractIdentifier(String s){
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<c.length; i++){
            if(c[i] == ' '){
                return sb.toString();
            }

            sb.append(c[i]);
        }

        return sb.toString();
    }


}
