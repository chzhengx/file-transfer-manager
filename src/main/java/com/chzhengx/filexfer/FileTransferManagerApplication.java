package com.chzhengx.filexfer;

import com.chzhengx.filexfer.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 应用程序主类
 */
@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class FileTransferManagerApplication {

	/**
	 * 应用程序的主方法，用于启动Spring Boot应用程序。
	 *
	 * @param args 命令行参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(FileTransferManagerApplication.class, args);
	}
}
