package osu.kip.prodmis.repository;

import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import osu.kip.prodmis.domain.Product;
import osu.kip.prodmis.domain.QProduct;
import com.mysema.query.jpa.JPQLQuery;

@RooJpaRepositoryCustomImpl(repository = ProductRepositoryCustom.class)
public class ProductRepositoryImpl extends QueryDslRepositorySupport{

    ProductRepositoryImpl() {
        super(Product.class);
    }
    
    private JPQLQuery getQueryFrom(QProduct qEntity){
        return from(qEntity);
    }
}