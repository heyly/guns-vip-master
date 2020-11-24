package cn.stylefeng.guns.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/22 14:21
 * @description：
 * @modified By：
 * @version:
 */
@Component
@ConfigurationProperties(prefix = OrderProperties.PREFIX )
@Data
public class OrderProperties {
    public static final  String PREFIX = "order";

    private String name = "";

    private int age ;

    private String sex = "女";


}
