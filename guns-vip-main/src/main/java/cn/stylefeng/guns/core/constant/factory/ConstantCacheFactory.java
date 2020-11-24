package cn.stylefeng.guns.core.constant.factory;

import cn.stylefeng.guns.core.constant.cache.OrderCache;
import cn.stylefeng.guns.core.constant.cache.OrderCacheKey;
import cn.stylefeng.guns.modular.order.entity.Order;
import cn.stylefeng.guns.modular.order.mapper.OrderMapper;
import cn.stylefeng.roses.core.util.SpringContextHolder;
import cn.stylefeng.roses.core.util.ToolUtil;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/16 14:47
 * @description：
 * @modified By：
 * @version:
 */
@Component
@DependsOn("springContextHolder")
public class ConstantCacheFactory implements IConstantCacheFactory {

    private OrderMapper orderMapper = SpringContextHolder.getBean(OrderMapper.class);

    public static IConstantCacheFactory me() {
        return SpringContextHolder.getBean("constantCacheFactory");
    }

    @Override
    @Cacheable(value = "goods", key = "'"+OrderCacheKey.ORDER+"'+#id")
    public String getGoodsName(int id) {
        System.out.println("看看我运行了几次");
        Order order = orderMapper.selectById(id);
        if (ToolUtil.isNotEmpty(order)&&ToolUtil.isNotEmpty(order.getGoodsName())){
            return order.getGoodsName();
        }
        return "";
    }


}
