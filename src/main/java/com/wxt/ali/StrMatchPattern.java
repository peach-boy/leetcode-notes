package com.wxt.ali;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 面试题1
 * 有一个字符串它的构成是词+空格的组合，如“北京 杭州 杭州 北京”， 要求输入一个匹配模式（简单的以字符来写）.
 * 比如 aabb,来判断该字符串是否符合该模式， 举个例子：
 * <p>
 * pattern = “abba”, str=”北京 杭州 杭州 北京” 返回 ture
 * pattern = “aabb”, str=”北京 杭州 杭州 北京” 返回 false
 * pattern = “baab”, str=”北京 杭州 杭州 北京” 返回 ture
 */
public class StrMatchPattern {
    public static void main(String[] args) {
        String str = "上海 杭州 杭州 上海 武汉";
        String pattern = "abba";
        Boolean result = match(str, pattern);
        System.out.println(result);
    }

    public static boolean match(String str, String pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        String[] strArray = str.split(" ");
        if (strArray.length != pattern.length()) {
            return false;
        }
        Map<Character, String> patternStrMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char p = pattern.charAt(i);
            String s = strArray[i];

            boolean isContainKey = patternStrMap.containsKey(p);
            if (!isContainKey) {
                patternStrMap.put(p, s);
            } else {
                if (!Objects.equals(patternStrMap.get(p), s)) {
                    return false;
                }
            }
        }
        return true;
    }
}
