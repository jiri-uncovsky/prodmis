package osu.kip.prodmis.controler;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import osu.kip.prodmis.domain.Document;
import osu.kip.prodmis.service.api.DocumentService;

@RooController(path = "/documents", entity = Document.class, service = DocumentService.class)
@RooThymeleaf
public class DocumentController {
}
