package com.example.sam2023.persistance.filestorageSystem;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;

@Service
public class FileStorageFile implements FileStorage {

    public FileStorageFile(){
        this.init();
    }

    @Override
    public void init() {
        // DirectoryEnum[] directories = DirectoryEnum.values();

        // Arrays.stream(directories)
        // .map(d->Paths.get(d.getPath()))
        // .forEach(p->{
        //     try {
        //         Files.createDirectory(p);
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //         System.out.println("Could not create directory: "+p.getFileName());
        //     }
        // });
    }

    @Override
    public void store(MultipartFile file, String foldername) throws IOException {
        if(file.isEmpty()){
            throw new IOException("Cant store empty file");
        }

        Files.copy(file.getInputStream(), Paths.get(foldername).resolve(file.getOriginalFilename()));
    }

    @Override
    public Stream<Path> loadAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Path load(String filename) {
        // TODO Auto-generated method stub
        return Paths.get(filename);
    }

    @Override
    public Resource loadAsResource(String filename) throws IOException {
        Path file = this.load(filename);
        try {
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()){
                return resource;
            }
            else{
                throw new IOException("Could not load as resource");
            }
        } catch (MalformedURLException e) {
            System.out.println("Could not load as Resource");
            return null;
        }
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void makeDir(String folderPath){
        File file = new File(folderPath);
        file.mkdir();
    }

    @Override
    public boolean dirExists(String folderPath){
        Path path = Paths.get(folderPath);
        return Files.exists(path);
    }

    @Override
    public boolean deleteFile(String filepath){
        return new File(filepath).delete();
    }

    @Override 
    public boolean fileExists(String filepath){
        return new File(filepath).exists();
    }

    @Override
    public boolean clearDirectory(String folderPath){
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        Arrays.stream(files).forEach(f->f.delete());
        return true;
    }


    
}
