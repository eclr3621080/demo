package org.example.warehousemanagersystem.controller.upload;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.user.mapper.UserTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("upload")
@Slf4j
public class UploadImg {
    @Autowired
    UserTestMapper userTestMapper;
    @Value("${aliyun.oss.endpoint}")
    private String ALIYUN_OSS_ENDPOINT;
    @Value("${aliyun.oss.accessKeyId}")
    private String ALIYUN_OSS_ACCESSKEYID;
    @Value("${aliyun.oss.accessKeySecret}")
    private String ALIYUN_OSS_ACCESSKEYSECRET;
    @Value("${aliyun.oss.bucketName}")
    private String ALIYUN_OSS_BUCKETNAME;
    @PostMapping("/avatar")
    @ResponseBody
    public String uploadFile(MultipartFile file) throws IOException {
        RetStatus retStatus = new RetStatus();
        OSSClient ossClient = new OSSClient(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESSKEYID, ALIYUN_OSS_ACCESSKEYSECRET);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
// 获取文件名
        String fileName = file.getOriginalFilename();
// 获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
// 最后上传生成的文件名
        String finalFileName = System.currentTimeMillis() + "" + new SecureRandom().nextInt(0x0400) + suffixName;
// oss中的文件夹名
        String objectName = sdf.format(new Date()) + "/" + finalFileName;
// 创建上传文件的元信息，可以通过文件元信息设置HTTP header(设置了才能通过返回的链接直接访问)。
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("image/jpg");
// 文件上传
        ossClient.putObject(ALIYUN_OSS_BUCKETNAME, objectName, new ByteArrayInputStream(file.getBytes()), objectMetadata);
// 设置URL过期时间为1小时。
        Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000);
        String url = ossClient.generatePresignedUrl(ALIYUN_OSS_BUCKETNAME, objectName, expiration).toString();
        ossClient.shutdown();
        retStatus.setData(url);
        return JSONObject.toJSONString(retStatus, SerializerFeature.DisableCircularReferenceDetect);

    }
}
