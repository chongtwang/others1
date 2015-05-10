package hibernate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class ModelController {
	String message = "Welcome to Spring MVC!";
 
//	@RequestMapping("/hello")
//	public ModelAndView showMessage(
//			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
//		System.out.println("in controller");
// 
//		ModelAndView mv = new ModelAndView("helloworld");
//		mv.addObject("message", message);
//		mv.addObject("name", name);
//		return mv;
//	}
	   @RequestMapping(value = "/model", method = RequestMethod.GET)
	   public String printHello(ModelMap model) {
		   
		   ModelAndView mv = new ModelAndView("helloworld");

		   model.addAttribute("message", "Hello Spring MVC Framework!");
		   
		   return "model";
	   }

//		@RequestMapping("/hello")
//		public ModelAndView showMessage(
//				@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
//			System.out.println("in controller");
//	 
//			ModelAndView mv = new ModelAndView("helloworld");
//			
////			List accounts = getAccountData( null );
//			   
//			mv.addObject("message", "Hello Spring MVC Framework!");
//			
//			mv.addObject("message", message);
//			mv.addObject("name", name);
//			return mv;
//		}

//		@RequestMapping("/accounts")
//		public String showAccount( ModelMap model,
//				@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
//			System.out.println("in controller");
//	 
//			ModelAndView mv = new ModelAndView("helloworld");
//			
//			List accounts = getAccountData( null );
//			   
//			model.addAttribute("message", "This is account list!");
//			model.addAttribute("accounts", accounts);
//			model.addAttribute("google", "www.google.com");
//
//			return "accounts";
//		}
//
//		private List getAccountData( String id )
//	   {
//		   List h = new ArrayList();
//		   
//		   Account a = new Account( "1", "Machael", "Cart");
//		   h.add(a);
//		   a = new Account( "2", "Jerry", "Been");
//		   h.add(a);
//		   a = new Account( "3", "Andi", "Paul");
//		   h.add(a);
//		   
//		   
//		   return h;
//		   
//	   }

}