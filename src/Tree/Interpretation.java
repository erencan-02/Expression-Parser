package Tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Interpretation <T>{

    private Map<String, BinaryOperator<T>> operations = new HashMap<>();
    private Map<String, T> literals = new HashMap<>();
    private final T defaultLiteralValue;

    public Interpretation(){
        this.defaultLiteralValue = null;
    }

    public Interpretation(T defaultLiteralValue){
        this.defaultLiteralValue = defaultLiteralValue;
    }

    public Interpretation(List<String> identifierList, List<T> literalList, T defaultLiteralValue){
        this(defaultLiteralValue);

        this.addMultipleLiterals(identifierList, literalList);
    }

    public Map<String, BinaryOperator<T>> getOperations(){
        return this.operations;
    }

    public Map<String, T> getLiterals(){
        return this.literals;
    }

    public T getDefaultLiteralValue(){
        return this.defaultLiteralValue;
    }

    public void addOp(String identifier, BinaryOperator<T> op){
        this.operations.put(identifier, op);
    }

    public void addLiteral(String identifier, T t){
        this.literals.put(identifier, t);
    }

    public BinaryOperator<T> getOperationByIdentifier(String identifier){
        if(this.operations.containsKey(identifier)){
            return this.operations.get(identifier);
        }

        return (x, y) -> this.defaultLiteralValue;
    }

    public T getLiteralValueByIdentifier(String identifier){
        if(this.literals.containsKey(identifier)){
            return this.literals.get(identifier);
        }

        return this.defaultLiteralValue;
    }

    public void addMultipleOperations(List<String> identifierList, List<BinaryOperator<T>> operationList){
        if(identifierList.size() != operationList.size()){
            throw new IllegalArgumentException();
        }

        for(int i=0; i<identifierList.size(); i++){
            this.addOp(identifierList.get(i), operationList.get(i));
        }
    }

    public void addMultipleLiterals(List<String> identifierList, List<T> literalList){
        if(identifierList.size() != literalList.size()){
            throw new IllegalArgumentException();
        }

        for(int i=0; i<identifierList.size(); i++){
            this.addLiteral(identifierList.get(i), literalList.get(i));
        }
    }
}
