package com.wxt;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Case1_s2 {
    private ConcurrentHashMap<String, Long> map = new ConcurrentHashMap();
    private final static int offset = 5;
    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));

    public static void main(String[] args) throws Exception {
        String[] strArray = {"a", "b", "c", "c", "b", "a", "a", "e", "g", "a", "h", "g", "b", "t", "a", "a", "a", "c", "a", "b"};
        List list = Arrays.asList(strArray);
        Case1_s2 case1_s2 = new Case1_s2();
        case1_s2.toSortMap(list);
        case1_s2.sortMapByValue(case1_s2.map);
        System.out.println(JSON.toJSONString(case1_s2.map));

    }

    public void toSortMap(List<String> list) throws Exception {
        List<List<String>> listList = Lists.partition(list, offset);
        int threadNum = listList.size();
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (List subList : listList) {
            threadPoolExecutor.submit(() -> execute(subList, countDownLatch));
        }

        countDownLatch.await();
        threadPoolExecutor.shutdown();
    }

    public void execute(List<String> list, CountDownLatch countDownLatch) {
        try {
            for (String str : list) {
                Long value = map.get(str);
                if (value == null) {
                    map.put(str, 1L);
                } else {
                    map.put(str, value + 1L);
                }
            }
        } finally {
            countDownLatch.countDown();
        }
    }

    public void sortMapByValue(Map<String, Long> map) {
        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
