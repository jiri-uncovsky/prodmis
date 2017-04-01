package osu.kip.prodmis.controler;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;
import osu.kip.prodmis.domain.Product;
import osu.kip.prodmis.service.api.ProductService;

@RooFormatter(entity = Product.class, service = ProductService.class)
public class ProductFormatter {
}
