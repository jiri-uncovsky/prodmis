package osu.kip.prodmis.controler;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;
import osu.kip.prodmis.domain.Organization;
import osu.kip.prodmis.service.api.OrganizationService;

@RooFormatter(entity = Organization.class, service = OrganizationService.class)
public class OrganizationFormatter {
}
