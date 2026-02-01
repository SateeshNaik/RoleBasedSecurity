package com.example.RoleBasedSecurity.Services;

import com.example.RoleBasedSecurity.Entities.User;
import com.example.RoleBasedSecurity.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

 public   String userResponse(String name){
        return "Hello " + name +" Welcome Your Role is User";
    }

  public   String adminResponse(String name){
         return "Hello " + name +" Welcome Your Role is Admin";
    }

  public   String getUserRole(String username, String password){
       User ref= userRepository.findByUsername(username);
       if(ref!=null){
           if(ref.getPassword().equals(password)){
               return ref.getRole();
           } else {
               return null;
           }
       }
       return null;
    }
}
