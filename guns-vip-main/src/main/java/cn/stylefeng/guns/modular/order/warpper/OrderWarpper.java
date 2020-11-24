package cn.stylefeng.guns.modular.order.warpper;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.core.constant.factory.ConstantCacheFactory;
import cn.stylefeng.guns.sys.core.constant.factory.ConstantFactory;
import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/23 9:10
 * @description：
 * @modified By：
 * @version:
 */
public class OrderWarpper extends BaseControllerWrapper {

    public OrderWarpper(Map<String, Object> single) {
        super(single);
    }

    public OrderWarpper(List<Map<String, Object>> multi) {
        super(multi);
    }

    public OrderWarpper(Page<Map<String, Object>> page) {
        super(page);
    }

    public OrderWarpper(PageResult<Map<String, Object>> pageResult) {
        super(pageResult);
    }

    @Override
    protected void wrapTheMap(Map<String, Object> map) {
        map.put("sexName", ConstantFactory.me().getSexName((String)map.get("sex")));
        //这个方法是将bean对象转换成Map
//        BeanUtil.beanToMap(user);
    }
}
