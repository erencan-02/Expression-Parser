package Tree.Interpretations;

import Tree.Interpretation;

import java.util.List;

public class StandartBooleanInterpretation extends Interpretation<Boolean> {
    public StandartBooleanInterpretation(){
        super(false);
        this.addOp("&&", (x,y) -> x && y);
        this.addOp("||", Boolean::logicalOr);
        this.addOp("^", Boolean::logicalXor);
        this.addOp("<->", (x, y) -> (!x || y) && (!y || x)); //Boolean::equals);
        this.addOp("->", (x, y) -> !x || y);
        this.addOp("!&", (x, y) -> !(x && y));
        this.addOp("!", (x, y) -> !x);
        this.addOp("!^", (x, y) -> !Boolean.logicalXor(x,y));
    }

    public StandartBooleanInterpretation(List<String> a, List<Boolean> booleans) {
        this();
        //super(a, booleans, null);
        this.addMultipleLiterals(a, booleans);
    }
}
