package osu.kip.prodmis.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import osu.kip.prodmis.domain.Document;
import osu.kip.prodmis.service.api.DocumentService;
import osu.kip.prodmis.service.api.StorageService;

@RooController(path = "/documents", entity = Document.class, service = DocumentService.class)
@RooThymeleaf
public class DocumentController {

	@Autowired
	private StorageService storageService;

	@RequestMapping(value = "/fileUploadPOST", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		storageService.store(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");

		return "redirect:/fileUpload";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String handleTest( RedirectAttributes redirectAttributes) {

		System.out.println("test works}");
		
		return "redirect:/fileUpload";
	}

	
	  @RequestMapping(value = "/upload-form", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	    public String uploadDocumentForm(Model model) {
	        model.addAttribute(new Document());
	        populateForm(model);
	        return "documents/upload-form";
	    }
	
	
}
