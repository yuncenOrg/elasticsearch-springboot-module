package com.liuyuncen.es.service.impl;

import com.liuyuncen.es.entity.Choose;
import com.liuyuncen.es.mapper.ChooseMapper;
import com.liuyuncen.es.service.ChooseService;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author xiang
 */
@Service
public class ChooseServiceImpl extends ServiceImpl<ChooseMapper, Choose> implements ChooseService {
    @Override
    public List<Choose> listBySubjectId(Integer subjectId) {
        return list(new QueryWrapper().eq(Choose::getSubId, subjectId).orderBy(Choose::getId,true));
    }
}
