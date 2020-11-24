package cn.stylefeng.guns.base;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Super张
 * @date ：Created in 2020-11-13 15:05
 * @description：
 * @modified By：
 * @version:
 */
public class DateTest {
        public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        BigInteger bigInteger = new BigInteger("1111111111111111111");
        List list = new ArrayList();
        list.add(bigInteger);
        BigInteger o = (BigInteger) list.get(0);
        Object[] objects = new Object[5];
        objects[0] = o;
        long l = o.longValue();
        System.out.println(l);
    }
}
