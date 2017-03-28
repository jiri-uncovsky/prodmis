package osu.kip.prodmis.controler;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import osu.kip.prodmis.domain.Product;
import osu.kip.prodmis.service.api.ProductService;

@RooController(path = "/products", entity = Product.class, service = ProductService.class)
@RooThymeleaf
public class ProductController {
}
