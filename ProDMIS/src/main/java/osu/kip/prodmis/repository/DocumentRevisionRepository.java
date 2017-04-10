package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import osu.kip.prodmis.domain.DocumentRevision;

@RooJpaRepository(entity = DocumentRevision.class)
public interface DocumentRevisionRepository {
}
