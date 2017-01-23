package osu.kip.prodmis.controler;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import osu.kip.prodmis.domain.DocumentRevision;
import osu.kip.prodmis.service.api.DocumentRevisionService;

@RooController(path = "/documentrevisions", entity = DocumentRevision.class, service = DocumentRevisionService.class)
@RooThymeleaf
public class DocumentRevisionController {
}
