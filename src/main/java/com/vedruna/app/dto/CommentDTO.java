package com.vedruna.app.dto;

import java.time.LocalDateTime;

import com.vedruna.app.model.Comment;
import com.vedruna.app.model.Publication;
import com.vedruna.app.model.User;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * DTO (Data Transfer Object) que representa un comentario en la red social.
 */
@Getter
@Setter
public class CommentDTO {
    private Long userId;
    private Long publicationId;
    private String text;
    private MultipartFile image;
    private LocalDateTime creationDate;
    
    /**
     * Convierte este objeto CommentDTO a una entidad Comment.
     *
     * @param user       Usuario que realiza el comentario.
     * @param publication Publicación a la que se realiza el comentario.
     * @return Objeto Comment creado a partir de este CommentDTO.
     */
    public Comment toEntity(User user, Publication publication) {
        Comment comment = new Comment();
        comment.setUser(user);
        comment.setPublication(publication);
        comment.setText(text);
        comment.setCreationDate(LocalDateTime.now());
        return comment;
    }
}
