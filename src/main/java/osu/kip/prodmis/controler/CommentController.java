package osu.kip.prodmis.controler;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import osu.kip.prodmis.domain.Comment;
import osu.kip.prodmis.service.api.CommentService;

@RooController(path = "/comments", entity = Comment.class, service = CommentService.class)
@RooThymeleaf
public class CommentController {
}
