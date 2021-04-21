package com.loiko.alex.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alexey Loiko
 * @project carshop
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserIdAndLoginDto {

    private Long id;
    private String login;
}