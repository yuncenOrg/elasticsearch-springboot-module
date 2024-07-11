package com.liuyuncen.es.vo;

import com.liuyuncen.es.entity.Choose;
import com.liuyuncen.es.entity.Paper;
import com.liuyuncen.es.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author xiang
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectVO{
    /**
     * 题目
     */
    private Subject subject;
    /**
     * 试卷
     */
    private Paper paper;
    /**
     * 选项
     */
    private List<Choose> chooseList;
    /**
     * 图片
     */
    private List<String> picUrlList;
    /**
     * 参考答案图片
     */
    private List<String> refPicUrlList;
}
