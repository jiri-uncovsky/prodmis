package osu.kip.prodmis.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.repository.UserLoginRepository;
import osu.kip.prodmis.service.api.UserLoginService;

@RooServiceImpl(service = UserLoginService.class)
public class UserLoginServiceImpl {
  
  //@Autowired
  //private UserLoginRepository userLoginRepository2;
  
  public UserLogin findOne(String username) {
    return userLoginRepository.find(username);
  }
}
