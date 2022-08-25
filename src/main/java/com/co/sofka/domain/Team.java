package com.co.sofka.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad del Equipo
 *
 * @version 1.0.0 2022-03-24
 * @author Daniel Gil <daniel.gil@sofka.com.co>
 * @since 1.0.0
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team {

    /**
     * Identificador de la tupla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Nombre del equipo
     */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * Código abreviado único
     */
    @Column(name = "code", nullable = false, length = 30)
    private String code;

    /**
     * Punto de enlace entre la entidad del Team y Cyclist
     */
    @OneToMany(
            cascade = CascadeType.REMOVE,
            mappedBy = "team"
    )
    private Set<Cyclist> cyclists = new HashSet<>();

    /**
     * Punto de enlace con la entidad Team
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team_country", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Country country;


}