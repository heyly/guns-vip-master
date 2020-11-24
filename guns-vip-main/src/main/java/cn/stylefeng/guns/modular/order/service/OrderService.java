package cn.stylefeng.guns.modular.order.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.order.entity.Order;
import cn.stylefeng.guns.modular.order.model.params.OrderParam;
import cn.stylefeng.guns.modular.order.model.result.OrderResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 订单表  服务类
 * </p>
 *
 * @author 张
 * @since 2020-10-16
 */
public interface OrderService extends IService<Order> {

    /**
     * 新增
     *
     * @author 张
     * @Date 2020-10-16
     */
    void add(OrderParam param);

    /**
     * 删除
     *
     * @author 张
     * @Date 2020-10-16
     */
    void delete(OrderParam param);

    /**
     * 更新
     *
     * @author 张
     * @Date 2020-10-16
     */
    void update(OrderParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 张
     * @Date 2020-10-16
     */
    OrderResult findBySpec(OrderParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 张
     * @Date 2020-10-16
     */
    List<OrderResult> findListBySpec(OrderParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 张
     * @Date 2020-10-16
     */
     LayuiPageInfo findPageBySpec(OrderParam param);

}
