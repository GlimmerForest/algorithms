package com.summer.algorithms;

/**
 * 计算连个数组合并后的中间值
 */
public class MidData {
    private static double midData(int[] a, int[] b) {
        int la = a.length;
        int lb = b.length;
        // 如果数组a长度大,就互换a,b
        if (la > lb) {
            int[] tmpArr = a;
            a = b;
            b = tmpArr;

            int m = la;
            la = lb;
            lb = m;
        }
        int start = 0;
        int end = la;
        int mid = (la + lb + 1)/2;
        while (start < end) {
            int i = (start + end)/2;
            int j = mid - i;
            if (i < end && a[i] < b[j-1]) {
                start = start + 1;
            } else if (i > start && a[i-1] > b[j]) {
                end = end - 1;
            } else {
                int maxLeft;
                int minRight;
                if (i == 0) {
                    maxLeft = b[j-1];
                } else if (j == 0) {
                    maxLeft = a[i -1];
                } else {
                    maxLeft = Math.max(a[i-1],b[j-1]);
                }
                if ((la + lb)%2 == 1) {
                    return maxLeft;
                }

                if (i == la) {
                    minRight = b[j];
                } else if (j == lb) {
                    minRight = a[i];
                } else {
                    minRight = Math.min(a[i],b[j]);
                }
                return (maxLeft + minRight)/2.0;

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,5,8};
        int[] b = {3,4,6,7};
        double c = midData(a,b);
        System.out.println(c);
    }
}
