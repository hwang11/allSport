package com.teamSupport.allSport.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String user_key;
    private String user_nickname;
    private String user_status;
    private String user_registeredAt;
    private String user_expiredAt;
    
}
