package com.algorithm.subject;

import java.util.*;

/**
 * @Auther: mahongbin
 * @Date: 2021-07-18 18:24
 * @Description: 面试题 10.02. 变位词组
 *
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 *
 * [["ray"],["cod"],["abe"],["ned","den"],["arc"],["jar"],["owl","woo"],["pop"],["paw"],["sky"],["yup","yup","pup"],["fed","fee"],["jul"],["ado"],["why"],["ben"],["mys"],["dem"],["fat"],["you"],["eon"],["sui"],["oct"],["asp"],["ago"],["lea"],["sow"],["hus"],["eve"],["red"],["flo"],["ids"],["tic"],["hag"],["ito"],["zoo"]]
 *
 */
public class ChangePlaceWord {

    public static void main(String[] args) {
        String[] strs = {"boo","bob"};
        List<List<String>> list = groupAnagrams(strs);
        System.out.println(list);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

}
