package cn.stylefeng.guns.modular.order.mapper;

import cn.stylefeng.guns.modular.order.entity.Order;
import cn.stylefeng.guns.modular.order.model.params.OrderParam;
import cn.stylefeng.guns.modular.order.model.result.OrderResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 订单表  Mapper 接口
 * </p>
 *
 * @author 张
 * @since 2020-10-16
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 获取列表
     *
     * @author 张
     * @Date 2020-10-16
     */
    List<OrderResult> customList(@Param("paramCondition") OrderParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 张
     * @Date 2020-10-16
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") OrderParam paramCondition);

    /**
     * 获取分页实体列表,如果要sql分页的话需要将第一个参数写为page对象，这样他会拦截sql，进行重写
     *
     * @author 张
     * @Date 2020-10-16
     */
    Page<OrderResult> customPageList(@Param("page") Page page, @Param("paramCondition") OrderParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 张
     * @Date 2020-10-16
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") OrderParam paramCondition);

}
