package com.equation.equation;

import java.util.List;

/**
 * 方程式のインタフェース
 */
public interface Equation {
    /**
     * 方程式を解く
     */
    public void resolve();

    /**
     * 解を降順にソート
     */
    public void sortDesc();

    /**
     * 解を出力
     * @return  方程式の解
     */
    public String printAnswer();

    /**
     * 方程式の解を出力
     * @return  方程式の解のリスト
     */
    public List<Complex> getAnswers();
}
