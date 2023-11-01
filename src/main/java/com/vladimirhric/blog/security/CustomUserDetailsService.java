package com.vladimirhric.blog.security;

import com.vladimirhric.blog.models.UserEntity;
import com.vladimirhric.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " was not found."));

        // here I made the decision to make Role class implement GrantedAuthority as User needs it (preventing the need for casting each Role)
        return new User(user.getUsername(), user.getPassword(), user.getRoles());
    }
}
