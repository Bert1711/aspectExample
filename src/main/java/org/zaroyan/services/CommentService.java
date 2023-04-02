package org.zaroyan.services;

import org.springframework.stereotype.Service;
import org.zaroyan.model.Comment;

import java.util.logging.Logger;
@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());
    public void publishComment(Comment comment) {
        logger.info("Публикация комментария: " + comment.getText());
    }
}
