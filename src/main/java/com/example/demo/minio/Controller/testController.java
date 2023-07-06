package com.example.demo.minio.Controller;

import com.example.demo.minio.Service.MinioService;
import io.minio.messages.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testController {
    @Autowired
    private MinioService minioService;

    @GetMapping("list")
    public List<Item> testConnection(){
        return minioService.fullList();
    }
    @GetMapping("upload")
    public String saveFile(){
        return minioService.saveFile();
    }

}

