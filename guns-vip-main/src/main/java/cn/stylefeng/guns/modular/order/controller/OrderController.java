package cn.stylefeng.guns.modular.order.controller;

import cn.stylefeng.guns.base.auth.annotion.Permission;
import cn.stylefeng.guns.base.auth.context.LoginContext;
import cn.stylefeng.guns.base.auth.context.LoginContextHolder;
import cn.stylefeng.guns.base.auth.model.LoginUser;
import cn.stylefeng.guns.base.log.BussinessLog;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.config.properties.OrderProperties;
import cn.stylefeng.guns.core.constant.cache.OrderCacheKey;
import cn.stylefeng.guns.core.constant.dictmap.OrderDict;
import cn.stylefeng.guns.core.constant.factory.ConstantCacheFactory;
import cn.stylefeng.guns.core.constant.factory.IConstantCacheFactory;
import cn.stylefeng.guns.modular.order.entity.Order;
import cn.stylefeng.guns.modular.order.model.params.OrderParam;
import cn.stylefeng.guns.modular.order.service.OrderService;
import cn.stylefeng.guns.sys.core.constant.factory.ConstantFactory;
import cn.stylefeng.guns.sys.core.log.LogObjectHolder;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import cn.stylefeng.roses.core.util.SpringContextHolder;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.validation.Valid;
import java.util.HashMap;


/**
 * 订单表控制器
 *
 * @author 张
 * @Date 2020-10-16 13:45:04
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    private Logger log = LoggerFactory.getLogger(OrderController.class);

    private String PREFIX = "/order";

    @Autowired
    private OrderService orderService;

    /**
     * 跳转到主页面
     *
     * @author 张
     * @Date 2020-10-16
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/order.html";
    }

    /**
     * 新增页面
     *
     * @author 张
     * @Date 2020-10-16
     */
    @RequestMapping("/add")
    @Permission
    public String add() {
        return PREFIX + "/order_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 张
     * @Date 2020-10-16
     */
    @RequestMapping("/edit")
    @Permission
    public String edit(@RequestParam Long id) {
        Order order = orderService.getById(id);

        LogObjectHolder.me().set(order);

        return PREFIX + "/order_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 张
     * @Date 2020-10-16
     */
    @RequestMapping("/addItem")
    @ResponseBody
    @BussinessLog(value = "添加订单", key = "userPhone", dict = OrderDict.class)
    public ResponseData addItem(OrderParam orderParam) {
        try {
            this.orderService.add(orderParam);
        } catch (Exception e) {
            log.error("订单新增异常", e);
        }
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 张
     * @Date 2020-10-16
     */
    @RequestMapping("/editItem")
    @ResponseBody
    @BussinessLog(value = "修改订单", key = "goodsName", dict = OrderDict.class)
    @CacheEvict(value = "goods", key = "'" + OrderCacheKey.ORDER + "'+#orderParam.getId()")
    public ResponseData editItem(OrderParam orderParam) {
        try {
            this.orderService.update(orderParam);
        } catch (Exception e) {
            log.error("订单编译异常", e);
        }
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 张
     * @Date 2020-10-16
     */
    @RequestMapping("/delete")
    @ResponseBody
    @Permission
    @BussinessLog(value = "删除订单", key = "userPhone", dict = OrderDict.class)
    @Cacheable(value = "goods", key = "'" + OrderCacheKey.ORDER + "'+#id")
    @CacheEvict(value = "goods", key = "'" + OrderCacheKey.ORDER + "'+#orderParam.getId()")
    public ResponseData delete(OrderParam orderParam) {
        this.orderService.delete(orderParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 张
     * @Date 2020-10-16
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(OrderParam orderParam) {
        Order detail = this.orderService.getById(orderParam.getId());
        return ResponseData.success(detail);
    }

    /**
     * 查询列表
     *
     * @author 张
     * @Date 2020-10-16
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(OrderParam orderParam) {
        //这里不需要对orderParam判空，因为即使是空值前台也会将属性对应成对象
        return orderService.findPageBySpec(orderParam);
    }

    /**
     * 查询名称
     *
     * @author 张
     * @Date 2020-10-16
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseData listAll(Order order) {

        String name = SpringContextHolder.getBean(OrderProperties.class).getName();
        System.out.println(name+"是张胜男");

        String goodsName = "";
        goodsName = ConstantCacheFactory.me().getGoodsName(order.getId());
        System.out.println("看看我运行了几次");
        new HashMap();
        return ResponseData.success(goodsName);
    }

}


