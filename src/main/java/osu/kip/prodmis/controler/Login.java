package osu.kip.prodmis.controler;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login {
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String index(Principal principal) {
    return "login/login";
  }
}
