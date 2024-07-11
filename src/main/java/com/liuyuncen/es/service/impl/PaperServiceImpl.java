package com.liuyuncen.es.service.impl;

import com.liuyuncen.es.entity.Paper;
import com.liuyuncen.es.mapper.PaperMapper;
import com.liuyuncen.es.service.PaperService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @author xiang
 */
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {
}
