package model;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "empresa", nullable = false)
    private Cliente empresa;
}
