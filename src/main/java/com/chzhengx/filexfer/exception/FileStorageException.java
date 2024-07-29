package com.chzhengx.filexfer.exception;

/**
 * 文件存储异常类，用于在文件存储过程中抛出异常。
 */
public class FileStorageException extends RuntimeException {
    /**
     * 使用指定的详细信息构造新的文件存储异常。
     *
     * @param message 异常的详细信息
     */
    public FileStorageException(String message) {
        super(message);
    }

    /**
     * 使用指定的详细信息和原因构造新的文件存储异常。
     *
     * @param message 异常的详细信息
     * @param cause   异常的原因（可以通过 {@link Throwable#getCause()} 方法获取）
     */
    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
