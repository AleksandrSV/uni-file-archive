package com.example.demo.minio.Config;

public class MinioFetchException extends RuntimeException{
    public MinioFetchException(String message, Throwable cause) {
        super(message, cause);
    }
}