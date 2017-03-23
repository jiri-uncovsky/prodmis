package osu.kip.prodmis.service;

import java.lang.reflect.Method;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.service.api.UserLoginService;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

	//get user from the database, via Hibernate
  //@Autowired
	//private UserLoginService userDao;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username)
		throws UsernameNotFoundException {
//    UserLogin l = userDao.findOne(1L);
//    for(Method m : userDao.getClass().getMethods()) {
//      System.out.println(m);
//    }
    //userDao.getUserInfo()
		//UserLogin user = ((UserLoginService)userDao)
		//List<GrantedAuthority> authorities =
    //                                  buildUserAuthority(user.getUserRole());

		//return buildUserForAuthentication(user, authorities);
    //return new User(user.getUsername(), user.getPassword(),	user.isEnabled(), true, true, true, null);
  
    
    //auth.jdbcAuthentication()
      //      .dataSource(dataSource).getUserDetailsService().loadUserByUsername(auth.);
  
    //userDao
    return new User("jirka", "$2a$06$mF0HrDwFMxlakKz/9zrzIu.kbRBuyMd3k9uTKsbqDcWyI238Np9Dq",	true, true, true, true, Arrays.asList(new SimpleGrantedAuthority("admin")));
	}
//
//	// Converts com.mkyong.users.model.User user to
//	// org.springframework.security.core.userdetails.User
//	private User buildUserForAuthentication(User user,
//		List<GrantedAuthority> authorities) {
//		return new User(user.getUsername(), user.getPassword(),
//			user.isEnabled(), true, true, true, authorities);
//	}
//
//	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
//
//		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//		// Build user's authorities
//		for (UserRole userRole : userRoles) {
//			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
//		}
//
//		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
//
//		return Result;
//	}
}