package osu.kip.prodmis.web;
import java.util.Locale;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleafMainController;
import org.springframework.web.bind.annotation.RequestMapping;

@RooThymeleafMainController
public class MainController {
  @RequestMapping("/")
    public String root(Locale locale) {
        return "redirect:/index.html";
    }
    
    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }
}
