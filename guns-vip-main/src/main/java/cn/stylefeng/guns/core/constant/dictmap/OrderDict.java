package cn.stylefeng.guns.core.constant.dictmap;

import cn.stylefeng.guns.base.dict.AbstractDictMap;

/**
 * @author ：Super张
 * @date ：Created in 2020/10/16 14:08
 * @description：
 * @modified By：
 * @version:
 */
public class OrderDict extends AbstractDictMap {
    @Override
    public void init() {
        put("id","主键");
        put("goodsName","商品名称");
        put("place","下单地点");
        put("createTime","下单时间");
        put("userName","下单用户名称");
        put("userPhone","下单用户电话");
    }

    @Override
    protected void initBeWrapped() {

    }
}
