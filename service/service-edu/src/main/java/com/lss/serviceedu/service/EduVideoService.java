package com.lss.serviceedu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lss.serviceedu.entity.EduVideo;

public interface EduVideoService extends IService<EduVideo> {

    void removeVideoByCourseId(String courseId);
}