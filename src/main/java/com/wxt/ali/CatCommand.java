package com.wxt.ali;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用Java实现shell命令cat 1.log | grep a | sort | uniq -c | sort -rn
 */
public class CatCommand {
    private volatile int stag = 0;
    private List<String> lines = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        String path = "/Users/wuxiantao/log.txt";
        CatCommand catCommand = new CatCommand();
        catCommand.read(path);
        catCommand.grep();
        catCommand.sort();
        catCommand.uniq();
        catCommand.sortrn();

        while(true){
            if (catCommand.stag==5){
                catCommand.lines.stream().forEach(s -> System.out.println(s));
                break;
            }
        }

    }

    public void read(String path) throws Exception {
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            lines.add(str);
        }
        stag = 1;
    }
    public void grep() {
        new Thread(() -> {
            while (true) {
                if (stag == 1) {
                    lines = lines.stream().filter(s -> s.contains("a")).collect(Collectors.toList());
                    stag = 2;
                    break;
                }
            }
        }).start();
    }

    public void sort() {
        new Thread(() -> {
            while (true) {
                if (stag == 2) {
                    lines = lines.stream().sorted().collect(Collectors.toList());
                    stag = 3;
                    break;
                }
            }
        }).start();
    }

    public void uniq() {
        new Thread(() -> {
            while (true) {
                if (stag == 3) {
                    lines = lines.stream().distinct().collect(Collectors.toList());
                    stag = 4;
                    break;
                }
            }
        }).start();
    }

    public void sortrn() {
        new Thread(() -> {
            while (true) {
                if (stag == 4) {
                    lines = lines.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
                    stag = 5;
                    break;
                }
            }
        }).start();
    }
}
