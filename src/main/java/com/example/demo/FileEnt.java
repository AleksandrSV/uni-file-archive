package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class FileEnt {
    @Id
    private String id;
    private String name;
    private String category;
    private String type;
    private String source;
    private String inn;
    private String kpp;
    private String ogrn;
    private String creationDate;
    private String startDate;
    private String endDate;

    public FileEnt(String name, String category, String type, String source) {
        this.name = name;
        this.category = category;
        this.type = type;
        this.source = source;
    }


}
