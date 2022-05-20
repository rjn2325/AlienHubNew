package com.alienhub.Services;

import java.sql.Timestamp;

import javax.transaction.Transactional;

import com.alienhub.Repository.UserRepository;
import com.alienhub.models.UserModal;
import com.alienhub.models.common.ResponseModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@Transactional

public class UserService {

  @Autowired
  UserRepository userRepository;

  UserModal usermodal = new UserModal();

  public boolean isUserExist(String email) {
    System.out.println("result " + userRepository.findUserByEmail(email));
    if (userRepository.findUserByEmail(email) == null) {
      System.out.println('h');

      return true;

    } else {
      System.out.println('i');

      return false;

    }

  }

  public Boolean saveUser(UserModal userModal) {
    if (isUserExist(userModal.getEmail())) {
      userModal.setCreation_time(new Timestamp(System.currentTimeMillis()));
      userRepository.saveAndFlush(userModal);
      return true;
    } else {
      return false;
    }
  }

  public UserModal findUserByEmailAndPassword(String email,String password) {
    // System.out.println("result " + userRepository.findUserByEmail(email));
   return userRepository.findUserByEmailAndPassword(email,password);
    
  

  }

}
