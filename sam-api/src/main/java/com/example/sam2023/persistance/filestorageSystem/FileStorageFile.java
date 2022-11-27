package com.example.sam2023.persistance.filestorageSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Resource;

public class FileStorageFile implements FileStorage {

    @Override
    public void init() {
        DirectoryEnum[] directories = DirectoryEnum.values();

        Arrays.stream(directories)
        .map(d->Paths.get(d.getPath()))
        .forEach(p->{
            try {
                Files.createDirectory(p);
            } catch (IOException e) {
                System.out.println("Could not create directory: "+p.getFileName());
            }
        });
    }

    @Override
    public void store(MultipartFile file, String foldername) throws IOException {
        if(file.isEmpty()){
            throw new IOException("Cant store empty file");
        }
    }

    @Override
    public Stream<Path> loadAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Path load(String filename) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }
    
}
