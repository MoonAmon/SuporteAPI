package model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @OneToMany(mappedBy = "sistema")
    private List<SistemaVersion> sistemaVersion;

}
