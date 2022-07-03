package com.alienhub.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alienhub.Repository.AdminRepository;
import com.alienhub.Repository.UserRepository;
import com.alienhub.models.AdminModel;
import com.alienhub.models.UserModal;

@Service
public class AdminService {

	
	 @Autowired
	  AdminRepository adminRepository;

	  AdminModel usermodal = new AdminModel();

	
	 public AdminModel findAdminUserByEmailAndPassword(String email,String password) {
		   return adminRepository.findAdminUserByEmailAndPassword(email,password);

		  }

}
