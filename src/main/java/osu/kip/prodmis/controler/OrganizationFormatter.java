package osu.kip.prodmis.controler;
import java.util.Locale;

import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;
import osu.kip.prodmis.domain.Organization;
import osu.kip.prodmis.service.api.OrganizationService;

@RooFormatter(entity = Organization.class, service = OrganizationService.class)
public class OrganizationFormatter {
	
	public String print(Organization organization, Locale locale) {
       // return organization == null ? null : new StringBuilder().append(organization.getName()).append(" - ").append(organization.getAddressStreet()).append(" - ").append(organization.getAddressCity()).append(" - ").append(organization.getAddressCountry()).append(" - ").append(organization.getAddressPostcode()).toString();
		  return organization == null ? null : new StringBuilder().append(organization.getName()).toString();
	}
}
