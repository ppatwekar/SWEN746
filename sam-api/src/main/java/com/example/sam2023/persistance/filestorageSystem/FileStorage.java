package com.example.sam2023.persistance.filestorageSystem;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Resource;

public interface FileStorage {
    void init();

    void store(MultipartFile file, String foldername) throws IOException;

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
