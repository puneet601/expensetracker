package com.project.ExpenseTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
	
	public Long id;

    public String name;
    public String email;
    public String status = "ACTIVE";
    public String password;  

}
