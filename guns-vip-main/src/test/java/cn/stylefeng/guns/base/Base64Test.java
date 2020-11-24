package cn.stylefeng.guns.base;

import org.apache.commons.codec.binary.Base64;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/27 16:55
 * @description：
 * @modified By：
 * @version:
 */
public class Base64Test {

    /**
     * BASE64 加密
     * String==>String
     * @paramkey
     * @return
     * @throwsException */
    public static String encode(String key)throws Exception {
        return new String(encode(key.getBytes("UTF-8")));
    }

    /**
     * @Title:encode(base64 加密)
     * @Description ：BASE64 加密
     * @param@paramres
     * @param@return
     * @returnbyte[]
     * @exception
     **/
    public static byte[]encode(byte[]res){
        return Base64.encodeBase64(res);
    }


    /**
     * BASE64 解密
     * String==>String
     * @paramkey
     * @return
     * @throwsException
     * */
    public static String decodeToString(String key)throws Exception{
        return new String(decode(key.getBytes("UTF-8")),"UTF-8");
    }


    /**
     * @Title:decode(base64 解密)
     * @Description ：base64 解密
     * @param@paramstr
     * @param@return
     * @returnbyte[]
     * @exception
     * */
    public static byte[] decode(byte[]key){
        return Base64.decodeBase64(key);
    }


    /**
     * BASE64 解密
     * String==>byte
     * @paramkey
     *@return *@throwsException */
    public static byte[]decode(String key)throws Exception{
        return decode(key.getBytes("UTF-8"));
    }

}
