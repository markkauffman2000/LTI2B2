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
import bbdn.lti2.beans.Lti2Description;
import bbdn.lti2.dao.Lti2DescriptionDAO;
import blackboard.base.FormattedText;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Lti2TestsController {

	@Autowired
	private Lti2ContactDAO _contactDAO;
        
        @Autowired Lti2DescriptionDAO _descriptionDAO;
	
	@RequestMapping("/lti2contacttest")
	public ModelAndView lti2contacttest( HttpServletRequest request, HttpServletResponse response )
	{
            String result = "";
            ModelAndView mv = new ModelAndView("testresult");
            ArrayList<String> obj = new ArrayList<String>();

            /*This is how elements should be added to the array list*/
            obj.add("Ajeet");
            obj.add("Harry");
            obj.add("Chaitanya");
            
            Lti2Contact startLti2Contact = new Lti2Contact();
            Contact contact = new Contact("john.doe@company.com");
            contact.setAdditionalProperties("arrayList", obj);
            contact.setAdditionalProperties("phone", "1-785-123-4567");
            contact.setAdditionalProperties("age", 27);
           
            startLti2Contact.setContact(contact);
            
            Lti2Contact existingContact = _contactDAO.loadByEmail(contact.getEmail());
            
            if ( existingContact == null)
                _contactDAO.save(startLti2Contact);
            else {
                existingContact.setContact(contact);
                _contactDAO.update(existingContact);
            }
            
            Lti2Contact lti2contact = _contactDAO.loadByEmail(contact.getEmail());
            
            if (lti2contact == null){
                result = "There was a problem with Lti2ContactDAO testing save, update, or loadByEmail.";
            } else {
                Contact theContact = lti2contact.getContact();
                result = theContact.getEmail();
                String phone = (String) theContact.getAdditionalProperties().get("phone");
                result = result + " phone:" + phone;
            }
            mv.addObject("result", result);
            return mv;   
	}//public ModelAndView lti2contacttest(
        
	@RequestMapping("/lti2descriptiontest")
	public ModelAndView lti2descriptiontest( HttpServletRequest request, HttpServletResponse response )
	{
            String result = "";
            ModelAndView mv = new ModelAndView("testresult");
            ArrayList<String> obj = new ArrayList<String>();

            /*This is how elements should be added to the array list*/
            obj.add("Ajeet");
            obj.add("Harry");
            obj.add("Chaitanya");
            
            Lti2Description startLti2Description = new Lti2Description();
            Description description = new Description("The default_value is the description text. The Description key on construction is product.vendor.description");
            description.setAdditionalProperties("arrayList", obj);
            description.setAdditionalProperties("phone", "1-785-123-4567");
            description.setAdditionalProperties("age", 27);
           
            startLti2Description.setDescription(description);
            
            Lti2Description existingDescription = _descriptionDAO.loadByKey(description.getKey());
            
            if ( existingDescription == null)
                _descriptionDAO.save(startLti2Description);
            else {
                existingDescription.setDescription(description);
                _descriptionDAO.update(existingDescription);
            }
            
            Lti2Description lti2contact = _descriptionDAO.loadByKey(description.getKey());
            
            if (lti2contact == null){
                result = "There was a problem with Lti2DescriptionDAO testing save, update, or loadByEmail.";
            } else {
                Description theDescription = lti2contact.getDescription();
                result = theDescription.getKey();
                String desString = theDescription.getDefault_value();
                result = result + " default_value:" + desString;
                String age = (String) theDescription.getAdditionalProperties().get("age").toString();
                result = result + " age:" + age;
            }
            mv.addObject("result", result);
            return mv;   
	}//public ModelAndView lti2descriptiontest(        

}// Lti2TestsController
