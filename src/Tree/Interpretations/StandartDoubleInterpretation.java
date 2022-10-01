package Tree.Interpretations;

import Tree.Interpretation;

import java.text.DecimalFormat;
import java.util.List;

public class StandartDoubleInterpretation extends Interpretation<Double> {

    public StandartDoubleInterpretation(){
        super(0.0);
        this.addOp("+", Double::sum);
        this.addOp("/", (x, y) -> x/y);
        this.addOp("round", (x, y) -> this.roundDouble(x, y.intValue()));
        this.addOp("max", Double::max);
        this.addOp("min", Double::min);
        this.addOp("*", (x,y) -> x*y);
        this.addOp("-", (x,y) -> x-y);
        this.addOp("pow", Math::pow);
        this.addOp("abs", (x,y) -> Math.abs(x));
        this.addOp("floor", (x,y) -> Math.floor(x));
        this.addOp("ceil", (x,y) -> Math.ceil(x));
    }

    public StandartDoubleInterpretation(List<String> identifiers, List<Double> values) {
        this();
        this.addMultipleLiterals(identifiers, values);
    }

    private Double roundDouble(Double d, int n){
        DecimalFormat df = new DecimalFormat("#." + (new String(new char[n]).replace("\0", "#")));
        return Double.parseDouble(df.format(d.doubleValue()).replace(",", "."));
    }
}
