package cn.stylefeng.guns.modular.api.controller;

import cn.stylefeng.guns.core.base64.Base64Util;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author ：Super张
 * @date ：Created in 2020-10-29 16:16
 * @description：
 * @modified By：
 * @version:
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    //url前缀
    private final String URLPREFIX = "https://sandbox.ele-cloud.com/api/dxhy-open-income";

    private static final Logger log = LoggerFactory.getLogger(ApiController.class);

    private static final String BUSINESS_NAME = "api";

    private final String PREFIX = "/api";

    @Autowired
    private HttpServletRequest request;



    //访问api页面
    @RequestMapping("")
    public String index(){
        return PREFIX+"/api.html";
    }


    @RequestMapping(value = "/requestApi")
    @ResponseBody
    public String requestApi(HttpSession session,@RequestParam Map<String,String> requestMap) throws Exception {
//        System.out.println(requestMap+"requestMap");

//        String url = "https://sandbox.ele-cloud.com/api/dxhy-open-income/v1/getMainInvoice";
        String url = requestMap.get("apiPath");
//        log.info("访问的【url】路径"+url);
        String accessToken = (String) session.getAttribute("access_token");
        if (accessToken == null || accessToken.equals("")) {
            accessToken = getToken();//去获取token
        }
        url = url + "?access_token=" + accessToken;
        log.info("查看拼接的url地址"+url);
        String content = requestMap.get("content");
//        content = "{\n" +
//                "        \"GMFSBH\": \"9111122223333CKFPT\",\n" +
//                "        \"PCH\": \"12345678901234567890123456789012\",\n" +
//                "        \"CJKSRQ\": \"20170101010130\",\n" +
//                "        \"CJJSRQ\": \"20170101010230\",\n" +
//                "        \"KSHS\": 10,\n" +
//                "        \"ZTBZ\": \"1\"\n" +
//                "    }";
        log.info("打印请求参数"+content);
        String s = requestApi(content, url);
        log.info("接口返回的结果:"+s);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String str = objectMapper.writeValueAsString(s);
        System.out.println(str);

        return s;
    }

    //post访问
    public String requestApi(String requestContent, String url) throws Exception {
        if (url == null || url.equals("")){
            return "当前url路径为空";
        }
        //对传递过来的数据进行base64加密
        String encodeContent = encode(requestContent);
        //工共报文请求转JSON格式
        String commonContent = contentToJson(encodeContent);
        //去请求url  返回结果
        ResponseEntity<String> response = requestUrl(url, commonContent);

        Map<String, Object> responseMap = JSONObject.parseObject(response.getBody(), Map.class);
        //先判断返回的数据结果
        //获取returnStateInfo中的状态
        Map<String,String> returnStateInfo = (Map) responseMap.get("returnStateInfo");
//        判断返回的状态码是否成功，是否是正确的状态码  0000成功 其余都是失败
        if (returnStateInfo.get("returnCode").equals("0000")) {
            //解密前数据
            String decodeBeforeContent = (String) responseMap.get("content");
            //解密后
            String content = Base64Util.decodeToString(decodeBeforeContent);
            return content;
        } else {
            String returnMessage = returnStateInfo.get("returnMessage");
            //解密
            returnStateInfo.replace("returnMessage", Base64Util.decodeToString(returnMessage));
            return JSONObject.toJSONString(returnStateInfo);
        }
        //将数据放到
    }

    //base64加密
    private static String encode(String content) {
        //1.对context进行base64加密
        Base64Util base64Util = new Base64Util();
        String encodeContent = "";
        try {
            //base64加密处理
            encodeContent = base64Util.encode(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encodeContent;
    }

    //创建工共报文
    private String contentToJson(String encode) {
        Map<String, String> map = new HashMap<>();
        map.put("zipCode", "0");
        map.put("encryptCode", "0");
        //根据时间YYYYMMMHHSSSS+15随机数
        String timeStr = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        String randomNum = String.valueOf(new Random().nextLong());
        //生成随机流水号
        String dataStr = timeStr + randomNum.substring(randomNum.length() - 15, randomNum.length());
        map.put("dataExchangeId", dataStr);//随机数
        map.put("entCode", "");
        map.put("content", encode);
        return JSONObject.toJSONString(map);
    }


    //请求url
    private ResponseEntity<String> requestUrl(String url, String commonContent) {
        //获取请求头
        HttpHeaders headers = new HttpHeaders();
        //设置方法为post请求
        HttpMethod httpMethod = HttpMethod.POST;
        //设置JSON格式
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> requestEntity = new HttpEntity<String>(commonContent, headers);
        RestTemplate restTemplate = new RestTemplate();
        //执行请求
        return restTemplate.exchange(url, httpMethod, requestEntity, String.class);
    }

    //获取token
    private String getToken() throws Exception {
        //获取token路径
        String tokenUrl = "https://sandbox.ele-cloud.com/api/authen/token";
        //沙箱环境下的key和secret
        String appKey = "Mlfs7n9kofqPMaNVJSFoDcwS";
        String appSecret = "awSW7gts8AS4StGV84HCKVCf";
        Map<String, String> map = new HashMap<>();
        map.put("appKey", appKey);
        map.put("appSecret", appSecret);
        String content = JSONObject.toJSONString(map);
        //请求获取token
        ResponseEntity<String> responseEntity = requestUrl(tokenUrl, content);
        //String转map
        Map<String, String> bodyMap = JSONObject.parseObject(responseEntity.getBody(), Map.class);
        //拿到token
        String accessToken = bodyMap.get("access_token");
        log.info("返回的【accessToken】结果: "+accessToken);
        //获取request
        HttpSession session = request.getSession();
        //将拿到的token放至到session中
        session.setAttribute("access_token", accessToken);
        return accessToken;
    }

}

