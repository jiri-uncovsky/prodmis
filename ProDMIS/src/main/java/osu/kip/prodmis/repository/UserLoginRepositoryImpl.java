package osu.kip.prodmis.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.domain.QUserLogin;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = UserLoginRepositoryCustom.class)
public class UserLoginRepositoryImpl extends QueryDslRepositorySupport{

    UserLoginRepositoryImpl() {
        super(UserLogin.class);
    }
    
    private JPQLQuery getQueryFrom(QUserLogin qEntity){
        return from(qEntity);
    }
}