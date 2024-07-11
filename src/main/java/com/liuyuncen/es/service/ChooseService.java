package com.liuyuncen.es.service;

import com.liuyuncen.es.entity.Choose;
import com.mybatisflex.core.service.IService;

import java.util.List;


/**
 * @author xiang
 */
public interface ChooseService extends IService<Choose> {

    List<Choose> listBySubjectId(Integer subjectId);

}
