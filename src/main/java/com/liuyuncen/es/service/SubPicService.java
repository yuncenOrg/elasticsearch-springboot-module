package com.liuyuncen.es.service;

import com.liuyuncen.es.entity.SubPic;
import com.mybatisflex.core.service.IService;

import java.util.List;


/**
 * @author xiang
 */
public interface SubPicService extends IService<SubPic> {

    List<Integer> selectPicIdBySubId(Integer subId);

    List<String> selectUrlBySubId(Integer subId);
}
