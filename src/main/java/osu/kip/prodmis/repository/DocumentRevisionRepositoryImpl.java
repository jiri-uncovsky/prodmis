package osu.kip.prodmis.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import osu.kip.prodmis.domain.DocumentRevision;
import osu.kip.prodmis.domain.QDocumentRevision;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = DocumentRevisionRepositoryCustom.class)
public class DocumentRevisionRepositoryImpl extends QueryDslRepositorySupport{

    DocumentRevisionRepositoryImpl() {
        super(DocumentRevision.class);
    }
    
    private JPQLQuery getQueryFrom(QDocumentRevision qEntity){
        return from(qEntity);
    }
}