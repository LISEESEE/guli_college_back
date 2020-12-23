package com.lss.educms.controller;

import com.lss.educms.service.OssService;
import com.lss.utils.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
public class OssController {
    @Autowired
    private OssService ossService;

    @PostMapping
    public R uploadOssFile(@RequestBody MultipartFile file){
        //返回上传的路径
        String url = ossService.uploadFileAvatar(file);
        return R.ok().data("url",url);
    }
}
