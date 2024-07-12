package com.liuyuncen.es.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询条件
 * @author xiang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPageVO {
    private final String index = "subject";
    private final String sub_title = "sub_title";
    private String keywords;
    private Integer pageNo;
    private Integer pageSize;
}
