package com.java.advanced;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ConvarDemo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h1;// 双色球
        int h;// 大乐透
        System.out.println("1.双色球,2.超级大乐透");
        System.out.println("请选择打印彩票的种类:");
        h1 = scanner.nextInt();
        System.out.println("打几注？");
        h = scanner.nextInt();
        for (int q = 0; q < h; q++) {
            Integer array1[] = {};// 因为数组大小不确定 所以没有直接指定数组大小， 可以改为集合
            Set<Integer> set = new HashSet<>();
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                if (h1 == 1) {
                    int rand = random.nextInt(33) + 1;
                    set.add(rand);
                    if (set.size() == 7) {
                        break;
                    }
                } else {
                    int rand = random.nextInt(35) + 1;
                    set.add(rand);
                    if (set.size() == 6) {
                        break;
                    }
                }
                array1 = set.toArray(array1);
                for (int j = 0; j < array1.length - 1; j++) {
                    for (int k = 0; k < array1.length - 1 - j; k++) {
                        int temp;
                        if (array1[k] > array1[k + 1]) {
                            temp = array1[k];
                            array1[k] = array1[k + 1];
                            array1[k + 1] = temp;
                        }
                    }
                }
            }
            System.out.print("[");
            for (int i = 0; i < array1.length; i++) {
                System.out.print(array1[i] + " ");
            }
            System.out.print("]");

            Set<Integer> set1 = new HashSet<>();
            Integer array[] = {};

            if (h1 == 1) {
                for (int sa = 0; sa < 100; sa++) {
                    int rand2 = random.nextInt(16) + 1;
                    set1.add(rand2);
                    if (set1.size() == 1) {
                        break;
                    }
                }
            } else {
                for (int sb = 0; sb < 100; sb++) {
                    int rand3 = random.nextInt(12) + 1;
                    set1.add(rand3);
                    if (set1.size() == 2) {
                        break;
                    }
                }
            }

            array = set1.toArray(array);

            System.out.print("[");
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[j]+" ");
            }
            System.out.print("]");
            System.out.println();
        }

    }

}
