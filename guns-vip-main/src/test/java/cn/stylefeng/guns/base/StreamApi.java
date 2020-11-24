package cn.stylefeng.guns.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/27 14:58
 * @description：
 * @modified By：
 * @version:
 */
public class StreamApi {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Monday","Tuesday","Wednesday","Thursday","friday","Saturday","Sunday");

//        for (String s : list) {
//            if (s.startsWith("T")){
//                String temp = s.toUpperCase();
//            }
//        }
        //1.list.stream();将list转换成stream流
        //2.filter() 过滤出 s字符串以 T开头的
        //3 map进过滤出来的属性进行存储，转换成大写
        //4.sorted()对其排序
        //5.
       List<String> t = list.stream().filter(s -> s.startsWith("T")).map(String::toUpperCase).sorted().collect(Collectors.toList());

        System.out.println(t);


    }
}
