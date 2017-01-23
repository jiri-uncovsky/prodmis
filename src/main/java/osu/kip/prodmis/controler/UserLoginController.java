package osu.kip.prodmis.controler;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.service.api.UserLoginService;

@RooController(path = "/userlogins", entity = UserLogin.class, service = UserLoginService.class)
@RooThymeleaf
public class UserLoginController {
}
