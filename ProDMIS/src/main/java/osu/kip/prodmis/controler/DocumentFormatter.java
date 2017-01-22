package osu.kip.prodmis.controler;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;
import osu.kip.prodmis.domain.Document;
import osu.kip.prodmis.service.api.DocumentService;

@RooFormatter(entity = Document.class, service = DocumentService.class)
public class DocumentFormatter {
}
