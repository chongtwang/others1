package hibernate.controller;

import hibernate.account.Account;
import hibernate.person.model.Person;
import hibernate.personDAO.PersonDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@SessionAttributes("sessionObj")
public class AccountController {
	

		PersonDAO personDAO;
		
		String message = "Welcome to Spring MVC!";
 
//		@Required
		public void setPersonDAO(PersonDAO person) {
			this.personDAO = person;
		}

		@RequestMapping("/address")
		public String showAddress( ModelMap model, 
				@RequestParam(value = "term", required = false ) String term) {
			System.out.println("in controller - showAddress");
	 
			
			return "address";
		}

		@RequestMapping("/text")
		@ResponseBody
		public String showText( ModelMap model, 
				@RequestParam(value = "term", required = false ) String term) {
			System.out.println("in controller - text");
	 
			   
			String s = "text";
			
			return s;
		}

		@RequestMapping("/query")
		@ResponseBody
		public String showQuery( ModelMap model, 
				@RequestParam(value = "term", required = false, defaultValue = "G") String term) {
			System.out.println("in controller - query");
	 
			   
			String s = personDAO.getNameLikeJason( term );
			List ls = new ArrayList();
			
//			JasonZip zip = new JasonZip();
//			
//			zip.setValue("NY");
//			zip.setLabel("New York");
//			ls.add(zip);
//			
//	        // prepare JSON
//			Gson gson = new Gson();
//
//			s = gson.toJson(ls);
			
			
			return s;
		}

		@RequestMapping("/google")
		public String showGoogle( ModelMap model,
				@RequestParam(value = "name", required = false) String name
//				,@RequestBody String jsonReqString
				, HttpServletResponse response
				, HttpServletRequest request
				, HttpSession session
				) {
			System.out.println("in controller. google redirct");
	 
session.getServletContext().getContextPath(); // this give the application name
			return "redirecttogoogle";
		}

		@RequestMapping("/accounts")
		public String showAccount( Model model,
				@RequestParam(value = "name", required = false, defaultValue = "World") String name
				, HttpSession session

				) {
			
			  session.setAttribute("success" , "successfully accessed session and set attribute-success to this.");

			System.out.println("in controller");
	 
			ModelAndView mv = new ModelAndView("helloworld");
			
			List accounts = getAccountData( null );
			   
			Person se = new Person();
			se.setName("hello-session");
			
			model.addAttribute("sessionObj", se); // test session attribute
			model.addAttribute("message", "This is account list!");
			model.addAttribute("accounts", accounts);
			model.addAttribute("google", "www.google.com");
			
			System.out.println("in test_hibernate 00.");

			Logger logger=Logger.getLogger(this.getClass().getName());
			
			
			model.addAttribute("persons", getAccounts());
			
//			test_hibernate();

			return "accounts";
		}

		private List getAccounts()
		{
			return personDAO.list();
		}

		private List getAccountData( String id )
	   {
		   List h = new ArrayList();
		   
		   Account a = new Account( "1", "Machael", "Cart");
		   h.add(a);
		   a = new Account( "2", "Jerry", "Been");
		   h.add(a);
		   a = new Account( "3", "Andi", "Paul");
		   h.add(a);
		   
		   
		   return h;
		   
	   }
		

		private void test_hibernate()
		{
			System.out.println("in test_hibernate 10.");

//			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
//	         
//			System.out.println("in test_hibernate 20.");
//
//			PersonDAO personDAO = context.getBean(PersonDAO.class);
	         
	        Person person = new Person();
	        person.setName("transaction"); 
	        person.setCountry("India");
	         
			System.out.println("in test_hibernate 30.");

	        personDAO.save(person);
	         
	        System.out.println("Person::"+person);

	        //close resources
//	        context.close();    

		}

}