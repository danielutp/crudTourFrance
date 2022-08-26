package com.co.sofka.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

/**
 * Entidad del Cyclist
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
@Table(name = "cyclist")
public class Cyclist {

    /**
     * Identificador de la tupla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Nombre del ciclista
     */
    @Column(name = "name", nullable = false, length = 100, unique = true)
    private String name;

    /**
     * Código para competir
     */
    @Column(name = "code", nullable = false, length = 30, unique = true)
    private String code;

    /**
     * Punto de enlace con la entidad Country
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Country country;

    /**
     * Punto de enlace con la entidad Team
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "team")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Team team;


}