package dev.moon.suporteapi.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClienteUpdateDTO {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private Boolean isWeb;
    private String tokenMilvus;

}
