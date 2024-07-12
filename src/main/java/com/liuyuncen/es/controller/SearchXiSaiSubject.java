package com.liuyuncen.es.controller;

import com.liuyuncen.es.service.SubjectService;
import com.liuyuncen.es.tool.api.R;
import com.liuyuncen.es.vo.SearchPageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/search")
public class SearchXiSaiSubject {

    @Autowired
    private SubjectService subjectService;

    @GetMapping("/searchSubject")
    @ResponseBody
    public R<Map<String,Object>> searchSubjects(SearchPageVO searchPageVO){
        Map<String,Object> map = new HashMap<>();
        Long totalHits = subjectService.getTotalHits(searchPageVO);
        map.put("total",totalHits);
        map.put("data",subjectService.searchByTitle(searchPageVO));
        return R.data(map);
    }
}
