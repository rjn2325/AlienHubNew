package com.alienhub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alienhub.Services.AdminService;
import com.alienhub.Services.UserService;
import com.alienhub.models.AdminModel;
import com.alienhub.models.common.ResponseModel;


@CrossOrigin 

@RestController
@RequestMapping("/admin")
public class AdminController {
	  @Autowired
	  AdminService adminService;
	
	  @CrossOrigin 
	  @PostMapping("/login")  
	public ResponseModel<AdminModel> validateUser(@RequestBody AdminModel AdminModel) {

	    if (adminService.findAdminUserByEmailAndPassword(AdminModel.getEmail(), AdminModel.getPassword()) == null) {

	      ResponseModel responseModel = new ResponseModel();
	      responseModel.setStatus(401);
	      responseModel.setMessage("Login failed");
	      return responseModel;

	    } else {
	      ResponseModel<AdminModel> responseModel = new ResponseModel<AdminModel>();
	      responseModel.setStatus(200);
	      responseModel.setSucccess(true);
	      responseModel.setMessage("Login Successfully.");
	      responseModel.setData(adminService.findAdminUserByEmailAndPassword(AdminModel.getEmail(), AdminModel.getPassword()));
	      return responseModel;

	    }

	  }

	
	

}
