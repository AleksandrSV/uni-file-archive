package tech.rowi.corp.unifilearchive.mapper;

import tech.rowi.corp.unifilearchive.payload.FileResponse;
import io.minio.ObjectStat;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-14T19:35:39+0400",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
@Qualifier("delegate")
public class FileResponseMapperImpl_ implements FileResponseMapper {

    @Override
    public FileResponse fileAddResponse(ObjectStat objectStat) {
        if ( objectStat == null ) {
            return null;
        }

        FileResponse fileResponse = new FileResponse();

        return fileResponse;
    }

    @Override
    public FileResponse fileGetResponse(ObjectStat objectStat) {
        if ( objectStat == null ) {
            return null;
        }

        FileResponse fileResponse = new FileResponse();

        return fileResponse;
    }
}
