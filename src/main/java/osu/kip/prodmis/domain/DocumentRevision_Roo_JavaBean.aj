// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package osu.kip.prodmis.domain;

import osu.kip.prodmis.domain.Document;
import osu.kip.prodmis.domain.DocumentRevision;
import osu.kip.prodmis.domain.UserLogin;

privileged aspect DocumentRevision_Roo_JavaBean {
    
    public String DocumentRevision.getRevisionVersion() {
        return this.revisionVersion;
    }
    
    public void DocumentRevision.setRevisionVersion(String revisionVersion) {
        this.revisionVersion = revisionVersion;
    }
    
    public String DocumentRevision.getComment() {
        return this.comment;
    }
    
    public void DocumentRevision.setComment(String comment) {
        this.comment = comment;
    }
    
    public String DocumentRevision.getState() {
        return this.state;
    }
    
    public void DocumentRevision.setState(String state) {
        this.state = state;
    }
    
    public String DocumentRevision.getFileName() {
        return this.fileName;
    }
    
    public void DocumentRevision.setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public String DocumentRevision.getFilePath() {
        return this.filePath;
    }
    
    public void DocumentRevision.setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public UserLogin DocumentRevision.getCreatedBy() {
        return this.createdBy;
    }
    
    public void DocumentRevision.setCreatedBy(UserLogin createdBy) {
        this.createdBy = createdBy;
    }
    
    public Document DocumentRevision.getDocument() {
        return this.document;
    }
    
    public void DocumentRevision.setDocument(Document document) {
        this.document = document;
    }
    
}
