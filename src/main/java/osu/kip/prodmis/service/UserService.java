package osu.kip.prodmis.service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import osu.kip.prodmis.domain.UserLogin;
import osu.kip.prodmis.service.api.UserLoginService;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

	//get user from the database, via Hibernate
  @Autowired
	private UserLoginService userDao;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username)
		throws UsernameNotFoundException {
    List<UserLogin> users = userDao.findAll();
    UserLogin user = userDao.findOne(username);
    if(user == null) {
      return null;
    }
   
    List<GrantedAuthority> authorities = new LinkedList();
    if(user.getAdmin()) {
      authorities = Arrays.asList(new SimpleGrantedAuthority("admin"), new SimpleGrantedAuthority("user"));
    } else {
      authorities = Arrays.asList(new SimpleGrantedAuthority("user"));
    }
    return new User(username, new BCryptPasswordEncoder().encode(user.getPassword()),	true, true, true, true, authorities);
	}
}