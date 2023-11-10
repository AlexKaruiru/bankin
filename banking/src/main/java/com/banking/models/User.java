/*/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package com.banking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
    uniqueConstraints = {
      @UniqueConstraint(columnNames = "username"),
      @UniqueConstraint(columnNames = "email")
    })
@Getter
@Setter

public class User {   
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotEmpty
  @Size(max = 20)
  private String username;
  
  @NotEmpty
  @Size(max = 50)
  @Email
  private String email;
  
  @NotEmpty
  @Size(min = 8, max = 120)
  private String password;
  
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_roles",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();
  
  public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}