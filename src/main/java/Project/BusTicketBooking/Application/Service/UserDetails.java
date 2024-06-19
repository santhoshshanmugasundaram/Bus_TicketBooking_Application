package Project.BusTicketBooking.Application.Service;


import Project.BusTicketBooking.Application.Model.Passengers;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Getter
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails, Serializable {


    //to avoid class cast exception using Serializable Interface
    private static final long serialVersionID=1L;

    private Passengers passengers;

    // Constructor
    public UserDetails(Passengers passengers){
        this.passengers=passengers;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(passengers.getRole()));
    }

    public Passengers getName(){
        return passengers;
    }

    @Override
    public String getPassword() {
        return passengers.getPassword();
    }

    @Override
    public String getUsername() {
        return passengers.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}