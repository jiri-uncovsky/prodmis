// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package osu.kip.prodmis.service.api;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import osu.kip.prodmis.domain.Organization;
import osu.kip.prodmis.domain.Product;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.repository.GlobalSearch;
import osu.kip.prodmis.service.api.ProductService;

privileged aspect ProductService_Roo_Service {
    
    @Transactional(readOnly = false)
    public abstract Product ProductService.save(Product entity);    
    @Transactional(readOnly = false)
    public abstract void ProductService.delete(Long id);    
    @Transactional(readOnly = false)
    public abstract List<Product> ProductService.save(Iterable<Product> entities);    
    @Transactional(readOnly = false)
    public abstract void ProductService.delete(Iterable<Long> ids);    
    public abstract List<Product> ProductService.findAll();    
    public abstract List<Product> ProductService.findAll(Iterable<Long> ids);    
    public abstract Product ProductService.findOne(Long id);    
    public abstract long ProductService.count();    
    public abstract Page<Product> ProductService.findAll(GlobalSearch globalSearch, Pageable pageable);    
    public abstract Page<Product> ProductService.findAllByOrganization(Organization organizationField, GlobalSearch globalSearch, Pageable pageable);    
    public abstract Page<Product> ProductService.findAllByUserLogin(UserLogin userLoginField, GlobalSearch globalSearch, Pageable pageable);    
    public abstract Long ProductService.countByOrganizationId(Long id);    
    public abstract Long ProductService.countByProductManagerId(Long id);    
}
