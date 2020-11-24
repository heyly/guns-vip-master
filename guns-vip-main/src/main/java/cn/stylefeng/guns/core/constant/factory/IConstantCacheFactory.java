package cn.stylefeng.guns.core.constant.factory;

/**
 * @author ：Teacher陈
 * @date ：Created in 2020/10/16 15:04
 * @description：
 * @modified By：
 * @version:
 */
public interface IConstantCacheFactory {
    /**
     * 通过订单id获取商品名称
     *
     */
    String getGoodsName(int id);
}
