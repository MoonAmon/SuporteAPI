package dev.moon.suporteapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class SistemaVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String versao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Sistema sistema;

}
