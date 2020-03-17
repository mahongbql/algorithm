package com.algorithm.everyDay;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 *  
 *
 * 提示：
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 */
public class CountCharacters {

    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words, chars));;
    }

    private static int countCharacters(String[] words, String chars) {
        int nums = 0;

        //统计字符串中字母出现的频率
        char[] chs = count(chars);

        //遍历循环单词列表
        for(int i = 0; i < words.length; i++) {
            char[] wordsChs = count(words[i]);

            if(compare(wordsChs, chs)) {
                nums += words[i].length();
            }
        }

        return nums;
    }

    /**
     * 比较字符串中是否包含了单词
     * @param wordsChs 单词中字母出现的频率
     * @param chs 字符串中字母出现的频率
     * @return 是否包含
     */
    private static boolean compare(char[] wordsChs, char[] chs) {
        for(int i = 0; i < 26; i++) {
            if(chs[i] < wordsChs[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字母出现的频率
     * @param chars 需要解析的字符串
     * @return 频率数组
     */
    private static char[] count(String chars) {
        char[] chs = new char[26];
        for(int i = 0; i < chars.length(); i++) {
            chs[chars.charAt(i) - 'a']++;
        }

        return chs;
    }
}
