package com.lss.serviceedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lss.serviceedu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lss.serviceedu.query.TeacherQuery;

import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author atguigu
 * @since 2020-10-26
 */
public interface IEduTeacherService extends IService<EduTeacher> {

    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);

    Map<String, Object> getTeacherFrontList(Page<EduTeacher> pageTeacher);
}
