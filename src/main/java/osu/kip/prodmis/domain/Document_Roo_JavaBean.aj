// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package osu.kip.prodmis.domain;

import java.util.Set;
import osu.kip.prodmis.domain.Document;
import osu.kip.prodmis.domain.DocumentRevision;
import osu.kip.prodmis.domain.Product;
import osu.kip.prodmis.domain.UserLogin;

privileged aspect Document_Roo_JavaBean {
    
    public String Document.getName() {
        return this.name;
    }
    
    public void Document.setName(String name) {
        this.name = name;
    }
    
    public String Document.getType() {
        return this.type;
    }
    
    public void Document.setType(String type) {
        this.type = type;
    }
    
    public String Document.getDescription() {
        return this.description;
    }
    
    public void Document.setDescription(String description) {
        this.description = description;
    }
    
    public Product Document.getProduct() {
        return this.product;
    }
    
    public void Document.setProduct(Product product) {
        this.product = product;
    }
    
    public UserLogin Document.getCreatedBy() {
        return this.createdBy;
    }
    
    public void Document.setCreatedBy(UserLogin createdBy) {
        this.createdBy = createdBy;
    }
    
    public Set<DocumentRevision> Document.getRevisions() {
        return this.revisions;
    }
    
    public void Document.setRevisions(Set<DocumentRevision> revisions) {
        this.revisions = revisions;
    }
    
}
