package webapp.newsgrid.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapp.newsgrid.entity.Article;
import webapp.newsgrid.service.ArticleService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    public final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/list")
    public List<Article> getArticles(){
        return articleService.getArticles();
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable("id") Long id){
        return articleService.getArticle(id);
    }

    @GetMapping("/{title}")
    public List<Article> getArticleByTitle(@PathVariable("title") String title){
        return articleService.getArticleByTitle(title);
    }

    @PostMapping(path = "/save")
    public void addNewArticle(@RequestBody Article article){
        articleService.addNewArticle(article);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteArticle(@PathVariable("id") Long id){
        articleService.deleteArticle(id);
    }

    @PutMapping(path = "/{articleId}")
    public void updateArticle(@PathVariable("articleId") Long id,
                              @RequestParam(required = false)String title,
                              @RequestParam(required = false)String text,
                              @RequestParam(required = false)String author,
                              @RequestParam(required = false) LocalDate date,
                              @RequestParam(required = false)String imageURL
                              ){
        articleService.updateArticle(id,title,text,author,date,imageURL);
    }
}
