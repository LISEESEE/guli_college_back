package com.lss.serviceedu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lss.serviceedu.entity.EduCourse;
import com.lss.serviceedu.entity.front.CourseWebVo;
import com.lss.serviceedu.entity.vo.CoursePublishVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author testjava
 * @since 2020-03-02
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    CoursePublishVo getPublishCourseInfo(@Param("courseId") String id);

    CourseWebVo getBaseCourseInfo(@Param("courseId") String courseId);
}
