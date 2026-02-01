package com.example.RoleBasedSecurity.Controller;

import com.example.RoleBasedSecurity.DTOS.UserDTO;
import com.example.RoleBasedSecurity.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/api")
public class UserController {

    UserService userService;

    public UserController() {
    }


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
 public  Map<String,String> login(@RequestBody UserDTO userDTO){
        String username=userDTO.getUsername();
        String password=userDTO.getPassword();

       String role= userService.getUserRole(username,password);
        String message;
       if(role!=null) {
           if (role.equals("user")) {
            message=userService.userResponse(username);
           } else {
            message=userService.adminResponse(username);
           }
       } else {
           message="Something went Wrong Try Again";
       }
       Map<String ,String> response=new HashMap<>();
       response.put("message",message);
        return response;
    }
}
