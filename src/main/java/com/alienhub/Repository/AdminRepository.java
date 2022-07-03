package com.alienhub.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alienhub.models.AdminModel;
import com.alienhub.models.UserModal;

@Repository
public interface AdminRepository extends JpaRepository<UserModal,AdminModel> {
	
	@Query(value = "select u  from AdminModel u where u.email = :emailquery and  u.password = :passwordQuery")
	AdminModel findAdminUserByEmailAndPassword(@Param("emailquery") String email,@Param("passwordQuery") String password);

}
