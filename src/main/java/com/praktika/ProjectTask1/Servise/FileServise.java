package com.praktika.ProjectTask1.Servise;


import com.praktika.ProjectTask1.model.File;
import com.praktika.ProjectTask1.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServise {

    private final FileRepository fileRepository;
    @Autowired
    public FileServise(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File FindById(Integer id){return fileRepository.getById(id);}
    public List<File> findAll(){return fileRepository.findAll();}
    public File SaveFile(File file){return fileRepository.save(file);}
    public void deleteByID(Integer id){fileRepository.deleteById(id);}
}
