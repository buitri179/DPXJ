package org.example.demofx2.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.demofx2.entity.Article;
import org.example.demofx2.repository.ArticleRepository;

public class ArticleForm {
    public TextField txtTitle;
    public TextArea txtDescription;
    public TextArea txtContent;
    private ArticleRepository articleRepository = new ArticleRepository();

    public void processSave(ActionEvent actionEvent) {
        // validate
        Article article = new Article();
        article.setTitle(txtTitle.getText());
        article.setDescription(txtDescription.getText());
        article.setContent(txtContent.getText());
        articleRepository.save(article);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Action success");
        alert.setHeaderText("Article saved!");
        alert.show();
        reset();
    }

    public void processReset(ActionEvent actionEvent) {
        reset();
    }

    private void reset(){
        txtTitle.clear();
        txtDescription.clear();
        txtContent.clear();
    }
}
