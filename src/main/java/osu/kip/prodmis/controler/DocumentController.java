package osu.kip.prodmis.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import osu.kip.prodmis.domain.Document;
import osu.kip.prodmis.domain.DocumentRevision;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.service.api.DocumentService;
import osu.kip.prodmis.service.api.StorageService;
import osu.kip.prodmis.service.api.UserLoginService;

@RooController(path = "/documents", entity = Document.class, service = DocumentService.class)
@RooThymeleaf
@SessionAttributes("id")
public class DocumentController {

	@Autowired
	private StorageService storageService;

	@Autowired
	private UserLoginService userloginService;

//	@Autowired
//	private ProductService productService;

	
	@RequestMapping(value = "/fileUploadPOST", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		storageService.store(file,"");
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
	

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	public String uploadFile( @RequestParam("file") MultipartFile file,@Valid @ModelAttribute Document document,BindingResult result,  @ModelAttribute("id") Long id, RedirectAttributes redirectAttrs, Model model) {
	    if (result.hasErrors()) {
	        populateForm(model);
	        return "documents/upload-form";
	    }
	     
	    UserLogin createdBy = userloginService.findOne(id);
		document.setCreatedBy(createdBy);  
	    document.setName(file.getOriginalFilename());
	    document.setType("generic document");
//      Product product = productService.findAllByUserLogin(createdBy, null, null).getContent().get(0);
//	    document.setProduct(product);
	    Document newDocument = documentService.save(document);
	    	    
	    DocumentRevision documentRevision = new DocumentRevision();
	    String fprefix = "d"+ newDocument.getId().toString() + "-v1-";
	    documentRevision.setFileName(fprefix + file.getOriginalFilename());
	    documentRevision.setRevisionVersion("1");
	    documentRevision.setFilePath("");
	    documentRevision.setDocument(newDocument);
	    documentRevision.setComment("initial version");
	    documentRevision.setCreatedBy(createdBy);
	    documentRevision.setState("new");
	    documentRevisionService.save(documentRevision);
    
	    storageService.store(file,fprefix);
	    
	    redirectAttrs.addAttribute("id", newDocument.getId());
	    return "redirect:/documents/{id}";
   } 
}
