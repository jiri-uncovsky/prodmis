package osu.kip.prodmis.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.springframework.security.web.util.matcher.RequestMatcher;

public class EditFormMatecherTest {
  @Test
  public void nonmatch1() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/other-path");
    assertTrue(!matcher.matches(httpRequest));
  }
  
  @Test
  public void nonmatch2() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/userlogins/1/edit-fdm");
    assertTrue(!matcher.matches(httpRequest));
  }
  
  @Test
  public void nonum() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/userlogins/abc/edit-form");
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(httpRequest.getSession(false)).thenReturn(session);
    Mockito.when(session.getAttribute("id")).thenReturn(1L);
    assertTrue(matcher.matches(httpRequest));
  }
 
  @Test
  public void nosession() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/userlogins/1/edit-form");
    assertTrue(matcher.matches(httpRequest));
  }
  
  @Test
  public void admin() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/userlogins/1/edit-form");
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(httpRequest.getSession(false)).thenReturn(session);
    Mockito.when(session.getAttribute("admin")).thenReturn(1);
    assertTrue(!matcher.matches(httpRequest));
  }
  
  @Test
  public void nouserid() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/userlogins/1/edit-form");
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(httpRequest.getSession(false)).thenReturn(session);
    assertTrue(matcher.matches(httpRequest));
  }
  
  @Test
  public void idnomatch() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/userlogins/1/edit-form");
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(httpRequest.getSession(false)).thenReturn(session);
    Mockito.when(session.getAttribute("id")).thenReturn(2L);
    assertTrue(matcher.matches(httpRequest));
  }
  
  @Test
  public void idmatch() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/userlogins/1/edit-form");
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(httpRequest.getSession(false)).thenReturn(session);
    Mockito.when(session.getAttribute("id")).thenReturn(1L);
    assertTrue(!matcher.matches(httpRequest));
  }
  
  @Test
  public void sessionuserid_nonum() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/userlogins/1/edit-form");
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(httpRequest.getSession(false)).thenReturn(session);
    Mockito.when(session.getAttribute("id")).thenReturn("A");
    assertTrue(matcher.matches(httpRequest));
  }
  
  @Test
  public void sessionuserid_long() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/userlogins/1/edit-form");
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(httpRequest.getSession(false)).thenReturn(session);
    Mockito.when(session.getAttribute("id")).thenReturn(1L);
    assertTrue(!matcher.matches(httpRequest));
  }
    
  @Test
  public void sessionuserid_int() {
    RequestMatcher matcher = new EditFormMatcher();
    HttpServletRequest httpRequest = Mockito.mock(HttpServletRequest.class);
    Mockito.when(httpRequest.getRequestURI()).thenReturn("/userlogins/1/edit-form");
    HttpSession session = Mockito.mock(HttpSession.class);
    Mockito.when(httpRequest.getSession(false)).thenReturn(session);
    Mockito.when(session.getAttribute("id")).thenReturn(1);
    assertTrue(!matcher.matches(httpRequest));
  }
}
