package com.liuyuncen.es.service.impl;

import com.liuyuncen.es.service.EsSearchService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @belongsProject: elasticsearch-springboot-module
 * @belongsPackage: com.liuyuncen.es.service.impl
 * @author: Xiang想
 * @createTime: 2024-07-10  17:34
 * @description: TODO
 * @version: 1.0
 */
@Service
public class EsSearchServiceImpl implements EsSearchService {

    @Autowired
    private RestHighLevelClient client;

    @Override
    public List<Map<String, Object>> searchSubject(String index, String field, String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo <= 1) {
            pageNo = 1;
        }
        // 搜索
        SearchRequest searchRequest = new SearchRequest(index);

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field(field); // 需要高亮的字段名
        highlightBuilder.preTags("<lr>"); // 高亮开始标签
        highlightBuilder.postTags("</lr>"); // 高亮结束标签
        searchSourceBuilder.highlighter(highlightBuilder);

        // 分页设置
        searchSourceBuilder.from((pageNo - 1) * pageSize);
        searchSourceBuilder.size(pageSize);
        QueryBuilder builder = QueryBuilders.matchQuery(field , keyword);
        searchSourceBuilder.query(builder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        // 执行搜索
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        ArrayList<Map<String, Object>> list = new ArrayList<>();
        SearchHit[] hits = searchResponse.getHits().getHits();
        for (SearchHit hit : hits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            // 处理高亮
            Map<String, HighlightField> highlightFields = hit.getHighlightFields();
            HighlightField highlight = highlightFields.get(field);
            StringBuilder stringBuilder = new StringBuilder();
            for (Text fragment : highlight.getFragments()) {
                stringBuilder.append(fragment);
            }
            sourceAsMap.put("sub_title",stringBuilder.toString());
            list.add(sourceAsMap);
        }

        return list;
    }

    @Override
    public long getTotalHits(String index, String field, String keyword) throws IOException {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 设置查询条件，这里以关键字为例
        searchSourceBuilder.query(QueryBuilders.matchQuery(field, keyword));
        // 设置需要获取的文档总数
        searchSourceBuilder.size(0);  // 设置 size 为 0 表示只返回总数，不返回具体文档
        searchRequest.source(searchSourceBuilder);
        // 执行搜索请求
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        // 获取总数据条数
        return searchResponse.getHits().getTotalHits().value;
    }


}
