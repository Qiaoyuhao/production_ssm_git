package com.cskaoyan.domain.schedule.VO;

import com.cskaoyan.domain.schedule.COrder;
import com.cskaoyan.domain.schedule.Custom;
import com.cskaoyan.domain.schedule.Product;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:13 2018/9/4
 * @Modified By:
 */
public class COrderVO extends COrder {

    private Custom custom;
    private Product product;


    public Custom getCustom() {
        return custom;
    }

    public void setCustom(Custom custom) {
        this.custom = custom;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
