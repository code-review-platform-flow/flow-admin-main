package com.flow.admin.main.dto.jpa.comments;

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
public class CommentsDto {
    private Long commentId;
    private Long postId;
    private Long userId;
    private String content;
    private int version;
}
