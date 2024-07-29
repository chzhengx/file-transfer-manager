package com.chzhengx.filexfer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义文件未找到异常类，用于在文件未找到的情况下抛出异常。
 * 该异常被标记为HTTP状态404（NOT FOUND）。
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException extends RuntimeException {
    /**
     * 使用指定的详细信息构造新的文件未找到异常。
     *
     * @param message 异常的详细信息
     */
    public MyFileNotFoundException(String message) {
        super(message);
    }

    /**
     * 使用指定的详细信息和原因构造新的文件未找到异常。
     *
     * @param message 异常的详细信息
     * @param cause   异常的原因（可以通过 {@link Throwable#getCause()} 方法获取）
     */
    public MyFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
