package com.liuyuncen.es;


import com.liuyuncen.es.entity.Subject;
import com.liuyuncen.es.service.EsSearchService;
import com.liuyuncen.es.service.SubPicService;
import com.liuyuncen.es.service.SubRefPicService;
import com.liuyuncen.es.service.SubjectService;
import com.liuyuncen.es.service.impl.SubjectServiceImpl;
import com.liuyuncen.es.vo.SearchPageVO;
import com.liuyuncen.es.vo.SubjectVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DBModuleApplicationTests {

    @Autowired
    private SubRefPicService subRefPicService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubPicService subPicService;

    @Test
    void lambdaQueryDbTest() {
        List<String> refUrls = subRefPicService.selectUrlBySubId(16);
        List<String> urls = subPicService.selectUrlBySubId(16);
    }


    @Test
    void esSearchXiSaiTest(){

        SearchPageVO searchPageVO = new SearchPageVO();
        searchPageVO.setPageNo(0);
        searchPageVO.setPageSize(10);
        searchPageVO.setKeywords("信息");
        try {
            long startTime = System.currentTimeMillis();
            List<SubjectVO> subjectVOS = subjectService.searchByTitle(searchPageVO);
            long endTime = System.currentTimeMillis();
            System.out.println("查询耗时：" + (endTime - startTime) + "ms");
            System.out.println("subjectVOS = " + subjectVOS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
