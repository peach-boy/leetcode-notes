package com.wxt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Case3 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a1");
        list.add("b222");
        list.add("bfdasfd");

        List<String> stringList = filterContainNumber(list);
    }


    public static List<String> filterContainNumber(List<String> list) {
        return list.stream().filter((str) -> {
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                if (Character.isDigit(c)) {
                    return false;
                }
            }

            return true;
        }).collect(Collectors.toList());
    }
}
