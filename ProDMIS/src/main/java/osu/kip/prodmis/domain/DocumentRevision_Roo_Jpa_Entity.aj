// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package osu.kip.prodmis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
import osu.kip.prodmis.domain.DocumentRevision;

privileged aspect DocumentRevision_Roo_Jpa_Entity {
    
    declare @type: DocumentRevision: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long DocumentRevision.id;
    
    @Version
    @Column(name = "version")
    private Integer DocumentRevision.version;
    
    public Long DocumentRevision.getId() {
        return this.id;
    }
    
    public void DocumentRevision.setId(Long id) {
        this.id = id;
    }
    
    public Integer DocumentRevision.getVersion() {
        return this.version;
    }
    
    public void DocumentRevision.setVersion(Integer version) {
        this.version = version;
    }
    
}
