package com.liuyuncen.es.service;

import com.liuyuncen.es.entity.Subject;
import com.liuyuncen.es.vo.SearchPageVO;
import com.liuyuncen.es.vo.SubjectVO;
import com.mybatisflex.core.service.IService;

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

    /**
     * @description: 获取搜索结果数量
     * @author: Xiang想
     * @date: 2024/7/12 09:58
     * @param: [index, field, keyword]
     * @return: java.lang.Long
     **/
    Long getTotalHits(SearchPageVO searchPage);
}
