package com.equation.equation.linear;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.equation.coefficient.coefficient.Coefficient;
import com.equation.equation.Complex;
import com.equation.equation.Equation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * 一次方程式のクラス
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LinearEquation implements Equation {

    private Coefficient a;

    private Coefficient b;

    private List<Complex> answers;

    public LinearEquation(Coefficient a, Coefficient b) {
        this.a = a;
        this.b = b;
        this.answers = new ArrayList<>(); 
    }

    @Override
    public void resolve() {
        if (a.getCoefficient() == 0) {
            this.answers.add(Complex.realNumber(-b.getCoefficient()));
        } else {
            this.answers.add(Complex.realNumber(-(b.getCoefficient() / a.getCoefficient())));
        }
    }

    @Override
    public void sortDesc() {
        Comparator<Complex> complexSorter = Comparator.comparing(Complex::getReal).reversed();
        this.answers = this.answers.stream().sorted(complexSorter).collect(Collectors.toList());
    }

    @Override
    public String printAnswer() {
        var printer = AnswerPrinter.of(this);
        return printer.toString();
    }

    @Override
    public List<Complex> getAnswers() {
        return Collections.unmodifiableList(this.answers);
    }
}
