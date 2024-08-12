package com.flow.admin.main.dto.jpa.userinfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDto {
    private Long userInfoId;
    private Long userId;
    private Long schoolId;
    private Long majorId;
    private String studentNumber;
    private String role;
    private String userName;
    private int version;
}
