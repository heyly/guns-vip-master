package cn.stylefeng.guns.base;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/27 14:40
 * @description：
 * @modified By：
 * @version:
 */
public class   LambDataTest {
     interface Lambda{
          void print(String value);
     }

     public static void main(String[] args) {
//          test();
//          Lambda lambda = test2();
//          lambda.print("11");
     }

     private static Lambda test2() {
          //如果函数体只有一行可以这样简化
          return value -> System.out.println("我成功了嘛"+value);
     }

     private static void test() {
          Lambda lambda = (value) ->{
               System.out.println("我成功了嘛"+value);
          };
          lambda.print("11");
     }
}
