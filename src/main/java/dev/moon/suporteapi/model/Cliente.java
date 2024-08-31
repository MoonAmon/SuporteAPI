package dev.moon.suporteapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;

import java.sql.Timestamp;
import java.util.List;


@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFantasia;

    private String razaoSocial;

    private String cnpj;

    private Boolean isWeb;

    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    private String tokenMilvus;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Contato> contatos;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
    }

}
