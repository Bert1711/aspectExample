package org.zaroyan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zaroyan.configuration.ProjectConfig;
import org.zaroyan.model.Comment;
import org.zaroyan.services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var service = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setText("Мне нравится!");
        comment.setAuthor("А.С. Пушкин");
         service.publishComment(comment);
    }
}