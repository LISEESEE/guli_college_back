package com.lss.serviceedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lss.serviceedu.entity.EduChapter;
import com.lss.serviceedu.entity.chapter.ChapterVo;

import java.util.List;

public interface EduChapterService extends IService<EduChapter> {

    //课程大纲列表,根据课程id进行查询
    List<ChapterVo> getChapterVideoByCourseId(String courseId);

    //删除章节的方法
    boolean deleteChapter(String chapterId);

    void removeChapterByCourseId(String courseId);
}
