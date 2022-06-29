package com.equation.coefficient.policy;

/**
 * 係数の書式をチェック
 */
public class CoefficientFormatValidator implements ICoefficientRule {

    @Override
    public boolean ok(String coefficient) {
        return coefficient.matches("^(-?|[¥+]?)[0-9]+$");
    }

    @Override
    public String getMessage() {
        return "係数%sには整数を入力してください。";
    }
}
