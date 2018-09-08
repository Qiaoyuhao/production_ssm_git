package com.cskaoyan.mapper.material;



import com.cskaoyan.domain.material.MaterialReceive;

import java.util.List;

public interface MaterialReceiveMapper {


    List<MaterialReceive> selectAllReceive();

    MaterialReceive selectReceiveById(String receiveId);

    void insertReceive(MaterialReceive materialReceive);

    int editReceive(MaterialReceive materialReceive);

    void deleteReceive(String id);

}
