package com.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Pojo.Employee;
import com.Pojo.Users;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{
	
	@Query(value="select * from EmployeeEMS where username=?1",nativeQuery=true)
	public Employee FetchUsername(String username);
	
	@Query(value="insert into EmployeeEMS values('username'=?1,'fullname'=?2,'address'=?3,'phoneno'=?4,'email'=?5,salary=?6)",nativeQuery=true)
	public Employee Fetch(String username,String fullname,String address,String phoneno,String email,int salary);


}
