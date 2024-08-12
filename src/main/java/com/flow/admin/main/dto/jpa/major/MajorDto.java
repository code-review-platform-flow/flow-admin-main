package com.flow.admin.main.dto.jpa.major;

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
public class MajorDto {
    private Long majorId;
    private String majorName;
    private String note;
    private int version;
}
