# Expression Parser

[![forthebadge](http://forthebadge.com/images/badges/built-with-love.svg)](http://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
![image](https://user-images.githubusercontent.com/46029684/193451514-bc5c0f70-8ed6-4007-9edd-745122ddf476.png)



## Example

## Numeric Expression
```java
Parser<Double> parser = new Parser<>(0.0); // default value (0.0) is used when an identifier is not found in a given interpretation
Interpretation<Double> interpretation = new StandartDoubleInterpretation();
interpretation.addLiterals(List.of("x", "y", "z"), List.of(1, 2, 3));
Double result = parser.evaluate("(+ (pow 2 x) (- y z))", interpretation);
```

Or as a short version by using the constructor of `Interpretation`:

```java
Parser<Double> parser = new Parser<>(0.0);
Interpretation<Double> interpretation = new StandartDoubleInterpretation(List.of("x", "y", "z"), List.of(1, 2, 3));
Double result = parser.evaluate("(+ (pow 2 x) (- y z))", interpretation);
```


## Boolean Expression
```java
Parser<Boolean> parser = new Parser<>(false);
Interpretation<Boolean> interpretation = new StandartBooleanInterpretation(List.of("a", "b", "c"), List.of(true, false, true));
Boolean result = parser.evaluate("(-> (&& a b) c)", interpretation); // = true
```


