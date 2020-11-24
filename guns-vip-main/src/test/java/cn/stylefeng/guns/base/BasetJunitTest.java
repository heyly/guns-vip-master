package cn.stylefeng.guns.base;

import javax.crypto.spec.SecretKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/27 17:03
 * @description：
 * @modified By：
 * @version:
 */
public class BasetJunitTest {
    public static void main(String[] args) {
        String timeStr = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        System.out.println(timeStr);
        Random random = new Random();
        long l = random.nextLong();
        String src = String.valueOf(l);
        String substring = src.substring(src.length() - 15, src.length());
        System.out.println(timeStr+substring);

//        Base64Test base64Test = new Base64Test();
        //加密
        try {
            String content = Base64Test.encode("南京弘阳商业管理有限公司");
            System.out.println("加密\n"+content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //解密
        try {
            String s = Base64Test.decodeToString(
                    "eyJLU0hTIjoxMCwiWlRYWCI6IuWkhOeQhuaIkOWKnyIsIkJDUVFGSEhTIjowLCJaSFMiOjAsIlpURE0iOiIwMDAwIiwiRlBaSFhYIjpbXX0=");
            System.out.println("解密"+s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
