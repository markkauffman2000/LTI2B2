package bbdn.lti2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import bbdn.lti2.dao.Lti2ProviderDomain;
import bbdn.lti2.dao.Lti2ProviderDomainDAO;
import blackboard.platform.plugin.PlugInUtil;
import blackboard.platform.spring.beans.annotations.UserAuthorization;

@Controller
public class Lti2ProviderController {

	@Autowired
	private Lti2ProviderDomainDAO _dao;
	
	@RequestMapping("/index")
	@UserAuthorization("system.admin.VIEW")
	public ModelAndView listProviders() {
		ModelAndView mv = new ModelAndView("index");
		
		List<Lti2ProviderDomain> providers = _dao.loadAll();
    	mv.addObject("providers", providers);
    	
    	String sampleRegisterPath = PlugInUtil.getUri("bbdn", "lti2", "lti2/register");
    	mv.addObject("sampleRegisterPath", sampleRegisterPath);
    	String jsFilePath = PlugInUtil.getUri("bbdn", "lti2", "register.js");
    	mv.addObject("jsFilePath", jsFilePath);
    	
    	return mv;
	}
	
}

