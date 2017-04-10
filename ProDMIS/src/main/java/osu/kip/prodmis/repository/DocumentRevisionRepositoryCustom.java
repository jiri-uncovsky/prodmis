package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import osu.kip.prodmis.domain.DocumentRevision;

@RooJpaRepositoryCustom(entity = DocumentRevision.class, defaultSearchResult = DocumentRevision.class)
public interface DocumentRevisionRepositoryCustom {
}
