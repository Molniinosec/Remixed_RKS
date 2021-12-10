package com.praktika.ProjectTask1.Servise;

import com.praktika.ProjectTask1.model.User;
import com.praktika.ProjectTask1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User findById(Integer id){return userRepository.getById(id);}
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User SaveUser(User user){
        return userRepository.save(user);
    }
    public void deleteByID(Integer id){
        userRepository.deleteById(id);
    }
}
