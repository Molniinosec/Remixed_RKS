package com.praktika.ProjectTask1.model;


import jdk.jfr.DataAmount;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserId;

    private String LName;
    private String FName;
    private String Phone;
    private String Password;
    private String Email;
    private boolean active;

    @OneToMany (mappedBy="user", fetch=FetchType.EAGER)
    private Collection<File> UserFiles;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public User() {
    }

    public User(String LName, String FName, String phone, String password, String email, boolean active, Collection<File> userFiles) {
        this.LName = LName;
        this.FName = FName;
        Phone = phone;
        Password = password;
        Email = email;
        this.active = active;
        UserFiles = userFiles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        this.UserId = userId;
    }

    public String getLName() {
        return this.LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public String getFName() {
        return this.FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getPhone() {
        return this.Phone;
    }

    public void setPhone(String phone) {
        this.Phone = phone;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public Collection<File> getUserFiles() {
       return this.UserFiles;
   }

    public void setUserFiles(Collection<File> userFiles) {
        this.UserFiles = userFiles;
    }

}
