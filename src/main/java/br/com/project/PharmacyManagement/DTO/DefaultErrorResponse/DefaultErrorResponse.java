package br.com.project.PharmacyManagement.DTO.DefaultErrorResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultErrorResponse {

    private Integer status;
    private String messages;
    private Throwable cause;
}
