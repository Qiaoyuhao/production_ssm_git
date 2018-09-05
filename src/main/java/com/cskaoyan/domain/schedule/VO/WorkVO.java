package com.cskaoyan.domain.schedule.VO;

import com.cskaoyan.domain.device.Device;
import com.cskaoyan.domain.schedule.Product;
import com.cskaoyan.domain.schedule.Work;
import com.cskaoyan.domain.technology.Process;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:48 2018/9/3
 * @Modified By:
 */
public class WorkVO extends Work {

    public WorkVO() {
    }


    private Product product;
    private Device device;
    private Process process;
    private String productName;
    private String deviceName;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }
}
