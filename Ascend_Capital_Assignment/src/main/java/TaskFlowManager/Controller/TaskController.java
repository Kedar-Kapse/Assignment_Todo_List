package TaskFlowManager.Controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import TaskFlowManager.Entity.DroppedItem;
import TaskFlowManager.Entity.SignIn_Login;
import TaskFlowManager.Repository.AdminRepository;
import TaskFlowManager.Service.ItemService;
import jakarta.servlet.http.HttpSession;

import java.awt.MenuItem;
import java.util.*;


import TaskFlowManager.Entity.DroppedItem;

@Controller
public class TaskController {
	
	@Autowired
	AdminRepository AdminRepo;
	
	@RequestMapping("/")
	public String HomePage() {
		return "mallika";
	}
	 @RequestMapping("/Signin_Page")
	    public String Signuppage(@ModelAttribute("SignIn_Loign") SignIn_Login signin_Admin) {
	        return "Signin_Page";
	 }
	 @RequestMapping("Signinsuccess") 
	 public String signinsucess(@ModelAttribute SignIn_Login signupsave) {
		 	AdminRepo.save(signupsave);
			return "Home";
	 }
	//------------------------------------Signin Page End-------------------------------------------
	 @RequestMapping("Login_Page")
	    public String Loginpage()
	    {
			return "Login_Page";
	    }
	 @RequestMapping("LoginSucess")
	    public String log_in(@RequestParam String email, @RequestParam String password, Model model, HttpSession userLog) {
	        System.out.println(email);
	        System.out.println(password);
	        int status = 0;
	        SignIn_Login emp = AdminRepo.findByEmail(email);
	        if (emp != null && emp.getEmail().equals(email) && emp.getPassword().equals(password)) {
	            status++;
	            userLog.setAttribute("loggedin", emp);
	        }
	        if (status > 0) {
	            return "WelcomeUser"; 
	        } else {
	            return "Login_Page"; 
	        }       
	 }
	 //---------------------------------------Login Page End------------------------------------------------------
	 
	 	@Autowired
	    private ItemService itemService;
	 	
	 	@GetMapping("/menu")
	 	public String getMenuItems(Model model) {
	 	    Iterable<TaskFlowManager.Entity.MenuItem> menuItems = itemService.getAllMenuItems();
	 	    model.addAttribute("menuItems", menuItems);
	 	    return "menu";
	 	}

	 	@GetMapping("/dropped-items")
	 	public String getDroppedItems(Model model) {
	 	    Iterable<DroppedItem> droppedItems = itemService.getAllDroppedItems();
	 	    model.addAttribute("droppedItems", droppedItems);
	 	    return "dropped_items";
	 	}



	    @PostMapping("/drop-item")
	    public String dropItem(@RequestParam Long menuItemId) {
	        TaskFlowManager.Entity.MenuItem menuItem = itemService.getMenuItemById(menuItemId);
	        if (menuItem != null) {
	            itemService.dropItem(menuItem);
	        }
	        return "redirect:/menu";
	    }
}
