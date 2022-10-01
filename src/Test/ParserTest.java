package Test;
import Parser.Parser;
import Tree.Interpretation;
import Tree.Interpretations.StandartBooleanInterpretation;
import Tree.Interpretations.StandartDoubleInterpretation;
import org.junit.jupiter.api.Test;
import Parser.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {

    @Test
    void test1(){
        Parser<Double> p = new PrefixParser<Double>(0.0);
        List<String> expressions = List.of(
                "(+ (- 10 10) x)",
                "(* (pow x 2) (/ 1 x))",
                "(+ x 0)",
                "(+ (- 10 10) 10)",
                "(- (* 2 x) 10)",
                "(+ x (- (pow x 0) 1))",
                "(min 10 (pow 2 4))",
                "(abs -10 0)",
                "(ceil 9.01 0)",
                "(round 10.453 0)",
                "(- (pow 2 5) (* 2 (+ x 1)))"
        );

        Interpretation<Double> i = new StandartDoubleInterpretation(List.of("x"), List.of(10.0));

        for(String s : expressions){
            Double result = p.evaluate(s, i);
            System.out.println(s + " := " + result);
            assertEquals(10.0, result);
        }
    }

    @Test
    void test2(){
        Parser<Boolean> p = new PrefixParser<Boolean>(false);
        List<String> expressions = List.of(
                "(&& x x)",
                "(-> (x && a) x)",
                "(! (^ x x) x)",
                "(<-> (|| x y) (! z z))"
        );

        Interpretation<Boolean> i = new StandartBooleanInterpretation(List.of("x", "y", "z"), List.of(true, false, false));

        for(String s : expressions){
            Boolean result = p.evaluate(s, i);
            System.out.println(s + " := " + result);
            assertEquals(true, result);
        }
    }
}
