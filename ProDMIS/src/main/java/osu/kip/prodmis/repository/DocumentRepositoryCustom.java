package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import osu.kip.prodmis.domain.Document;

@RooJpaRepositoryCustom(entity = Document.class, defaultSearchResult = Document.class)
public interface DocumentRepositoryCustom {
}
