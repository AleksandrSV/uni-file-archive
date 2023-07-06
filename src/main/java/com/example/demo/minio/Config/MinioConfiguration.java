package com.example.demo.minio.Config;

import io.minio.MinioClient;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
@ConditionalOnClass(MinioClient.class)
@EnableConfigurationProperties(MinioConfigurationProperties.class)
@ComponentScan("com.example.demo.minio")
public class MinioConfiguration {

    @Autowired
    private MinioConfigurationProperties minioConfigurationProperties;
    @Bean
    @SneakyThrows
    public MinioClient minioClient() {
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("http://127.0.0.1:9000")
                        .credentials("Ilia_Duhov", "31012003ID@")
                        .build();
        return minioClient;
    }
    private boolean configuredProxy() {
        String httpHost = System.getProperty("http.proxyHost");
        String httpPort = System.getProperty("http.proxyPort");
        return httpHost != null && httpPort != null;
    }

    private OkHttpClient client() {
        String httpHost = System.getProperty("http.proxyHost");
        String httpPort = System.getProperty("http.proxyPort");

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (httpHost != null)
            builder.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(httpHost, Integer.parseInt(httpPort))));
        return builder
                .build();
    }

}