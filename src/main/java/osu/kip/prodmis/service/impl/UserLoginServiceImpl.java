package osu.kip.prodmis.service.impl;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.service.api.UserLoginService;

@RooServiceImpl(service = UserLoginService.class)
public class UserLoginServiceImpl {
  public UserLogin findOne(String username) {
    return userLoginRepository.find(username);
  }
}
