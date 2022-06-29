package com.equation.coefficient.coefficient;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.equation.coefficient.policy.CoefficientPolicy;

import lombok.Getter;

/*
 * 係数のオブジェクト
 */
@Getter
public class Coefficient {

    /**
     * 係数
     */
    private double coefficient;

    /**
     * エラーメッセージ
     */
    private List<String> errors;
    
    /**
     * 名前
     */
    private String name;

    /**
     * 係数（文字列）
     */
    private String strCoefficient;

    /**
     * コンストラクタ 
     * @param coefficient 係数
     */
    private Coefficient(double coefficient, String name) {
        this.coefficient = coefficient;
        this.errors = new ArrayList<>();
        this.name = name;
    }

    /**
     * コンストラクタ
     */
    public Coefficient(String name) {
        this(0, name);
    }

    /**
     * 標準入力から係数の入力を受け付ける
     */
    public void receiveInput() {
        System.out.print(this.name + ":");
        var scanner = new Scanner(System.in);
        this.strCoefficient = scanner.next();
    }

    /**
     * 入力された係数の入力チェックを行う
     * 
     * @param strCoefficient    係数
     */
    public List<String> validate() {
        if (this.strCoefficient == null) {
            return new ArrayList<>();
        }
        var policy = new CoefficientPolicy(this);
        var violations = policy.validate();
        if (violations.isEmpty()) {
            this.coefficient = Double.parseDouble(this.strCoefficient);
        }
        return violations;
    }
}
