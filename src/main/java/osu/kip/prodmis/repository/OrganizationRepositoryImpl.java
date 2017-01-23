package osu.kip.prodmis.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import osu.kip.prodmis.domain.Organization;
import osu.kip.prodmis.domain.QOrganization;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = OrganizationRepositoryCustom.class)
public class OrganizationRepositoryImpl extends QueryDslRepositorySupport{

    OrganizationRepositoryImpl() {
        super(Organization.class);
    }
    
    private JPQLQuery getQueryFrom(QOrganization qEntity){
        return from(qEntity);
    }
}