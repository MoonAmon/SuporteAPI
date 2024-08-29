package model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;


@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeFantasia;

    private String cnpj;

    private Boolean isWeb;

    @Column(nullable = false)
    private Timestamp createdAt;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Contato> contatos;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

}
