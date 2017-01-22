package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import osu.kip.prodmis.domain.Comment;

@RooJpaRepository(entity = Comment.class)
public interface CommentRepository {
}
