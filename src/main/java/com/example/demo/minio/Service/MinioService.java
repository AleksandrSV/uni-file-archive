package com.example.demo.minio.Service;


import com.example.demo.minio.Config.MinioConfigurationProperties;
import com.example.demo.minio.Config.MinioFetchException;
import io.minio.*;
import io.minio.messages.Item;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class MinioService implements FileServiceImpl{
    private final MinioClient minioClient;
    private final MinioConfigurationProperties configurationProperties;

    @Autowired
    public MinioService(MinioClient minioClient, MinioConfigurationProperties configurationProperties) {
        this.minioClient = minioClient;
        this.configurationProperties = configurationProperties;
    }
    public List<Item> fullList() {
        ListObjectsArgs args = ListObjectsArgs.builder()
                .bucket("test")
                .build();
        Iterable<Result<Item>> myObjects = minioClient.listObjects(args);
        return getItems(myObjects);
    }
    private List<Item> getItems(Iterable<Result<Item>> myObjects) {
        return StreamSupport
                .stream(myObjects.spliterator(), true)
                .map(itemResult -> {
                    try {
                        return itemResult.get();
                    } catch (Exception e) {
                        throw new MinioFetchException("Error while parsing list of objects", e);
                    }
                })
                .collect(Collectors.toList());
    }
    @SneakyThrows
    public String saveFile() {
        try {
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket("test").build());
            if (!found) {
                // Make a new bucket called 'asiatrip'.
                minioClient.makeBucket(MakeBucketArgs.builder().bucket("test").build());
            } else {
                System.out.println("Bucket 'test' already exists.");
            }
            minioClient.uploadObject(
                    UploadObjectArgs.builder()
                            .bucket("test")
                            .object("FirstCRUD.JPG")
                            .filename("C:\\Users\\Ilia_Dukhov\\OneDrive\\Рабочий стол\\JAVAhome\\OnesToDev\\Scrinshots\\FirstCRUD.JPG")
                            .build());
            System.out.println(
                    "'FirstCRUD.JPG' is successfully uploaded");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e);
        }
        return "file uploaded";
    }

    @Override
    public String saveFile(MultipartFile file) {
        return null;
    }

    @Override
    public byte[] downloadFile(String filename) {
        return new byte[0];
    }

    @Override
    public String deleteFile(String filename) {
        return null;
    }

    @Override
    public List<String> listAllFiles() {
        return null;
    }

}

