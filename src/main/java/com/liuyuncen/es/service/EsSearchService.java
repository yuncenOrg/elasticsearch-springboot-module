package com.liuyuncen.es.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @belongsProject: elasticsearch-springboot-module
 * @belongsPackage: com.liuyuncen.es.service
 * @author: Xiang想
 * @createTime: 2024-07-10  17:33
 * @description: TODO
 * @version: 1.0
 */
public interface EsSearchService {
    /* 分页查询 */
    List<Map<String, Object>> searchSubject(String index,String field, String keyword, int pageNo, int pageSize) throws IOException;

}
