package com.summer.algorithms;


/**
 * 欧几里德算法（求最大公约数）
 */
public class Gcd {
    public static void main(String[] args) {
        int rst = gcd(18,7);
        System.out.println(rst);
    }

    public static int gcd(int p, int q) {
        return q==0 ? p : gcd(q,p % q);
    }
}
