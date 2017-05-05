package osu.kip.prodmis.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

class LogoutHandlerImpl implements LogoutHandler {

  @Override
  public void logout(HttpServletRequest hsr, HttpServletResponse hsr1, Authentication a) {
    a.setAuthenticated(false);
    hsr.removeAttribute("username");
    hsr.removeAttribute("admin");
  }
  
}
