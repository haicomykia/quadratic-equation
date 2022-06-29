package com.equation.equation.quadratic;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.equation.coefficient.coefficient.Coefficient;
import com.equation.equation.Complex;
import com.equation.equation.Equation;
import com.equation.equation.linear.AnswerPrinter;

import java.util.Comparator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * ２次方程式のクラス
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class QuadraticEquation implements Equation {

    /**
     * 係数a
     */
    private Coefficient a;

    /**
     * 係数b
     */
    private Coefficient b;

    /**
     * 係数c
     */
    private Coefficient c;

    /**
     * 解
     */
    private List<Complex> answers;

    /**
     * コンストラクタ
     * @param a 係数a
     * @param b 係数b
     * @param c 係数c
     */
    public QuadraticEquation (Coefficient a, Coefficient b, Coefficient c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.answers  = new ArrayList<>();
    }

    /**
     * 判別式
     * @return 判別式の計算結果
     */
    public double discriminant() {

        final double A = this.a.getCoefficient();
        final double B = this.b.getCoefficient();
        final double C = this.c.getCoefficient();

        return B * B -4 * A * C;
    }

    /**
     * ２次方程式を解く
     */
    @Override
    public void resolve() {
        this.answers = new ArrayList<>();
        final double D = this.discriminant();

        final double A = this.a.getCoefficient();
        final double B = this.b.getCoefficient();

        if (D == 0) {
            this.answers.add(Complex.realNumber(-B / (2 * A)));
        }

        if (D > 0) {
            this.answers.add(Complex.realNumber((-B + Math.sqrt(D)) / (2 * A)));
            this.answers.add(Complex.realNumber((-B - Math.sqrt(D)) / (2 * A)));
        } 

        if (D < 0) {
            final var REAL_PART = -B / (2 * A);
            this.answers.add(Complex.imaginaryNumer(REAL_PART, Math.sqrt(-D) / (2 * A)));
            this.answers.add(Complex.imaginaryNumer(REAL_PART, -Math.sqrt(-D) / (2 * A)));
        } 
    }

    /**
     * 解を降順にソート
     */
    @Override
    public void sortDesc() {
        Comparator<Complex> complexSorter = Comparator.comparing(Complex::getImage).reversed().thenComparing(Complex::getReal).reversed();
        this.answers = this.answers.stream().sorted(complexSorter).collect(Collectors.toList());
    }

    @Override
    public String printAnswer() {
        var printer = AnswerPrinter.of(this);
        return printer.toString();
    }

    @Override
    public List<Complex> getAnswers() {
        return this.answers;
    }
}
