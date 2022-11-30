package com.example.sam2023.persistance.filestorageSystem;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;

public interface FileStorage {
    void init();

    void store(MultipartFile file, String foldername) throws IOException;

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename) throws IOException;

    void deleteAll();

    void makeDir(String folderPath);

    boolean deleteFile(String filepath);

    boolean dirExists(String folderPath);

    boolean fileExists(String filePath);

    boolean clearDirectory(String folderPath);
}
