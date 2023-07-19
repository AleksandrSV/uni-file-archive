package tech.rowi.corp.unifilearchive.service;

import tech.rowi.corp.unifilearchive.entity.FileEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileRepository extends MongoRepository<FileEntity, String> {
}