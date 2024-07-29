package com.chzhengx.filexfer.service;

import com.chzhengx.filexfer.exception.MyFileNotFoundException;
import com.chzhengx.filexfer.exception.FileStorageException;
import com.chzhengx.filexfer.property.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 文件存储服务类，提供文件的存储和加载功能。
 */
@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    /**
     * 使用文件存储属性初始化文件存储位置。
     *
     * @param fileStorageProperties 文件存储属性
     */
    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("无法创建存储上传文件的目录。", ex);
        }
    }

    /**
     * 存储上传的文件。
     *
     * @param file 要存储的文件
     * @return 存储的文件名
     */
    public String storeFile(MultipartFile file) {
        // 标准化文件名
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // 检查文件名是否包含无效字符
            if(fileName.contains("..")) {
                throw new FileStorageException("抱歉！文件名包含无效路径序列 " + fileName);
            }

            // 将文件复制到目标位置（替换具有相同名称的现有文件）
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("无法存储文件 " + fileName + "。请重试！", ex);
        }
    }

    /**
     * 以资源的形式加载文件。
     *
     * @param fileName 要加载的文件名
     * @return 加载的文件资源
     */
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("文件未找到 " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("文件未找到 " + fileName, ex);
        }
    }
}
