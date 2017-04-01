package osu.kip.prodmis.controler;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.formatters.RooFormatter;
import osu.kip.prodmis.domain.Comment;
import osu.kip.prodmis.service.api.CommentService;

@RooFormatter(entity = Comment.class, service = CommentService.class)
public class CommentFormatter {
}
