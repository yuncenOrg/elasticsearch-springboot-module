package com.liuyuncen.es.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author xiang
 */
@Data
@Table("s_sub_ch")
public class SubCh {

    @Id(keyType = KeyType.Auto)
    private Integer id;
    private Integer subId;
    private Integer chId;
}
