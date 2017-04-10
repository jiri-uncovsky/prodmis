package osu.kip.prodmis.repository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import osu.kip.prodmis.domain.Product;

@RooJpaRepository(entity = Product.class)
public interface ProductRepository {
}
