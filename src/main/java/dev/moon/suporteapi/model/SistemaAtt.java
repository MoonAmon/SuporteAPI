package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class SistemaAtt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "sistema", nullable = false)
    private Sistema sistema;

}
