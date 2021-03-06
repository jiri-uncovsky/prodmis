// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package osu.kip.prodmis.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import osu.kip.prodmis.controler.DocumentController;
import osu.kip.prodmis.service.api.DocumentRevisionService;
import osu.kip.prodmis.service.api.DocumentService;

privileged aspect DocumentController_Roo_Controller {
    
    declare @type: DocumentController: @Controller;
    
    declare @type: DocumentController: @RequestMapping("/documents");
    
    public DocumentService DocumentController.documentService;
    
    public DocumentRevisionService DocumentController.documentRevisionService;
    
    @Autowired
    public DocumentController.new(DocumentService documentService, DocumentRevisionService documentRevisionService) {
        this.documentService = documentService;
        this.documentRevisionService = documentRevisionService;
    }

}
