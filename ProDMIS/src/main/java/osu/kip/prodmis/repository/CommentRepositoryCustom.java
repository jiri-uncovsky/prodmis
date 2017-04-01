package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import osu.kip.prodmis.domain.Comment;

@RooJpaRepositoryCustom(entity = Comment.class, defaultSearchResult = Comment.class)
public interface CommentRepositoryCustom {
}
