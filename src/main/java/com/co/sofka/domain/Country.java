package com.co.sofka.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad del Country
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
@Table(name = "country")
public class Country {

    /**
     * Identificador de la tupla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Nombre del pais
     */
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    /**
     * Código del pais
     */
    @Column(name = "code", nullable = false, length = 30)
    private String code;

    /**
     * Punto de enlace entre la entidad del Team y Country
     */
    @OneToMany(
            cascade = CascadeType.REMOVE,
            mappedBy = "country"
    )
    private Set<Team> teams = new HashSet<>();

    /**
     * Punto de enlace entre la entidad del Team y Cyclist
     */
    @OneToMany(
            cascade = CascadeType.REMOVE,
            mappedBy = "country"
    )
    private Set<Cyclist> cyclists = new HashSet<>();


}
