package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<FileEnt, String> {
}
