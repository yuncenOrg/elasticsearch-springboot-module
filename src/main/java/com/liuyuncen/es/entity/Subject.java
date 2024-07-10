package com.liuyuncen.es.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author xiang
 */
@Data
@Table("s_subject")
public class Subject {

    @Id(keyType = KeyType.Auto)
    private Long id;
    private Long paperId;
    private String subNo;
    private String subTitle;
    private String subTag;
    private String subInfo;
    private String subRef;
}
