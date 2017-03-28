package osu.kip.prodmis.controler;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import osu.kip.prodmis.domain.Organization;
import osu.kip.prodmis.service.api.OrganizationService;

@RooController(path = "/organizations", entity = Organization.class, service = OrganizationService.class)
@RooThymeleaf
public class OrganizationController {
}
