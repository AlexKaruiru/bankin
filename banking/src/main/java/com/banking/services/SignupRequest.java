/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.banking.services;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import java.util.Set;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class SignupRequest {

    @NonNull  
    @Size(min = 3, max = 20)  
    private String username;
 
    @NonNull  
    @Size(max = 50) 
    @Email  
    private String email;

    @NonNull
    @Size(min = 6, max = 40)
    private String password;

    @NonNull
    private Set<String> role;
}