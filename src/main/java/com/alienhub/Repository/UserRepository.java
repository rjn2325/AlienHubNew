package com.alienhub.Repository;

import javax.transaction.Transactional;

import com.alienhub.models.UserModal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
public interface UserRepository extends JpaRepository<UserModal,Long> {
  
  //UserModal findUserByEmail(String email);

  @Query(value = "select name from UserModal user where email = :emailquery")
	Boolean findUserByEmail(@Param("emailquery") String email);

  
  @Query(value = "select name ,email,dob,location  from UserModal user where email = :emailquery and password = :passwordQuery")
	UserModal findUserByEmailAndPassword(@Param("emailquery") String email,@Param("passwordQuery") String password);


}
