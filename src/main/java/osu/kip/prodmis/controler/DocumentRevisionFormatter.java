package osu.kip.prodmis.controler;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;
import osu.kip.prodmis.domain.DocumentRevision;
import osu.kip.prodmis.service.api.DocumentRevisionService;

@RooFormatter(entity = DocumentRevision.class, service = DocumentRevisionService.class)
public class DocumentRevisionFormatter {
}
