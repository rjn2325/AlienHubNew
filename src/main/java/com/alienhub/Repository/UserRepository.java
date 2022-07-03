package com.alienhub.Repository;

import java.util.List;

import javax.transaction.Transactional;

import com.alienhub.models.AdminModel;
import com.alienhub.models.UserModal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
public interface UserRepository extends JpaRepository<UserModal,Long> {
  
  //UserModal findUserByEmail(String email);

  @Query(value = "select name from UserModal user where email = :emailquery")
	Boolean findUserByEmail(@Param("emailquery") String email);

  
  @Query(value = "select u  from UserModal u where u.email = :emailquery and  u.password = :passwordQuery")
	UserModal findUserByEmailAndPassword(@Param("emailquery") String email,@Param("passwordQuery") String password);


	UserModal findUserByAlienId(Long id);

  @Query(value = "select user from UserModal user")
	List<UserModal> findAllUsers();


//  @Query( value = "SELECT u, SQRT(POW(10) +POW(10)) from UserModal u where u.alienId != :userId ")
@Query(value = "SELECT u, SQRT(POW(69.1 * (u.lat - 28.719646), 2) +POW(69.1 * (77.21711 - u.longg) * COS(lat / 57.3), 2)) AS distance FROM UserModal u where u.alienId 	!= :userId")
List<UserModal>  findAllNearByUsers(@Param("userId") Long id);

//
//@Modifying
//@Query(value = "delete u from UserModal u where u.alienId = :userId")
//Boolean deleteByAlienId(Long Id);

//Long deleteByAlienId(Long Id);



}
