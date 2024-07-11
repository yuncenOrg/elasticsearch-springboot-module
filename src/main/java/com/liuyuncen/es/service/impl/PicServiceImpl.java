package com.liuyuncen.es.service.impl;

import com.liuyuncen.es.entity.Pic;
import com.liuyuncen.es.mapper.PicMapper;
import com.liuyuncen.es.service.PicService;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @author xiang
 */
@Service
public class PicServiceImpl extends ServiceImpl<PicMapper, Pic> implements PicService {
}
