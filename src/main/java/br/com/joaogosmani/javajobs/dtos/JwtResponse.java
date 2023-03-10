package br.com.joaogosmani.javajobs.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    
    private String token;

    private String type;

    private Date expiresAt; 

    private String refreshToken;

}
