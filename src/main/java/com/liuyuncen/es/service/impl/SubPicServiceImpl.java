package com.liuyuncen.es.service.impl;

import com.liuyuncen.es.entity.Pic;
import com.liuyuncen.es.entity.SubPic;
import com.liuyuncen.es.mapper.SubPicMapper;
import com.liuyuncen.es.service.PicService;
import com.liuyuncen.es.service.SubPicService;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author xiang
 */
@Service
public class SubPicServiceImpl extends ServiceImpl<SubPicMapper, SubPic> implements SubPicService {

    @Autowired
    private PicService picService;
    @Override
    public List<Integer> selectPicIdBySubId(Integer subId) {
        List<SubPic> list = list(new QueryWrapper().select(SubPic::getPicId).eq(SubPic::getSubId, subId));
        return  list.stream().map(SubPic::getPicId).collect(Collectors.toList());
    }

    @Override
    public List<String> selectUrlBySubId(Integer subId) {
        List<Integer> Integers = selectPicIdBySubId(subId);
        if (Integers.size() == 0){
            return new ArrayList<String>();
        }
        QueryWrapper select = new QueryWrapper().<Pic>select(Pic::getPicUrl).<Pic>in(Pic::getId, Integers);
        return picService.list(select).stream().map(Pic::getPicUrl).collect(Collectors.toList());
    }
}
