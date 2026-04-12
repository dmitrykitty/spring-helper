package com.dnikitin.spring.spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SingleSpelExample {

    @Value("#{4 + 2}")
    private int sumEval;

    @Value("#{'String is '.concat('concatenated')}")
    private String stringIsConcatenated;

    @Value("#{2 > 3 and 10 < 11}")
    private boolean boolEval;

    @Value("#{1 != 1? 0: 1}")
    private int ternaryEval;

    @Value("#{'${my.prop}' ?: 'defaultValue'}")
    private String defaultValue;

    @Value("${app.os.name}")
    private String appOsName;



    public void printSpels(){
        System.out.println("SumEval: " +  sumEval);
        System.out.println("StringEval: " + stringIsConcatenated);
        System.out.println("BoolEval: " + boolEval);
        System.out.println("ternaryEval: " + ternaryEval);
        System.out.println("defaultValue: " + defaultValue);
        System.out.println("OS Name: " + appOsName);

    }

    public void simpleEvaluateExample(){
        simpleReadOnlyContext();
        System.out.println("-------------------");
    }

    public void simpleReadAndWriteExample(){
        simpleReadWriteContext();
        System.out.println("-------------------");
    }

    private void simpleReadOnlyContext(){
        SpelExpressionParser parser = new SpelExpressionParser();
        ExpressionParserObject object = new ExpressionParserObject();

        EvaluationContext  readOnlyContext = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        Expression exp = parser.parseExpression("strValue[0]");
        String firstFromList = exp.getValue(readOnlyContext, object, String.class);

        System.out.println("First from list: " + firstFromList);

        Expression thirdFromMap = parser.parseExpression("mapValue[2]");
        System.out.println("Third from map: " + thirdFromMap.getValue(readOnlyContext, object, String.class));
    }

    private void simpleReadWriteContext(){
        SpelExpressionParser parser = new SpelExpressionParser();
        ExpressionParserObject object = new ExpressionParserObject();

        EvaluationContext readWriteContext = SimpleEvaluationContext.forReadWriteDataBinding().build();
        Expression listExpression = parser.parseExpression("strValue");
        List<String> list = listExpression.getValue(readWriteContext, object, List.class);
        list.add("six");

        System.out.println("List: " + object.getStrValue());

        Expression changeFirstValueExpression = parser.parseExpression("mapValue[0]");
        changeFirstValueExpression.setValue(readWriteContext, object, "new zero");

        System.out.println("Object map: " + object.getMapValue());
    }

    private static class ExpressionParserObject{
        private List<String> strValue = new ArrayList<>(List.of("zero", "one", "two", "three", "four", "five"));

        public Map<Integer, String> getMapValue() {
            return mapValue;
        }

        public List<String> getStrValue() {
            return strValue;
        }

        private Map<Integer, String> mapValue = new HashMap<>(Map.of(0, "zero", 1, "one", 2, "two", 3, "three", 4, "four", 5, "five"));
    }
}
