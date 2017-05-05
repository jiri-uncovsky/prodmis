package osu.kip.prodmis.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * @brief true means do not allow to access, false means i do not know 
 */
class EditFormMatcher implements RequestMatcher {
  @Override
  public boolean matches(HttpServletRequest hsr) {
    Pattern p = Pattern.compile("/userlogins/([^/]*)/edit-form");
    Matcher matcher = p.matcher(hsr.getRequestURI());
    if(!matcher.matches()) {
      return false;
    }
    String id = matcher.group(1);
    HttpSession session = hsr.getSession(false);
    if(session == null) {
      return true;
    }
    if(session.getAttribute("admin") != null) {
      return false;
    }
    Object userId = session.getAttribute("id");
    if(userId == null) {
      return true;
    }
    long loggedUid;
    if(userId instanceof Long) {
      loggedUid = (Long)userId;
    } else if (userId instanceof Integer) {
      loggedUid = (Integer)userId;
    } else {
      return true;
    }
    long parsedId;
    try {
      parsedId = Long.parseLong(id);
    } catch(NumberFormatException ex) {
      return true;
    }
    
    return loggedUid != parsedId;
  }
  
}
