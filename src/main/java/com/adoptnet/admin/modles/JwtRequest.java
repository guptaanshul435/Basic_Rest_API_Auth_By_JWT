package com.adoptnet.admin.modles;


import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class JwtRequest {
	
	private String username;
	private String password;
	
	
	

}
