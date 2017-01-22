package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import osu.kip.prodmis.domain.Product;

@RooJpaRepositoryCustom(entity = Product.class, defaultSearchResult = Product.class)
public interface ProductRepositoryCustom {
}
