package com.Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Pojo.Employee;
import com.Pojo.Users;
import com.Service.CredentialService;
import com.Service.EmployeeService;

@Controller
public class UserController {
	@Autowired
	CredentialService cs;
	
	@RequestMapping("/")
	public String Login()
	{
		return "Login";
	}
	
	@RequestMapping("/home")
	public String Home()
	{
		return "Home";
	}
	
	@RequestMapping("/usertable")
	public String UserTable()
	{
		return "AdminUsers";
	}
	
	@RequestMapping("/newUser")
	public String showNewUserForm(Model model)
	{
		Users u=new Users();
		model.addAttribute("u", u);
		return "UserRegi";	
	}
	
	@RequestMapping(value = "/saveUser", method= RequestMethod.POST)
	public String saveUser(@ModelAttribute("u") Users u)
	{
		cs.saveUser(u);
		return "Login";
		//return "redirect:/getUsersTables";		
	}
	@RequestMapping("/getUsersTables")
	public String getAllUsers(Model model)
	{
		List<Users> u= cs.getUsers();
		model.addAttribute("u", u);
		return "AdminUsers";	
	}
	
	/*@RequestMapping("/delete/{username}")
	public String deleteEmployee(@PathVariable(name = "username")String username)
	{
		cs.deleteUser(username);
		return "redirect:/getUsersTables";
	}*/

	/*@RequestMapping(value="/check",method=RequestMethod.POST)
	public String Check(@ModelAttribute Users Users, String username,String password)
	{
		String s=cs.checkprocess(Users, username, password);
		if(s.equals("1"))
		{
			//return "redirect:/getTables";
			 return "AdminAccess";
		}
		else if(s.equals("2"))
		{
			return "redirect:/show/"+username+"";
			//return "redirect:/newEmp";
		}
		else if(s.equals("-1"))
		{
			return "UserError";
		}
		return "newUser";
		
	}*/
	@ResponseBody
	@PostMapping("/addUser")
	public Users addUser( @RequestBody Users u)
	{
		return cs.saveUser(u);	
	}
	
	@ResponseBody
	@GetMapping("/getUsers")
	public List<Users> getEmployees(@RequestBody Users u)
	{
		return cs.getUsers();
	}
}
