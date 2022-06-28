package webapp.newsgrid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.newsgrid.entity.Article;
import webapp.newsgrid.repository.ArticleRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArrayList<Article> getArticles() {
        return (ArrayList<Article>) articleRepository.findAll();
    }
    public List<Article> getArticleByTitle(String title) {
        ArrayList<Article> list = (ArrayList<Article>) articleRepository.findAll();
        ArrayList<Article> titleArticles = new ArrayList<>();
        if(!title.isEmpty()){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getTitle().equals(title) ||
                        list.get(i).getTitle().toLowerCase().contains(title.toLowerCase())
                ){
                    titleArticles.add(list.get(i));
                }
            }
        }
        return titleArticles;
    }
    public Article getArticle(Long id){
        ArrayList<Article> list = (ArrayList<Article>) articleRepository.findAll();
        int ok = 0;
        for(int i = 0; i < list.size(); i++){
            if(id.equals(list.get(i).getId())){
                ok = 1;
            }
        }
        if(ok == 1){
            return articleRepository.findById(id).get();
        }else{
            System.err.println("Article with id:"+ id + " does not exist");
            return null;
        }
    }
    public void addNewArticle(Article article) {
        try {
            articleRepository.save(article);
        }catch(Exception e){
            System.out.println("Invalid article!");
        }
    }

    public void deleteArticle(Long id) {
        if(articleRepository.existsById(id)){
            articleRepository.deleteById(id);
        }else{
            throw new IllegalStateException("Article with id: " + id + " does not exist!");
        }
    }
    @Transactional
    public void updateArticle(Long id, String title, String text, String author, LocalDate date, String imageURL) {
        if(articleRepository.existsById(id)){
            Article article = articleRepository.getReferenceById(id);
            if(title != null){
                article.setTitle(title);
            }
            if(text != null){
                article.setText(text);
            }
            if(author != null){
                article.setAuthor(author);
            }
            if(date != null){
                article.setDate(date);
            }
            if(imageURL != null){
                article.setImage(imageURL);
            }
        }else{
            throw new IllegalStateException("Article with id: " + id + " does not exist!");

        }
    }


}
