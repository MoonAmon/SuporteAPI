package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SistemaVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String versao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sistema_id", referencedColumnName = "id")
    private Sistema sistema;
}
