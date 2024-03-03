package com.vedruna.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Clase que representa un comentario en la red social.
 * Esta clase está mapeada a la tabla "RS_COMMENT" en la base de datos.
 */
@Entity
@Table(name = "RS_COMMENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del comentario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RS_COMMENT_ID")
    private Long commentId;

    /**
     * Usuario que realiza el comentario.
     */
    @ManyToOne
    @JoinColumn(name = "RS_COMMENT_USER_ID", nullable = false)
    private User user;

    /**
     * Publicación a la que se realiza el comentario.
     */
    @ManyToOne
    @JoinColumn(name = "RS_COMMENT_PUBLICATION_ID", nullable = false)
    private Publication publication;

    /**
     * Texto del comentario.
     */
    @Column(name = "RS_COMMENT_TEXT")
    private String text;

    /**
     * Imagen del comentario.
     */
    @Lob
    @Column(name = "RS_COMMENT_IMAGE", columnDefinition = "LONGBLOB")
    private byte[] image;

    /**
     * Fecha de creación del comentario.
     */
    @Column(name = "RS_COMMENT_CREATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime creationDate;
}
