package osu.kip.prodmis.controler;
import java.util.Locale;

import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;
import osu.kip.prodmis.domain.Product;
import osu.kip.prodmis.service.api.ProductService;

@RooFormatter(entity = Product.class, service = ProductService.class)
public class ProductFormatter {
	
	  public String print(Product product, Locale locale) {
	        //return product == null ? null : new StringBuilder().append(product.getCode()).append(" - ").append(product.getName()).append(" - ").append(product.getDescription()).append(" - ").append(product.getArchived()).toString();
	        return product == null ? null : new StringBuilder().append("(").append(product.getCode()).append(") ").append(product.getName()).toString();
	    }
}
