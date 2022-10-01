package Tree.Interpretations;

import Tree.Interpretation;

import java.util.List;

public class StandartIntegerInterpretation extends Interpretation<Integer>{

    public StandartIntegerInterpretation(){
        super(0);
        this.addOp("+", Integer::sum);
        this.addOp("max", Integer::max);
        this.addOp("min", Integer::min);
        this.addOp("*", (x,y) -> x*y);
        this.addOp("-", (x,y) -> x-y);
        this.addOp("/", (x,y) -> (int) Math.floor((x+0.0)/(y+0.0)));
        this.addOp("pow", (x,y) -> (int)Math.pow(x+0.0,y+0.0));
    }

    public StandartIntegerInterpretation(List<String> identifierList, List<Integer> literalList){
        this();

        this.addMultipleLiterals(identifierList, literalList);
    }
}
