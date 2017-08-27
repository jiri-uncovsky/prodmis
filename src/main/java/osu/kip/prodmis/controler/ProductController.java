package osu.kip.prodmis.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import osu.kip.prodmis.domain.Product;
import osu.kip.prodmis.repository.GlobalSearch;
import osu.kip.prodmis.service.api.OrganizationService;
import osu.kip.prodmis.service.api.ProductService;

@RooController(path = "/products", entity = Product.class, service = ProductService.class)
@RooThymeleaf
@SessionAttributes("user_org_id")
public class ProductController {

	@Autowired
	private OrganizationService organization;

	@RequestMapping(value="/forUserOrg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Product> listPerOrg(GlobalSearch search, Pageable pageable, @ModelAttribute("user_org_id") Long orgId) {
		// Page<Product> product = productService.findAll(search, pageable);
		Page<Product> product = productService.findAllByOrganization(organization.findOne(orgId), search, pageable);

		return product;
	}

}
