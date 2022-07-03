package com.alienhub.Controller;

import java.util.List;

import com.alienhub.Services.UserService;
import com.alienhub.models.UserModal;
import com.alienhub.models.common.ResponseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin 

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @CrossOrigin 
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
  public ResponseModel<UserModal> validateUser(@RequestBody UserModal userModal) {

    if (userService.findUserByEmailAndPassword(userModal.getEmail(), userModal.getPassword()) == null) {

      ResponseModel responseModel = new ResponseModel();

      responseModel.setMessage("Login failed");
      return responseModel;

    } else {
      ResponseModel<UserModal> responseModel = new ResponseModel<UserModal>();

      responseModel.setSucccess(true);
      responseModel.setMessage("Login Successfully.");
      responseModel.setData(userService.findUserByEmailAndPassword(userModal.getEmail(), userModal.getPassword()));
      return responseModel;

    }

  }

  @GetMapping("/details")
  public ResponseModel getUserDetails(@RequestParam Long id) {

    if (userService.getUserDetails(id) == null) {
      ResponseModel responseModel = new ResponseModel();

      responseModel.setMessage("User not found");
      return responseModel;
    } else {
      ResponseModel<UserModal> responseModel = new ResponseModel<UserModal>();

      responseModel.setSucccess(true);
      responseModel.setMessage("User fetch successfully.");
      responseModel.setData(userService.getUserDetails(id));
      return responseModel;
    }

  }

//  @DeleteMapping("/delete/{id}")
//  public ResponseModel createUser(@PathVariable Long id) {
//
//    if (userService.deleteUser(id) != null) {
//      ResponseModel responseModel = new ResponseModel();
//
//      responseModel.setSucccess(true);
//      responseModel.setMessage("User deleted Successfullly.");
//      return responseModel;
//    } else {
//      ResponseModel responseModel = new ResponseModel();
//
//      responseModel.setMessage("User not found.");
//      return responseModel;
//    }
//
//  }

  
  @GetMapping("/list")
  public ResponseModel getUserList() {

    if (userService.getUserList() == null) {
      ResponseModel responseModel = new ResponseModel();

      responseModel.setMessage("Users fetch successfully");
      // responseModel.setData([]);

      return responseModel;
    } else {
      ResponseModel<List<UserModal>> responseModel = new ResponseModel<List<UserModal>>();

      responseModel.setSucccess(true);
      responseModel.setMessage("Users fetch successfully.");
      responseModel.setData(userService.getUserList());
      return responseModel;
    }

  }


  @GetMapping("/nearby/{id}")
  public ResponseModel getNearByUsers(@PathVariable Long id) {
//	  System.out.println("id")
    if (userService.getNearByUsers(id) == null) {
      ResponseModel responseModel = new ResponseModel();
      responseModel.setMessage("Users fetch successfully");
      // responseModel.setData([]);

      return responseModel;
    } else {
      ResponseModel<List<UserModal>> responseModel = new ResponseModel<List<UserModal>>();

      responseModel.setSucccess(true);
      responseModel.setMessage("Users fetch successfully.");
      responseModel.setData(userService.getUserList());
      return responseModel;
    }

  }

}
