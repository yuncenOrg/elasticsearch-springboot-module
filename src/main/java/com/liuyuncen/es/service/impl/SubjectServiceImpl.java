package com.liuyuncen.es.service.impl;

import com.liuyuncen.es.entity.Choose;
import com.liuyuncen.es.entity.Paper;
import com.liuyuncen.es.entity.Subject;
import com.liuyuncen.es.mapper.SubjectMapper;
import com.liuyuncen.es.service.*;
import com.liuyuncen.es.vo.SearchPageVO;
import com.liuyuncen.es.vo.SubjectVO;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author xiang
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Autowired
    private EsSearchService esSearchService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private ChooseService chooseService;

    @Autowired
    private SubPicService subPicService;
    @Autowired
    private SubRefPicService subRefPicService;


    @Override
    public Subject queryById(Long id) {
        return getById(id);
    }

    @Override
    public List<SubjectVO> searchByTitle(SearchPageVO searchPage) {
        List<Map<String, Object>> subjectMapLists = null;
        try {
            subjectMapLists = esSearchService.searchSubject(searchPage.getIndex(), searchPage.getSub_title(), searchPage.getKeywords(), searchPage.getPageNo(), searchPage.getPageSize());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<SubjectVO> subjectVOList = new ArrayList<>();
        for (Map<String, Object> map : subjectMapLists) {
            SubjectVO vo = new SubjectVO();
            Subject subject = new Subject();
            try {
                // 使用try-catch块捕获并处理可能的异常
                Integer id = (map.containsKey("id") && map.get("id") instanceof Integer) ? (Integer) map.get("id") : null;
                Integer paperId = (map.containsKey("paper_id") && map.get("paper_id") instanceof Integer) ? (Integer) map.get("paper_id") : null;
                String subNo = (map.containsKey("sub_no") && map.get("sub_no") instanceof String) ? (String) map.get("sub_no") : null;
                String subTitle = (map.containsKey("sub_title") && map.get("sub_title") instanceof String) ? (String) map.get("sub_title") : null;
                String subTag = (map.containsKey("sub_tag") && map.get("sub_tag") instanceof String) ? (String) map.get("sub_tag") : null;
                String subInfo = (map.containsKey("sub_info") && map.get("sub_info") instanceof String) ? (String) map.get("sub_info") : null;
                String subRef = (map.containsKey("sub_ref") && map.get("sub_ref") instanceof String) ? (String) map.get("sub_ref") : null;

                // 对null值进行处理，这里选择直接设置为null，也可以选择抛出异常或设置默认值
                // 如果某些字段不允许为null，应该在这里添加相应的异常处理逻辑
                subject.setId(id);
                subject.setPaperId(paperId);
                subject.setSubNo(subNo);
                subject.setSubTitle(subTitle);
                subject.setSubTag(subTag);
                subject.setSubInfo(subInfo);
                subject.setSubRef(subRef);

            } catch (ClassCastException e) {
                throw new IllegalArgumentException("Mapping contains incorrect types.", e);
            } catch (Exception e) {
                throw new RuntimeException("Unexpected error occurred while creating Subject from map.", e);
            }
            vo.setSubject(subject);


            Integer paperId = subject.getPaperId();
            if (paperId != null) {
                Paper paper = paperService.getById(paperId);
                vo.setPaper(paper);
            }

            Integer subId = subject.getId();
            if (subId != null) {
                List<Choose> chooses = chooseService.listBySubjectId(subId);
                vo.setChooseList(chooses);

                List<String> picUrls = subPicService.selectUrlBySubId(subId);
                List<String> refPicUrls = subRefPicService.selectUrlBySubId(subId);

                vo.setPicUrlList(picUrls);
                vo.setRefPicUrlList(refPicUrls);
            }
            subjectVOList.add(vo);
        }
        return subjectVOList;
    }

    @Override
    public Long getTotalHits(SearchPageVO searchPage) {
        long totalHits = 0L;
        try {
            totalHits = esSearchService.getTotalHits(searchPage.getIndex(), searchPage.getSub_title(), searchPage.getKeywords());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return totalHits;
    }
}
