package cn.stylefeng.guns.base;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/28 14:18
 * @description：
 * @modified By：
 * @version:
 */
public class HmacSHA1Test {
    public static void main(String[] args) {
        String appKey = "Fv9OBN6ZjN63lPOzW7S4OJgb";
        String exchangeId = "20200427114603881000000000000008";
        String method = "/v1/helloworld";
        String timestamp = "1567135658634";
        //计算精确到秒的时间戳
        Date date  = new Date();
        timestamp = String.valueOf(date.getTime() );
        System.out.println(timestamp);
        String token = "ca6b21c5-68e4-4404-94c9-535eb88bbf69";
        String content = "content=IHsNCiJ0YXhObyIgOiAi57qz56iO5Lq66K+G5Yir5Y+3IiwNCiJlbnROYW1lIiA6ICLkvIHkuJrlkI3np7AiICAgICAgIA0KfQ0K";
        String key = "appKey="+appKey+
                "&exchangeId="+exchangeId+
                "&method="+method+
                "&timestamp="+timestamp+
                "&token="+token+
                "&content="+content;

        try {
            SecretKey hmacSHA1 = KeyGenerator.getInstance("HmacSHA1").generateKey();
            byte[] encoded = hmacSHA1.getEncoded();

            SecretKeySpec keySpec = new SecretKeySpec(encoded, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(keySpec);
            byte[] singBytes = mac.doFinal(key.getBytes("UTF-8"));
            String signStr = Base64.encodeBase64String(singBytes);
            signStr = URLEncoder.encode(signStr,"UTF-8");
            System.out.println(signStr);

        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
