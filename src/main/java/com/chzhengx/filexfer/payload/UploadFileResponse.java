package com.chzhengx.filexfer.payload;

/**
 * 上传文件响应类，用于封装文件上传后的响应信息。
 */
public class UploadFileResponse {
    private String fileName;
    private String fileDownloadUri;
    private String fileType;
    private long size;

    /**
     * 使用文件名、文件下载URI、文件类型和文件大小构造上传文件响应对象。
     *
     * @param fileName        上传的文件名
     * @param fileDownloadUri 文件下载的URI
     * @param fileType        文件的类型
     * @param size            文件的大小（字节）
     */
    public UploadFileResponse(String fileName, String fileDownloadUri, String fileType, long size) {
        this.fileName = fileName;
        this.fileDownloadUri = fileDownloadUri;
        this.fileType = fileType;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDownloadUri() {
        return fileDownloadUri;
    }

    public void setFileDownloadUri(String fileDownloadUri) {
        this.fileDownloadUri = fileDownloadUri;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
