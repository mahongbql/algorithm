package com.algorithm.subject;

import java.util.*;

/**
 * @Auther: mahongbin
 * @Date: 2021-07-06 21:21
 * @Description:
 *
 * 通过化学表达式得到其中原子的数量
 *
 * 例1：H2O - H2O
 * 例2：Fe(OH)2 - FeH2O2
 * 例3：K4(ON(SO3)2)2 - K4N2O14S4
 *
 */
public class AtomsNum_726 {


    static int i, n;
    static String formala = "K4(ON(SO3)2)2";

    public static void main(String[] args) {
        System.out.println(getAtomsNum(formala));
    }

    static String getAtomsNum(String formala) {
        i = 0;
        n = formala.length();

        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        stack.push(map);

        while(i < n) {
            Character ch = formala.charAt(i);
            //字母为左括号时，表示进入一层map
            if(ch == '(') {
                i++;
                stack.push(new HashMap<>());
            }
            //字母为右括号时，表示当括号内的原子数应该被计算了，括号中的原子数量已经在栈顶部了
            else if(ch == ')') {
                i++;
                int num = parseNum();
                Map<String, Integer> m = stack.pop();
                Map<String, Integer> topMap = stack.peek();

                for(Map.Entry<String, Integer> entry : m.entrySet()) {
                    int value = entry.getValue();
                    String key = entry.getKey();

                    Integer topNum = topMap.get(key);
                    topMap.put(key, (topNum == null ? 0 : topNum) + value * num);
                }
            }
            //字母为数字和字母时
            else {
                String atom = parseStr();
                int num = parseNum();

                Map<String, Integer> topMap = stack.peek();
                Integer atomNum = topMap.get(atom);
                topMap.put(atom, (atomNum == null ? 1 : atomNum) * num);
            }
        }

        StringBuffer sb = new StringBuffer();
        TreeMap<String, Integer> rtnMap = new TreeMap<>(map);
        for(Map.Entry<String, Integer> m : rtnMap.entrySet()) {
            sb.append(m.getKey());
            if(m.getValue() > 1) sb.append(m.getValue());
        }

        return sb.toString();
    }

    /**
     * 计算字母
     * @return
     */
    private static String parseStr() {
        StringBuffer sb = new StringBuffer();
        sb.append(formala.charAt(i++));
        while(i < n && Character.isLowerCase(formala.charAt(i))) {
            sb.append(formala.charAt(i++));
        }

        return sb.toString();
    }

    /**
     * 计算括号外的数字
     * @return
     */
    private static int parseNum() {
        int num = 0;

        if(i >= n) return 1;

        while(i < n && Character.isDigit(formala.charAt(i))){
            num = num * 10 + formala.charAt(i++) - '0';
        }

        return num == 0 ? 1 : num;
    }
}
