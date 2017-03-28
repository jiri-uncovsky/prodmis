package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import osu.kip.prodmis.domain.Document;

@RooJpaRepository(entity = Document.class)
public interface DocumentRepository {
}
