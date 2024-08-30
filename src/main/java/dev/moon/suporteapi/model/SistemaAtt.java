package dev.moon.suporteapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class SistemaAtt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "nomeFantasia", nullable = false)
    private Cliente cliente;

    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name = "nome", nullable = false)
    private Sistema sistema;

    @PrePersist
    protected void onCreate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
