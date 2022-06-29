package com.equation.equation;
import lombok.*;

/**
 * 複素数のクラス
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Complex {
    /**
     * 実部
     */
    private double real;

    /**
     * 虚部
     */
    private double image;

    /**
     * 虚数を定義
     * @param real  実部
     * @param image 虚部
     * @return      複素数（実部＋虚部）
     */
    public static Complex imaginaryNumer(double real, double image) {
        return new Complex(real, image);
    }

    /**
     * 実数を定義
     * @param real
     * @return  複素数（実部のみ）
     */
    public static Complex realNumber(double real) {
        return Complex.imaginaryNumer(real, 0);
    }

    @Override
    public String toString() {
        if (this.image == 0) return String.format("%.5f", this.real);
        if (this.real == 0) return String.format("+.5fi", this.image);
        return String.format("%.5f%+.5fi", this.real, this.image);
    }
}
