package cn.stylefeng.guns.base;

import cn.stylefeng.guns.GunsApplication;
import cn.stylefeng.guns.base.auth.jwt.JwtTokenUtil;
import cn.stylefeng.guns.base.auth.jwt.payload.JwtPayLoad;
import cn.stylefeng.guns.sys.modular.system.entity.User;
import cn.stylefeng.guns.sys.modular.system.mapper.UserMapper;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.util.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/27 10:58
 * @description：
 * @modified By：
 * @version:
 */
@SpringBootTest(classes = {GunsApplication.class})
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class JWTTest {
//
//    @Autowired
//    UserService userService;

    @Test
    public void test1(){
        UserService userService = SpringContextHolder.getBean(UserService.class);
        System.out.println(userService.getByAccount("admin"));
        User user = userService.getByAccount("admin");
        if (user != null) {
            JwtPayLoad jwtPayLoad = new JwtPayLoad(user.getUserId(), user.getAccount(), "xxx");
            String token = JwtTokenUtil.generateToken(jwtPayLoad);
            System.out.println(token+"查看token值");

            JwtPayLoad jwtPayLoad1 = JwtTokenUtil.getJwtPayLoad(token);
        }
    }

    @Test
    public void test2(){
//        String val = "1";
//        LambDataTest lambDataTest = value -> {
//            System.out.println(val);
//            System.out.println("1111");
//        };
//        lambDataTest.print("2");
    }
}
