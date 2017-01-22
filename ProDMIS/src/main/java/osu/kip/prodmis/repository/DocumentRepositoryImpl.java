package osu.kip.prodmis.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import osu.kip.prodmis.domain.Document;
import osu.kip.prodmis.domain.QDocument;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = DocumentRepositoryCustom.class)
public class DocumentRepositoryImpl extends QueryDslRepositorySupport{

    DocumentRepositoryImpl() {
        super(Document.class);
    }
    
    private JPQLQuery getQueryFrom(QDocument qEntity){
        return from(qEntity);
    }
}