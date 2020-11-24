package cn.stylefeng.guns.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/27 16:48
 * @description：
 * @modified By：
 * @version:
 */
public class Test {
    private static final Object LOGGER_MSG = "测试";
    private static Logger logger = LoggerFactory.getLogger(Test.class);
    private static final String Algorithm="DESede";

    public static void main(String[] args) {

    }
    public static byte[] encryptMode(String password,byte[]src){
        try{ // 生成密钥
            SecretKey deskey=new SecretKeySpec(password.getBytes(),Algorithm); // 加密
            Cipher c1= Cipher.getInstance(Algorithm);
            c1.init(Cipher.ENCRYPT_MODE,deskey);
            return c1.doFinal(src);
        }catch(Exception e){
            logger.error("{}加密出错,错误信息为:{}",LOGGER_MSG,e.getMessage());
        } return null;
    }


    public static byte[] decryptMode(String password,byte[]src)throws Exception {
        try {
            // 生成密钥
            SecretKey deskey = new SecretKeySpec(password.getBytes(), Algorithm); // 解密
            Cipher c1 = Cipher.getInstance(Algorithm);
            c1.init(Cipher.DECRYPT_MODE, deskey);
            return c1.doFinal(src);
        } catch (Exception e) {
            logger.error("{}解密出错,错误信息为:{}", LOGGER_MSG, e.getMessage());
            throw e;
        }
    }
}