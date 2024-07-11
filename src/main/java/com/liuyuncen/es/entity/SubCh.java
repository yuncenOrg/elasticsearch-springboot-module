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
    private Long id;
    private Long subId;
    private Long chId;
}
