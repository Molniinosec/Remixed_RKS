package com.praktika.ProjectTask1.Controllers;

import com.praktika.ProjectTask1.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileController {
    @Autowired
    private final FileRepository fileRepo;

    public FileController(FileRepository fileRepo) {
        this.fileRepo = fileRepo;
    }

    @GetMapping("/files")
    public ResponseEntity GetAllFiles(){
        return ResponseEntity.ok(this.fileRepo.findAll());
    }
}
