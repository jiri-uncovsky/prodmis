package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import osu.kip.prodmis.domain.UserLogin;

@RooJpaRepository(entity = UserLogin.class)
public interface UserLoginRepository {
  public UserLogin find(String username);
}
