package osu.kip.prodmis.service.api;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import osu.kip.prodmis.domain.UserLogin;

@RooService(entity = UserLogin.class)
public interface UserLoginService {
  public UserLogin findOne(String userName);
}
