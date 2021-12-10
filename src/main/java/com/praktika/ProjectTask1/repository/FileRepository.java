package com.praktika.ProjectTask1.repository;

import com.praktika.ProjectTask1.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {
}
