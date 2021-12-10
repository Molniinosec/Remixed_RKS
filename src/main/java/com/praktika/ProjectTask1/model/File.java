package com.praktika.ProjectTask1.model;

import javax.persistence.*;

@Entity
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer FileId;

    private String Title;
    private String FilePath;
    private String FileSize;

    @ManyToOne (optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="users_id")
    private User user;

    public File() {
    }

    public File(Integer fileID, String title, String filePath, String fileSize) {
        this.FileId = fileID;
        this.Title = title;
        this.FilePath = filePath;
        this.FileSize = fileSize;
    }

    public Integer getFileId() {
        return this.FileId;
    }

    public void setFileId(Integer fileId) {
        this.FileId = fileId;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getFilePath() {
        return this.FilePath;
    }

    public void setFilePath(String filePath) {
        this.FilePath = filePath;
    }

    public String getFileSize() {
        return this.FileSize;
    }

    public void setFileSize(String fileSize) {
        this.FileSize = fileSize;
    }

}
