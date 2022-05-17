package com.alienhub.Controller;

import com.alienhub.Services.UserService;
import com.alienhub.models.UserModal;
import com.alienhub.models.common.ResponseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @PostMapping("/signup")
  public ResponseModel createUser(@RequestBody UserModal userModal) {

    if (userService.saveUser(userModal)) {
      ResponseModel responseModel = new ResponseModel();

      responseModel.setSucccess(true);
      responseModel.setMessage("Registered Successfullly.");
      return responseModel;
    } else {
      ResponseModel responseModel = new ResponseModel();

      responseModel.setMessage("Email already exist please try with different email.");
      return responseModel;
    }

  }

  @PostMapping("/login")
  public UserModal validateUser(@RequestBody UserModal userModal) {
    ResponseModel responseModel = new ResponseModel();

    return userService.findUserByEmailAndPassword(userModal.getEmail(),userModal.getPassword());
    
  }

}
