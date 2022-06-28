package webapp.newsgrid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import webapp.newsgrid.entity.Article;
import webapp.newsgrid.entity.Category;
import webapp.newsgrid.repository.ArticleRepository;
import webapp.newsgrid.repository.CategoryRepository;

import java.time.LocalDate;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;


    @Autowired
    public DatabaseLoader(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        //String title, String author, LocalDate date, String image, Category category, String text
        Category c = new Category("Sports");
        Category c1 = new Category("Entertainment");
        Category c2 = new Category("Technology");
        Category c3 = new Category("Shopping");
        this.categoryRepository.save(c);
        this.categoryRepository.save(c1);
        this.categoryRepository.save(c2);
        this.categoryRepository.save(c3);

        Article a1 = new Article("O noua echipa de fotbal",
                "Costin Dogaru",
                LocalDate.now(),
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6dTOoGV2mYCjZwyJ4DQUqGF6wmNwe8AjhAA1vLB4&&s=0",
                c,
                "O noua echipa de fotbal isi face simtita prezenta ...");

        Article a2 = new Article("Olimpicii la matematica",
                "Costin Dogaru",
                LocalDate.now(),
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6dTOoGV2mYCjZwyJ4DQUqGF6wmNwe8AjhAA1vLB4&&s=0",
                c2,
                "La Olimpiada de Matematica...");

        Article a3 = new Article("Tehnologia romaneasca",
                "Costin Dogaru",
                LocalDate.now(),
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6dTOoGV2mYCjZwyJ4DQUqGF6wmNwe8AjhAA1vLB4&&s=0",
                c2,
                "In ultimii ani, Romania face parte din...");

        Article a4 = new Article("Juriul si concurentii, castigatori Romanii au talent",
                "Costin Dogaru",
                LocalDate.now(),
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6dTOoGV2mYCjZwyJ4DQUqGF6wmNwe8AjhAA1vLB4&&s=0",
                c1,
                "Românii au talent este o emisiune difuzata de PRO TV ...");

        Article a5 = new Article("Samsung anunta aparitia unui nou telefon!",
                "Costin Dogaru",
                LocalDate.now(),
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT6dTOoGV2mYCjZwyJ4DQUqGF6wmNwe8AjhAA1vLB4&&s=0",
                c3,
                "De-a lungul anilor, Samsung...");
        this.articleRepository.save(a1);
        this.articleRepository.save(a2);
        this.articleRepository.save(a3);
        this.articleRepository.save(a4);
        this.articleRepository.save(a5);


    }
}