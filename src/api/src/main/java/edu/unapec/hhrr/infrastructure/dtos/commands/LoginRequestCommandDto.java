package edu.unapec.hhrr.infrastructure.dtos.commands;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestCommandDto {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
