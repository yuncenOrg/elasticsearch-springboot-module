package com.liuyuncen.es.service;

import com.liuyuncen.es.entity.Subject;
import com.liuyuncen.es.vo.SearchPageVO;
import com.liuyuncen.es.vo.SubjectVO;
import com.mybatisflex.core.service.IService;

import java.io.IOException;
import java.util.List;


/**
 * @author xiang
 */
public interface SubjectService extends IService<Subject> {

    /**
     * 查询 s_subject
     * @return s_subject
     */
    Subject queryById(Long id);

    /**
     * 查询返回题库
     * @param searchPage 查询条件
     * @return 题库
     */
    List<SubjectVO> searchByTitle(SearchPageVO searchPage);
}
