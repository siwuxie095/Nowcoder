package com.siwuxie095.onlineprogramming.swordtooffer.question012;

/**
 * 假设求 x^6 ,已知 6 可以表示成二进制 110
 * 可以表示成 6 = 0*2^0 + 1*2^1 + 1*2^2,所以 x^6 可以表示成 x^6 = x^(0*2^0 + 1*2^1 + 1*2^2)
 * = x^0 * x^(1*2^1) * x^(1*2^2) 所以，对于二进制数，遇到位数是 1 的就乘到答案中。
 *
 * @author Jiajing Li
 * @date 2021-04-07 14:28:21
 */
@SuppressWarnings("all")
public class Other {

    public double Power(double base, int exponent) {
        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }
        double tmp = base;
        double res = 1D;
        while (exponent != 0) {
            // 奇数次幂，多乘一个 base
            if (exponent % 2 == 1) {
                res *= tmp;
            }
            tmp *= tmp;
            exponent >>= 1;
        }
        return res;
    }

}
