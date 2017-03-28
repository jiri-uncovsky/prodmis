package osu.kip.prodmis.controler;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.service.api.UserLoginService;

@RooFormatter(entity = UserLogin.class, service = UserLoginService.class)
public class UserLoginFormatter {
}
