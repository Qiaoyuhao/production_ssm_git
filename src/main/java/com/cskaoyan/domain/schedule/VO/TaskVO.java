package com.cskaoyan.domain.schedule.VO;

import com.cskaoyan.domain.schedule.Manufacture;
import com.cskaoyan.domain.schedule.Task;
import com.cskaoyan.domain.schedule.Work;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 15:47 2018/9/4
 * @Modified By:
 */
public class TaskVO extends Task {

    private Manufacture manufacture;
    private Work work;


    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}
