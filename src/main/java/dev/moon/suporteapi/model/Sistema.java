package dev.moon.suporteapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SistemaType tipo;

    @OneToMany(mappedBy = "sistema")
    private List<SistemaVersion> sistemaVersion;

}
