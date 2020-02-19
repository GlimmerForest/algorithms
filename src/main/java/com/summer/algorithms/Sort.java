package com.summer.algorithms;

import java.util.Arrays;

public class Sort {

    /**
     * 冒泡排序：算法复杂度N*N,空间复杂度N
     * 算法思路：未排序序列相邻元素比较,每次循环找到一个最大值
     * 适用范围：一般不用
     * @param arr 待排序数组
     * @return 已排序数组
     */
    public static int[] bubblingSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序：算法复杂度N*N,空间复杂度N
     * 算法思路：未排序的第1个元素和剩下的元素比较,每次循环找到一个最小值
     * 适用范围：一般不用
     * @param arr 待排序数组
     * @return 已排序数组
     */
    public static int[] selectSort(int[] arr) {

        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * 插入排序：算法复杂度N*N,空间复杂度N
     * 算法思路：默认序列第一个值有序,从第二个值开始遍历与有序序列的最大值比较,如果未排序值大,
     *  移动有序序列,直到找到合适的位置把未排序值插入
     * 适用范围：小序列,有序序列
     * @param arr 待排序数组
     * @return 已排序数组
     */
    public static int[] insertSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int point = arr[i];
            int j = i - 1;
            for (;j >= 0 && arr[j] > point; j--) {
                arr[j+1] = arr[j];
            }
            arr[j+1] = point;
        }
        return arr;
    }

    /**
     * 希尔排序：插入排序升级版,时间复杂度N*logN, 空间复杂度N
     * 算法思路：通过设置步长分解原序列,减小序列长度再利用插入排序排序
     * 适用范围：
     * @param arr 待排序数组
     * @return 已排序数组
     */
    public static int[] shellSort(int[] arr) {
        int len = arr.length;
        for(int gap = len/2; gap > 0; gap/=2) {
            for(int i = gap; i < len; i ++) {
                shellInsert(arr, gap, i);
            }
        }
        return arr;
    }

    /**
     * 希尔插入：时间复杂度N*N
     * @param arr 待排序数组
     * @param gap 步长
     * @param i 待插入元素原始位置
     */
    private static void shellInsert(int[] arr, int gap, int i) {
        // 暂存待插入数据
        int key = arr[i];
        int j = i - gap;
        // 从最大值开始比较,并移动数据
        for (; j > 0 && arr[j] > key; j-=gap) {
            arr[j+gap] = arr[j];
        }
        arr[j+gap] = key;
    }

    /**
     * 归并排序：时间复杂度N*logN,空间复杂度N
     * 算法思路：递归平分序列,待序列有序后再合并序列
     * 适用范围：不受输入数据影响
     * @param arr 待排序数组
     * @param tmp 临时数组
     * @return 已排序数组
     */
    public static int[] mergeSort(int[] arr, int[] tmp) {

        int len = arr.length;
        int middle = len / 2;

        if (len < 2) {
            return arr;
        }
        // 浅拷贝,不会暂用额外堆空间
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, len);

        return merge(mergeSort(left, tmp), mergeSort(right, tmp), tmp);
    }

    /**
     * 循环比较左右部分的第一个元素,把小的放到临时数组里,当其中一个数组没有元素时,把另一个数组元素全部依次放入临时数组里
     * 时间复杂度N,空间复杂度N
     * @param left 左半部分
     * @param right 右半部分
     * @param tmp 临时数组
     * @return 有序数组
     */
    private static int[] merge(int[] left, int[] right, int[] tmp) {
        int leftLen = left.length;
        int rightLen = right.length;
//        int[] result = new int[leftLen + rightLen];
        int[] result = Arrays.copyOfRange(tmp, 0,leftLen + rightLen);
        int i = 0;

        while(left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }

    /**
     * 快速排序：时间复杂度N*logN,空间复杂度N
     * 算法思路：任意选个数作为标杆,序列中大于这个数的都放到右边,小于这个数的都放到左边,然后分别对左右两边递归的执行上述操作
     * 使用范围：不受输入数据影响
     * @param arr 待排序数组
     * @param left 起始位置
     * @param right 结束位置
     * @return 已排序数组
     */
    public static int[] quickSort(int[] arr, int left, int right) {

        if (left >= right) {
            return null;
        }

        int low = left;
        int high = right;
        int key = arr[low];

        while (low < high) {
            while (low < high && arr[high] > key) {
                high --;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] < key) {
                low ++;
            }
            arr[high] = arr[low];
        }

        arr[low] = key;

        quickSort(arr, left, low - 1);
        quickSort(arr, low + 1, right);
        return arr;
    }

    /**
     * 堆排序：时间复杂度N*logN,空间复杂度N
     * 算法思路：利用堆父节点大于或者小于子节点和堆的存储结构是数组的特点,反复交换堆顶和堆尾元素及调整堆
     * @param arr 待排序序列
     * @return 已排序序列
     */
    public static int[] heapSort(int[] arr) {
        int len = arr.length;

        // 构造堆,从左叶子节点开始,时间复杂度N*logN,空间复杂度N
        for (int i = len/2 - 1; i >= 0; i --) {
            heapify(arr, i, len);
        }

//        for (int j = len - 1; j > 0; j --) {
//            swap(arr, 0 , j);
//            heapify(arr, 0, j);
//        }
        // 交换堆顶和堆(数组)最后一个元素,并调整堆
        for (int j = 1; j < len; j ++ ) {
            swap(arr, len - j);
            heapify(arr, 0, len - j);
        }


        return arr;
    }

    /**
     * 堆调整(自顶向下深度遍历)：时间复杂度logN,空间复杂度N
     * @param arr 待调整堆(堆以数组的形式存储)
     * @param father 父节点
     * @param len 堆长度
     */
    private static void heapify(int[] arr, int father, int len) {
        int max = arr[father];
        for (int k = 2*father + 1; k < len; k = 2*k + 1) {
            // 比较子节点,用较大的子节点与父节点比较
            if (k+1 < len && arr[k] < arr[k+1]) {
                k = k + 1;
            }
            if (arr[k] > max) {
                arr[father] = arr[k];
                father = k;
            }
        }
        arr[father] = max;
    }

    /**
     * 数组元素交换
     * @param arr 待处理数组
     * @param j 待交换位置
     */
    private static void swap(int[] arr, int j) {
        int tmp = arr[0];
        arr[0] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 计数排序：时间复杂度K(max - min)*N,空间复杂度N
     * 算法思路：根据值区间建立中间数组,遍历序列,当值与中间数据组下标相等时,中间数组值加1
     * 适用于值落在一定范围内序列排序
     * @param arr 待排序数组
     * @return 已排序数组
     */
    public static int[] countSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int len = arr.length;
        // 查询最大值和最小值,时间复杂度N,空间复杂度N
        for (int i = 1; i < len; i++) {
            min = min > arr[i] ? arr[i] : min;
            max = max < arr[i] ? arr[i] : max;
        }
        int[] temp = new int[max-min+1];

        // 时间复杂度K(max - min)*N,空间复杂度N
        for (int i = 0; i < max - min + 1; i ++) {
            for (int data:arr) {
                if (data == min + i) {
                    temp[i] ++;
                }
            }
        }
        // 回写数据,时间复杂度K(max - min)*N,空间复杂度N
        for (int i = 0, j = 0; i < len; i ++) {
            if (j < max - min + 1 && temp[j] > 0) {
                arr[i] = j + min;
                temp[j] --;
            }
            while (j < max - min + 1 && temp[j] == 0) {
                j ++;
            }
        }

        return arr;
    }

    /**
     * 桶排序：时间复杂度K*N,空间复杂度N
     * 算法思路：把序列均分到不同桶中,然后对桶内数据排序
     * 适用于数据服从均匀分布的情况,测试数据中不能有0
     * @param arr 排序前数组
     * @param size 桶大小
     * @return 排序后数组
     */
    public static int[] bucketSort(int[] arr, int size) {
        int min = arr[0];
        int max = arr[0];
        int len = arr.length;

        // 计算出最大值和最小值,时间复杂度n,空间复杂度n
        for (int i = 1; i < len; i++) {
            min = min > arr[i] ? arr[i] : min;
            max = max < arr[i] ? arr[i] : max;
        }

        // 计算桶数量并初始化桶,时间复杂度n/size
        int num = (max - min + 1) / size;
        int[][] buckets = new int[num+1][size];

        // 时间复杂度K*N,空间复杂度N
        for (int data:arr) {
            // 选择要插入的桶
            int index = (data - min) /size;
            // 插入到桶内(插入排序),时间复杂度K,空间复杂度K
            bucketInsertSort(buckets[index], data);
        }

        // 把桶中的数据反写到arr里,时间复杂度n,空间复杂度n
        int point = 0;
        for (int[] bucket:buckets) {
            for (int data:bucket) {
                if (data != 0) {
                    arr[point++] = data;
                }
            }
        }

        return arr;
    }

    /**
     * 桶排序的桶内排序,时间复杂度N,空间复杂度N
     * @param bucket 桶
     * @param data 数据
     */
    private static void bucketInsertSort(int[] bucket, int data){
        // 要插入的数据位置,默认为最后
        int index = bucket.length;
        // 处理数组默认值0的影响,用链表不存在次步骤
        while (index > 0 && bucket[index - 1] == 0) {
            index --;
            if (index == 0) {
                bucket[0] = data;
            }
        }
        // 从右边向左边比较并移动数据
        while (index > 0 && bucket[index-1] > data) {
            bucket[index] = bucket[index-1];
            index --;
        }
        // 把数据插入到正确位置
        bucket[index] = data;
    }

    /**
     * 基数排序：计数排序升级版,时间复杂度K*N 空间复杂度K*N(可以优化到N)
     * 算法思路：对不同的位进行计数排序(低位-》高位),最终得出有序序列
     * 适用于数据服从均匀分布的情况,测试数据中不能有0(数组初始化默认值)
     * @param arr 待排序数组
     * @param len 子数组长度
     * @return 排序后数组
     */
    public static int[] radixSort(int[] arr, int len) {

        // 如果len不传,默认为数组长度
        len = len == 0 ? arr.length : len;

        // 找到最大值,时间复杂度n,空间复杂度n
        int max = arr[0];
        for(int data:arr) {
            max = data > max ? data : max;
        }

        int division = 10;
        // 判断循环次数,时间复杂度logN
        int count = 1;
        while (max/division > 0) {
            count ++;
            max = max/division;
        }

        division = 1;
        // 时间复杂度K(log10N*10)*N,空间复杂度n
        while (count-- > 0) {
            int[][] digits = new int[10][len];
            for (int data:arr) {
                //取出对应位上的数字
                int remainder = (data/division)%10;
                for (int j = 0; j < 10; j++) {
                    int k = len - 1;
                    // 消除数组初始化的默认值影响
                    while (k >= 0 && digits[j][k] == 0) {
                        k --;
                    }
                    // 装桶,数据追加到末尾,k + 1 < len 防止数组越界
                    if (k + 1 < len && j == remainder) {
                        digits[j][k + 1] = data;
                    }
                }
            }

            int point = 0;
            for (int[] digit:digits) {
                for (int data:digit) {
                    // 消除数组初始化的默认值影响
                    if (data != 0) {
                        arr[point++] = data;
                    }
                }
            }

            division *= 10;
        }
        return arr;
    }
}
