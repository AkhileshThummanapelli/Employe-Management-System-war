package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Pojo.Employee;
import com.Pojo.Users;
import com.Repo.CredentialRepo;
import com.Repo.EmployeeRepo;

@SpringBootApplication
public class EmpManageSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EmpManageSystemApplication.class, args);
	}
    @Autowired
    CredentialRepo cr;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		cr.save(new Users("admin","admin"));
		cr.save(new Users("akhilesh","akhilesh"));
		cr.save(new Users("aravind","aravind"));
		cr.save(new Users("prashanth","prashanth"));
		cr.save(new Users("siddhu","siddhu"));	
	}
	/*@Autowired
    EmployeeRepo er;
	public void run1(String... args) throws Exception {
		// TODO Auto-generated method stub
		er.save(new Employee(0, "akhilesh","akhileshchari","jagtial","9949325451","ak@gmail.com","10000"));
	}*/

}
