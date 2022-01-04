package com.Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Pojo.Employee;
import com.Pojo.Users;
import com.Repo.CredentialRepo;

@Service
public class CredentialService {
	@Autowired
	CredentialRepo cr;
	
	//Add Employee Details
			public Users saveUser(Users u)
			{
				return cr.save(u);
				
			}
			//Get All Employee Details
			public List<Users> getUsers()
			{
				return cr.findAll();
				
			}
			//Update Employee Details
			public Users updateEmp(Users u)
			{
			  return cr.save(u);
			}
			public Users getUsersByUsername(String username, String password)
			{
				return cr.getUserByUsername(username, password);
				
				
			}
			/*public void deleteUser(String username)
			{
				cr.deleteUsername(username);
				
			}*/
			public String checkprocess(@ModelAttribute Users Users, String username,String password)
			{
				Users u=cr.getUserByUsername(username, password);
				String uname=u.getUsername();
				String pass=u.getPassword();
				//System.out.println(uname);
				 if(uname.isEmpty())
			     {
			    	 return "-1";
			     }
				 else if(uname.equals("admin")&&pass.equals("admin"))
				{
					 return "1";
				}
				
				else if(uname.equals(username) && pass.equals(password)  &&   uname!="admin")
					{
					    return "2";
					}     
				return "-1";
			  }
			
			

}
