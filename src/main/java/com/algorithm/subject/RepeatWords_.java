package com.algorithm.subject;

import java.util.*;

/**
 * 单词重复的前 n 个
 *
 * ["arr", "length", "arr", "ok", "ok", "ok"]
 * n = 2
 *
 * 输出：["ok", "arr"]
 *
 *
 */
public class RepeatWords_ {

    public static void main(String[] args) {
        String[] arr = {"arr", "length", "arr", "ok", "ok", "ok"};
        int n = 2;

        repeatWords(arr, n);
    }

    private static void repeatWords(String[] arr, int n) {
        if(arr.length < 1) return;
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String str : arr) {
            Integer num = map.get(str);
            if(null == num) num = 0;
            num++;
            map.put(str, num);
        }

        LinkedList sortList = new LinkedList<>();

        map.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(n)
                .forEach(entry -> sortList.add(entry.getKey()));

        System.out.println(sortList);
    }
}
