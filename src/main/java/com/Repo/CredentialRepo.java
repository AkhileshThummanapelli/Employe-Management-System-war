package com.Repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Pojo.Users;

@Repository
public interface CredentialRepo extends JpaRepository<Users,Integer>{
	
	@Query(value="select * from CredentialEMS where username=?1 and password=?2",nativeQuery=true)
	public Users getUserByUsername(String username, String password);
	
	/*@Query(value="delete from CredentialEMS where username=?1",nativeQuery=true)
	public Users deleteUsername(String username);*/

}
