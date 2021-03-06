// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package osu.kip.prodmis.controler;

import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import osu.kip.prodmis.controler.UserLoginController;
import osu.kip.prodmis.datatables.DatatablesData;
import osu.kip.prodmis.datatables.DatatablesPageable;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.repository.GlobalSearch;

privileged aspect UserLoginController_Roo_Thymeleaf {
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String UserLoginController.list(Model model) {
        return "userlogins/list";
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<UserLogin> UserLoginController.list(GlobalSearch search, Pageable pageable) {
        Page<UserLogin> userLogin = userLoginService.findAll(search, pageable);
        return userLogin;
    }
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/vnd.datatables+json")
    @ResponseBody
    public DatatablesData<UserLogin> UserLoginController.list(GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<UserLogin> userLogin = list(search, pageable);
        long allAvailableUserLogin = userLoginService.count();
        return new DatatablesData<UserLogin>(userLogin, allAvailableUserLogin, draw);
    }
    
    @RequestMapping(value = "/create-form", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String UserLoginController.createForm(Model model) {
        model.addAttribute(new UserLogin());
        populateForm(model);
        return "userlogins/create";
    }
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
    public String UserLoginController.create(@Valid @ModelAttribute UserLogin userLogin, BindingResult result, RedirectAttributes redirectAttrs, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return "userlogins/create";
        }
        UserLogin newUserLogin = userLoginService.save(userLogin);
        redirectAttrs.addAttribute("id", newUserLogin.getId());
        return "redirect:/userlogins/{id}";
    }
    
    @RequestMapping(value = "/{userLogin}/edit-form", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String UserLoginController.editForm(@PathVariable("userLogin") UserLogin userLogin, Model model) {
        populateForm(model);
        return "userlogins/edit";
    }
    
    @RequestMapping(value = "/{userLogin}", method = RequestMethod.PUT, produces = MediaType.TEXT_HTML_VALUE)
    public String UserLoginController.update(@Valid @ModelAttribute UserLogin userLogin, BindingResult result, RedirectAttributes redirectAttrs, Model model) {
        if (result.hasErrors()) {
            populateForm(model);
            return "userlogins/edit";
        }
        UserLogin savedUserLogin = userLoginService.save(userLogin);
        redirectAttrs.addAttribute("id", savedUserLogin.getId());
        return "redirect:/userlogins/{id}";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_HTML_VALUE)
    public String UserLoginController.delete(@PathVariable("id") Long id, Model model) {
        userLoginService.delete(id);
        return "redirect:/userlogins";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity UserLoginController.delete(@PathVariable("id") Long id) {
        userLoginService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{userLogin}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String UserLoginController.show(@PathVariable("userLogin") UserLogin userLogin, Model model) {
        return "userlogins/show";
    }
    
    public void UserLoginController.populateForm(Model model) {
        populateFomats(model);
    }
    
    public void UserLoginController.populateFomats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("createTime_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
}
