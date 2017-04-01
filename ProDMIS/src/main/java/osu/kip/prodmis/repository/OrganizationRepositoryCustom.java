package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import osu.kip.prodmis.domain.Organization;

@RooJpaRepositoryCustom(entity = Organization.class, defaultSearchResult = Organization.class)
public interface OrganizationRepositoryCustom {
}
