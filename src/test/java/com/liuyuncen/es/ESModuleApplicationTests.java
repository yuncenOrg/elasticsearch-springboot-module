package com.liuyuncen.es;


import com.liuyuncen.es.service.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ESModuleApplicationTests {

    @Autowired
    private DemoService demoService;

    @Test
    void contextLoads() {
        try {
            List<Map<String, Object>> maps = demoService.searchSubject("s_subject", "sub_title","信息", 1, 2);
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
