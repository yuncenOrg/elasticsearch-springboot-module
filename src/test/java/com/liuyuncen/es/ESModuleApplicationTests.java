package com.liuyuncen.es;


import com.liuyuncen.es.entity.Subject;
import com.liuyuncen.es.service.EsSearchService;
import com.liuyuncen.es.service.impl.SubjectServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ESModuleApplicationTests {

    @Autowired
    private EsSearchService esSearchService;


    @Autowired
    private SubjectServiceImpl subjectService;

    @Test
    void connMySQLTest() {
        Subject subject = subjectService.queryById(1L);
        System.out.println("subject = " + subject);
    }

    @Test
    void connESTest() {
        try {
            List<Map<String, Object>> maps = esSearchService.searchSubject("s_subject", "sub_title","信息", 1, 2);
            for (Map<String, Object> map : maps) {
                // 遍历map
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if ("id".equals(entry.getKey())) {
                        System.out.println(entry.getKey() + ":" + entry.getValue());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
