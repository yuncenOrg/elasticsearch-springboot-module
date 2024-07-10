package com.liuyuncen.es.service.impl;

import com.liuyuncen.es.entity.Subject;
import com.liuyuncen.es.mapper.SubjectMapper;
import com.liuyuncen.es.service.SubjectService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @author xiang
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    public Subject queryById(Long id) {
        return getById(id);
    }
}
