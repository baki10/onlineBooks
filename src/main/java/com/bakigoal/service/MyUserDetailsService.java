package com.bakigoal.service;

import com.bakigoal.dao.SimpleDao;
import com.bakigoal.model.User;
import com.bakigoal.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ilmir on 29.12.15.
 */
@Service("customUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

  //get user from the database, via Hibernate
  @Autowired
  private SimpleDao simpleDao;

  @Transactional(readOnly = true)
  @Override
  public UserDetails loadUserByUsername(final String username)
      throws UsernameNotFoundException {

    User user = (User) simpleDao.findById(User.class, username);
    List<GrantedAuthority> authorities =
        buildUserAuthority(user.getUserRole());

    return buildUserForAuthentication(user, authorities);

  }

  // Converts User user to
  // org.springframework.security.core.userdetails.User
  private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
                                                                                        List<GrantedAuthority> authorities) {
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
        user.isEnabled(), true, true, true, authorities);
  }

  private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
    Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
    // Build user's authorities
    for (UserRole userRole : userRoles) {
      setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
    }
    List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
    return Result;
  }

}