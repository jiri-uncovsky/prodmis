package osu.kip.prodmis.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import osu.kip.prodmis.domain.Organization;
import osu.kip.prodmis.domain.Product;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.repository.GlobalSearch;
import osu.kip.prodmis.service.api.OrganizationService;
import osu.kip.prodmis.service.api.ProductService;
import osu.kip.prodmis.service.api.UserLoginService;

@RooController(path = "/products", entity = Product.class, service = ProductService.class)
@RooThymeleaf
@SessionAttributes({"user_org_id", "id"})


public class ProductController {

	@Autowired
	private OrganizationService organizationService;

	@RequestMapping(value="/forUserOrg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Product> listPerOrg(GlobalSearch search, Pageable pageable, @ModelAttribute("user_org_id") Long orgId) {
		// Page<Product> product = productService.findAll(search, pageable);
		Page<Product> product = productService.findAllByOrganization(organizationService.findOne(orgId), search, pageable);

		return product;
	}

//----------------------------------------
	
	@Autowired
	private UserLoginService userLogin;

	
	@RequestMapping(value="/list-MP", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String listMP(Model model) {
        return "products/list-MP";
    }
	
	@RequestMapping(value="/listmps", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<Product> listPerUsr(GlobalSearch search, Pageable pageable, @ModelAttribute("user_org_id") Long orgId) {
		Page<Product> products = productService.findAllByOrganization(organizationService.findOne(orgId), search, pageable);

		return products;
	}
	
	@Autowired
	private UserLoginService userloginService;
	
	@RequestMapping(value="/newforuser",method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String createForUser(@Valid @ModelAttribute Product product, BindingResult result, RedirectAttributes redirectAttrs, Model model, @ModelAttribute("id") Long usrId, @ModelAttribute("user_org_id") Long orgId) {
        if (result.hasErrors()) {
            populateForm(model);
            return "products/create";
        }
          UserLogin productManager = userloginService.findOne(usrId);
          product.setProductManager(productManager);
          Organization organization = organizationService.findOne(orgId);
          product.setOrganization(organization);	  
          Product newProduct = productService.save(product);
          redirectAttrs.addAttribute("id", newProduct.getId());
        return "redirect:/products/{id}";
    }

}
