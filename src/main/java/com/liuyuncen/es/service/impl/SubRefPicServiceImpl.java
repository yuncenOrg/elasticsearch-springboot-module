package com.liuyuncen.es.service.impl;

import com.liuyuncen.es.entity.Pic;
import com.liuyuncen.es.entity.SubRefPic;
import com.liuyuncen.es.mapper.PicMapper;
import com.liuyuncen.es.mapper.SubRefPicMapper;
import com.liuyuncen.es.service.PicService;
import com.liuyuncen.es.service.SubRefPicService;
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
public class SubRefPicServiceImpl extends ServiceImpl<SubRefPicMapper, SubRefPic> implements SubRefPicService {

    @Autowired
    private PicService picService;
    @Override
    public List<Integer> selectRefPicIdBySubId(Integer subId) {
        List<SubRefPic> list = list(new QueryWrapper().select(SubRefPic::getPicId).eq(SubRefPic::getSubId, subId));
        return  list.stream().map(SubRefPic::getPicId).collect(Collectors.toList());
    }

    @Override
    public List<String> selectUrlBySubId(Integer subId) {
        List<Integer> Integers = selectRefPicIdBySubId(subId);
        if (Integers.size() == 0){
            return new ArrayList<String>();
        }
        QueryWrapper select = new QueryWrapper().<Pic>select(Pic::getPicUrl).in(Pic::getId, Integers);
        return picService.list(select).stream().map(Pic::getPicUrl).collect(Collectors.toList());
    }
}
