package com.liuyuncen.es.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

import java.util.Map;

/**
 * @author xiang
 */
@Data
@Table("s_subject")
public class Subject {

    @Id(keyType = KeyType.Auto)
    private Integer id;
    private Integer paperId;
    private String subNo;
    private String subTitle;
    private String subTag;
    private String subInfo;
    private String subRef;
}
