package osu.kip.prodmis.controler;
import java.util.Locale;

import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.service.api.UserLoginService;

@RooFormatter(entity = UserLogin.class, service = UserLoginService.class)
public class UserLoginFormatter {
	
	
	  public String print(UserLogin userLogin, Locale locale) {
	    
		 // return userLogin == null ? null : new StringBuilder().append(userLogin.getUsername()).append(" - ").append(userLogin.getPassword()).append(" - ").append(userLogin.getName()).append(" - ").append(userLogin.getSurname()).append(" - ").append(userLogin.getEmail()).toString();
		  return userLogin == null ? null : new StringBuilder().append(userLogin.getName()).append(" ").append(userLogin.getSurname()).toString();
	  }
	  
	    
	
}
