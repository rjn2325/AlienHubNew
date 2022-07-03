package com.alienhub.Services;

import java.sql.Timestamp;
import java.util.List;

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

//  public Long deleteUser(Long id) {
//   
//      return userRepository.deleteByAlienId(id);
//     
//  }

  public UserModal findUserByEmailAndPassword(String email,String password) {
   return userRepository.findUserByEmailAndPassword(email,password);

  }
  
 



  public UserModal getUserDetails(Long id) {
    // System.out.println("result " + userRepository.findUserByEmail(email));
    if (userRepository.findUserByAlienId(id) == null) {
      System.out.println('h');

      return userRepository.findUserByAlienId(id);
    } else {
      return userRepository.findUserByAlienId(id);

    }

  }
  
  public List<UserModal> getUserList() {
    // System.out.println("result " + userRepository.findUserByEmail(email));
    if (userRepository.findAllUsers() == null) {
      System.out.println('h');

      return userRepository.findAllUsers();
    } else {
      return userRepository.findAllUsers();

    }

  }

  public List<UserModal> getNearByUsers(Long id) {
    // System.out.println("result " + userRepository.findUserByEmail(email));
    if (userRepository.findAllNearByUsers(id) == null) {
      System.out.println('h');

      return userRepository.findAllUsers();
    } else {
      return userRepository.findAllUsers();

    }

  }

}
