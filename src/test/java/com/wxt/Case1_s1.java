package com.wxt;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 *
 */
public class Case1_s1 {
    private final static int offset = 5;

    public static void main(String[] args) throws Exception {
        String[] strArray = {"a", "b", "c", "c", "b", "a", "a", "e", "g", "a", "h", "g", "b", "t", "a", "a", "a", "c", "a", "b"};
        List list = Arrays.asList(strArray);
        Map<String, Long> map = toNumMap(list);

        Map<String, Long> result = sortMap(map);
        System.out.println(JSON.toJSONString(result));
    }

    public static Map<String, Long> toNumMap(List<String> list) throws Exception {
        List<List<String>> listList = Lists.partition(list, offset);
        int threadNum = listList.size();

        ExecutorService executorService = Executors.newFixedThreadPool(threadNum);
        List<Callable<Map<String, Long>>> callableList = new ArrayList<>();
        for (List subList : listList) {
            callableList.add(() -> buildMap(subList));
        }
        List<Future<Map<String, Long>>> futureList = executorService.invokeAll(callableList);

        Map<String, Long> resultMap = new HashMap<>();
        for (Future<Map<String, Long>> future : futureList) {
            Map<String, Long> map = future.get();
            map.forEach((key, value) -> resultMap.merge(key, value, (v1, v2) -> v1+v2));
        }

        executorService.shutdown();
        return resultMap;
    }


    public static Map<String, Long> buildMap(List<String> list) {
        Map<String, Long> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            Long value = map.get(str);
            //包含此key
            if (value != null) {
                map.put(str, value + 1);
            } else {
                map.put(str, 1l);
            }
        }

        return map;
    }

    public static Map<String, Long> sortMap(Map<String, Long> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
