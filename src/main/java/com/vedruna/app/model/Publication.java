package com.vedruna.app.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clase que representa una publicación en la red social.
 * Esta clase está mapeada a la tabla "RS_PUBLICATION" en la base de datos.
 */
@Entity
@Table(name = "RS_PUBLICATION")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Publication implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único de la publicación.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RS_PUBLICATION_ID")
    private Long publicationId;

    /**
     * Autor de la publicación.
     */
    @JsonBackReference(value = "author-publication")
    @ManyToOne
    @JoinColumn(name = "RS_PUBLICATION_AUTHOR", nullable = false)
    private User author;

    /**
     * Texto de la publicación.
     */
    @Column(name = "RS_PUBLICATION_TEXT")
    private String text;

    /**
     * La imagen asociada a la publicación.
     */
    @Lob
    @Column(name = "RS_PUBLICATION_IMAGE", columnDefinition = "LONGBLOB")
    private byte[] image;

    /**
     * Fecha de creación de la publicación.
     */
    @Column(name = "RS_PUBLICATION_CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate;

    /**
     * Fecha de edición de la publicación.
     */
    @Column(name = "RS_PUBLICATION_EDITION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime editionDate;

    /**
     * Lista de comentarios asociados a la publicación.
     */
    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
}
