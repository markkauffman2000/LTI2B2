package bbdn.lti2.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.imsglobal.lti2.objects.*;

import bbdn.lti2.beans.Lti2Contact;
import bbdn.lti2.dao.Lti2ContactDAO;
import blackboard.base.FormattedText;

@Controller
public class Lti2TestsController {

	@Autowired
	private Lti2ContactDAO _contactDAO;
	
	@RequestMapping("/lti2contacttest")
	public ModelAndView lti2contacttest( HttpServletRequest request, HttpServletResponse response )
	{
            String result = "";
            ModelAndView mv = new ModelAndView("testresult");
            
            Lti2Contact startLti2Contact = new Lti2Contact();
            Contact contact = new Contact("john.doe@company.com");
            startLti2Contact.setContact(contact);
            _contactDAO.save(startLti2Contact);
            
            Lti2Contact lti2contact = _contactDAO.load();
            
            result = lti2contact.getEmail();
            mv.addObject("result", result);

            return mv;   
	}

}// Lti2TestsController
