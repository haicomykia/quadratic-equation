package com.equation.coefficient.policy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.equation.coefficient.coefficient.Coefficient;

/**
 * 係数のPolicyを定義したクラス
 */
public class CoefficientPolicy {
    
    /**
     * 係数
     */
    private Coefficient coefficient;

    /**
     * 係数のルール
     */
    private Set<ICoefficientRule> rules;

    /**
     * エラーメッセージ
     */
    private List<String> messages;

    /**
     * コンストラクタ
     */
    private CoefficientPolicy() {
        this.rules = new HashSet<>();
        this.addRule(new CoefficientFormatValidator());
    }

    /**
     * コンストラクタ
     * 
     * @param cofficient 係数
     */
    public CoefficientPolicy(Coefficient coefficient) {
        this();
        this.coefficient = coefficient;
        this.messages = new ArrayList<>();
    }

    /**
     * エラーメッセージを返す
     * @return エラーメッセージのリスト（変更不可）
     */
    public List<String> getMessages() {
        return Collections.unmodifiableList(this.messages);
    }

    /**
     * ルールを追加
     * @param rule  ルール
     */
    private void addRule(ICoefficientRule rule) {
        this.rules.add(rule);
    }

    /**
     * 係数がルールに適しているかチェック
     * @return  全ルールを満たしているか？
     */
    public List<String> validate() {

        if (this.rules.isEmpty()) {
            throw new IllegalArgumentException("ルールが定義されていません。");
        }
        for (ICoefficientRule rule : rules) {
            if (!rule.ok(this.coefficient.getStrCoefficient())) {
                this.messages.add(String.format(rule.getMessage(), this.coefficient.getName()));
            }
        }
        return this.messages;
    }
}
