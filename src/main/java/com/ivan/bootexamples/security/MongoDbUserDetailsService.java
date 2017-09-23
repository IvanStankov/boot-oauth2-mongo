package com.ivan.bootexamples.security;

import com.google.common.collect.Lists;
import com.ivan.bootexamples.entity.User;
import com.ivan.bootexamples.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mongoDbUserDetailsService")
public class MongoDbUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username: " + username);
        }


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Lists.newArrayList(new SimpleGrantedAuthority(user.getRole())));
    }
}
