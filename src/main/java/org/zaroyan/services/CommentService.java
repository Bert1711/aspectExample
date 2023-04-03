package org.zaroyan.services;

import org.springframework.stereotype.Service;
import org.zaroyan.annotation.ToLog;
import org.zaroyan.model.Comment;

import java.util.logging.Logger;

@Service
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());


    @ToLog
    public String publishComment(Comment comment) {
        logger.info("Publishing comment:" + comment.getText());
        return "SUCCESS";
    }

    public void deleteComment(Comment comment) {
        logger.info("Удаление комментария: " + comment.getText());
    }

    public void editComment(Comment comment) {
        logger.info("Редактирование комментария: " + comment.getText());
    }
}
