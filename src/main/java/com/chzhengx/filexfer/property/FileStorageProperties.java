package com.chzhengx.filexfer.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 文件存储属性类，用于从配置文件中读取与文件存储相关的属性。
 * 使用 "file" 作为前缀从配置文件中读取属性。
 */
@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    /**
     * 获取文件上传目录。
     *
     * @return 文件上传目录
     */
    public String getUploadDir() {
        return uploadDir;
    }

    /**
     * 设置文件上传目录。
     *
     * @param uploadDir 文件上传目录
     */
    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
