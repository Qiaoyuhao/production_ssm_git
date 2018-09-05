package com.cskaoyan.domain.schedule.VO;

import com.cskaoyan.domain.schedule.COrder;
import com.cskaoyan.domain.schedule.Manufacture;
import com.cskaoyan.domain.technology.Technology;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 10:35 2018/9/4
 * @Modified By:
 */
public class ManufactureVO extends Manufacture {
//todo
    private Technology technology;
    private COrder cOrder;
//    private String orderId;
//    private String technologyName;


//todo
    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public COrder getCOrder() {
        return cOrder;
    }

    public void setCOrder(COrder cOrder) {
        this.cOrder = cOrder;
    }

//    @Override
//    public String getOrderId() {
//        return orderId;
//    }
//
//    @Override
//    public void setOrderId(String orderId) {
//        this.orderId = orderId;
//    }

//    public String getTechnologyName() {
//        return technologyName;
//    }
//
//    public void setTechnologyName(String technologyName) {
//        this.technologyName = technologyName;
//    }
}
