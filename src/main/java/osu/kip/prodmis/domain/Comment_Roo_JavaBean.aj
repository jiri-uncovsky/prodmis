// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package osu.kip.prodmis.domain;

import java.util.Calendar;
import osu.kip.prodmis.domain.Comment;
import osu.kip.prodmis.domain.Product;
import osu.kip.prodmis.domain.UserLogin;

privileged aspect Comment_Roo_JavaBean {
    
    public String Comment.getSubject() {
        return this.subject;
    }
    
    public void Comment.setSubject(String subject) {
        this.subject = subject;
    }
    
    public String Comment.getText() {
        return this.text;
    }
    
    public void Comment.setText(String text) {
        this.text = text;
    }
    
    public String Comment.getQuotedText() {
        return this.quotedText;
    }
    
    public void Comment.setQuotedText(String quotedText) {
        this.quotedText = quotedText;
    }
    
    public Calendar Comment.getCreated() {
        return this.created;
    }
    
    public void Comment.setCreated(Calendar created) {
        this.created = created;
    }
    
    public Calendar Comment.getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void Comment.setLastUpdate(Calendar lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    public UserLogin Comment.getUserLogin() {
        return this.userLogin;
    }
    
    public void Comment.setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
    
    public Comment Comment.getReplyTo() {
        return this.replyTo;
    }
    
    public void Comment.setReplyTo(Comment replyTo) {
        this.replyTo = replyTo;
    }
    
    public Product Comment.getProduct() {
        return this.product;
    }
    
    public void Comment.setProduct(Product product) {
        this.product = product;
    }
    
}
