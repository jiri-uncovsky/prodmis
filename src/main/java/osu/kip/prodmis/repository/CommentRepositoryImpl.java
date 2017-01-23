package osu.kip.prodmis.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;

import com.mysema.query.jpa.JPQLQuery;

import osu.kip.prodmis.domain.Comment;
import osu.kip.prodmis.domain.QComment;

@RooJpaRepositoryCustomImpl(repository = CommentRepositoryCustom.class)
public class CommentRepositoryImpl extends QueryDslRepositorySupport{

    CommentRepositoryImpl() {
        super(Comment.class);
    }
    
    private JPQLQuery getQueryFrom(QComment qEntity){
        return from(qEntity);
    }
}