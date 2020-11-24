package cn.stylefeng.guns.base;

import java.util.*;

/**
 * @author ：Super张
 * @date ：Created in 2020-11-12 15:41
 * @description：
 * @modified By：
 * @version:
 */
public class TestMain {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        map.forEach((k,v) -> System.out.println(k+"vvv"+v));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
