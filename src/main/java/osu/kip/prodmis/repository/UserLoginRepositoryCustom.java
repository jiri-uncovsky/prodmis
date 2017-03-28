package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import osu.kip.prodmis.domain.UserLogin;

@RooJpaRepositoryCustom(entity = UserLogin.class, defaultSearchResult = UserLogin.class)
public interface UserLoginRepositoryCustom {
}
