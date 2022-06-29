package com.equation;


import com.equation.coefficient.coefficient.Coefficient;
import com.equation.equation.Equation;
import com.equation.equation.linear.LinearEquation;
import com.equation.equation.quadratic.QuadraticEquation;

public class App 
{
    public static void main( String[] args )
    {
        var a = createCoefficient("a");
        var b = createCoefficient("b");
        var c = createCoefficient("c");
        Equation eq = createEquation(a, b, c);
        eq.resolve();
        eq.sortDesc();
        System.out.println(eq.printAnswer());
    }

    /**
     * 係数を生成
     * @param name  係数の名前
     * @return      係数
     */
    private static Coefficient createCoefficient(String name) {
        var x = new Coefficient(name);
        while(true) {
            x.receiveInput();
            var violations = x.validate();
            if (violations.isEmpty()) {
                return x;
            }
            for (String violation : violations) {
                System.out.println(violation);
            }
        }
    }

    /**
     * 方程式を作る
     * @param a 係数a
     * @param b 係数b
     * @param c 係数c
     * @return  方程式オブジェクト
     */
    private static Equation createEquation(Coefficient a, Coefficient b, Coefficient c) {
        if (a.getCoefficient() == 0) {
            return new LinearEquation(b, c);
        }

        return new QuadraticEquation(a, b, c);
    }
}
