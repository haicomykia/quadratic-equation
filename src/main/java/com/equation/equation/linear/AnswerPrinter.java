package com.equation.equation.linear;

import java.util.StringJoiner;

import com.equation.equation.Complex;
import com.equation.equation.Equation;

import lombok.AllArgsConstructor;

/**
 * 方程式の解を出力
 */
@AllArgsConstructor(staticName = "of")
public class AnswerPrinter {
    
    /**
     * 方程式
     */
    Equation eq;

    @Override
    public String toString() {

        var answers = this.eq.getAnswers();

        if (answers.isEmpty()) {
            return "";
        }

        StringJoiner sj = new StringJoiner(", ");
        for (Complex complex : answers) {
            sj.add(complex.toString());
        }

        return sj.toString();
    }
}
