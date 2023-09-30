package com.project.ExpenseTracker.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User implements UserDetails{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String status = "ACTIVE";
    private String password;  
    @Transient
    private List<Transaction> transactions = new ArrayList<>();
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="user_role_junction",
        joinColumns = {@JoinColumn(name="user_id")},
        inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private Set<Role> authorities;	
    
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public User(Long userId, String username, String password, Set<Role> authorities) {
		super();
		this.id = userId;
		this.email = username;
		this.password = password;
		this.authorities = authorities;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", status=" + status + ", password="
				+ password + "]";
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return this.status.equals("ACTIVE");
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return this.status.equals("ACTIVE");
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return this.status.equals("ACTIVE");
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.status.equals("ACTIVE");
	}

}
