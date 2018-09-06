package com.cskaoyan.service.schedule;

import com.cskaoyan.domain.schedule.Manufacture;
import com.cskaoyan.domain.schedule.VO.ManufactureVO;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: QiaoYuhao
 * @Description:
 * @Date: Created in 17:32 2018/8/31
 * @Modified By:
 */
public interface ManufactureService {

    List<ManufactureVO> findManufacture();

    boolean addManufacture(Manufacture manufacture);

    boolean deleteManufacture(Integer manufactureId);

    boolean updateManufacture(Manufacture manufacture);

    boolean updateManufactureSelective(Manufacture manufacture);

    List<ManufactureVO> findManufactureByCondition(HashMap map);

    boolean deleteManufactures(String[] ids) throws Exception;

    ManufactureVO findManufactureById(String manufactureSn);

}
