package com.liuyuncen.es.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author xiang
 */
@Data
@Table("s_choose")
public class Choose {

    @Id(keyType = KeyType.Auto)
    private Long id;
    private Long subId;
    private String chA;
    private String chB;
    private String chC;
    private String chD;
    private String chTrue;
    private String chMy;

}
