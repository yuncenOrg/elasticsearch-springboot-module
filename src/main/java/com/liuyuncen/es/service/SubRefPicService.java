package com.liuyuncen.es.service;

import com.liuyuncen.es.entity.SubRefPic;
import com.mybatisflex.core.service.IService;

import java.util.List;


/**
 * @author xiang
 */
public interface SubRefPicService extends IService<SubRefPic> {

    List<Integer> selectRefPicIdBySubId(Integer subId);

    List<String> selectUrlBySubId(Integer subId);
}
