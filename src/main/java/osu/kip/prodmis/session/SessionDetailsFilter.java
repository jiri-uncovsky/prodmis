package osu.kip.prodmis.session;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 101)
public class SessionDetailsFilter extends OncePerRequestFilter {

  // tag::dofilterinternal[]
  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    chain.doFilter(request, response);

    HttpSession session = request.getSession(false);
    
    if (session == null) {
      return;
    }
    SecurityContext securityContext = (SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
    if(securityContext == null) {
      return;
    }
    User user = ((User)securityContext.getAuthentication().getPrincipal());
    session.setAttribute("username", user.getUsername());
    for(GrantedAuthority authority : user.getAuthorities()) {
      if("admin".equalsIgnoreCase(authority.getAuthority())) {
        session.setAttribute("admin", "yes");
        break;
      }
    }
  }
}
