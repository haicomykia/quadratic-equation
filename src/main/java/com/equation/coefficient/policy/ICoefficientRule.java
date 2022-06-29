package com.equation.coefficient.policy;

/**
 * 係数の入力ルールのインターフェイス
 */
public interface ICoefficientRule {
    /**
     * 入力された係数がルールを満たすか
     * @param coefficient  係数
     * @return  ルールを満たすか？
     */
    public boolean ok(String coefficient);

    /**
     * エラーメッセージを返す
     * @return エラーメッセージ
     */
    public String getMessage();
}
