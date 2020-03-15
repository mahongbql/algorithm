package com.algorithm;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = 24, nums = 0, i = 0;

        if(n == 1 && arr[0] == target) {
            System.out.println(1);
            return;
        }

        List<Integer> list = new ArrayList<>();
        while(i < n) {
            int num = target - arr[i];
            boolean status = true;
            while(status) {
                if(list.contains(num)) {
                    nums++;
                    list.remove(list.indexOf(num));
                } else {
                    status = false;
                }
            }

            list.add(arr[i++]);
        }
        System.out.println(nums);
    }
}
