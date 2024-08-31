package dev.moon.suporteapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UrlSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String urlWeb;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "cliente_id")
    private Cliente cliente;
}
