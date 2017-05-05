package osu.kip.prodmis.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.domain.QUserLogin;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.BooleanBuilder;
import java.util.List;

@RooJpaRepositoryCustomImpl(repository = UserLoginRepositoryCustom.class)
public class UserLoginRepositoryImpl extends QueryDslRepositorySupport{

    UserLoginRepositoryImpl() {
        super(UserLogin.class);
    }
    
    private JPQLQuery getQueryFrom(QUserLogin qEntity){
        return from(qEntity);
    }
    
    public UserLogin find(String username) {
        QUserLogin userLogin = QUserLogin.userLogin;
        JPQLQuery query = getQueryFrom(userLogin);
        BooleanBuilder where = new BooleanBuilder();
        where.and(userLogin.username.containsIgnoreCase(username));
        query.where(where);

        List<UserLogin> results = query.list(userLogin);
        if(results.isEmpty()) {
          return null;
        }
        return results.get(0);
    }
}