package br.com.project.PharmacyManagement.DTO.DefaultErrorResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultResponse<T>{

    private Integer status;
    private T data;
    private String message;
}
