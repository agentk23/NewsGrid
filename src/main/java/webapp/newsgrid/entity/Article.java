package webapp.newsgrid.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(
        name = "article"
)
public class Article implements Serializable {
    @Id
    @SequenceGenerator(
            name = "article_seq",
            sequenceName = "article_seq",
            allocationSize = 1,
            initialValue = 10
    )
    @GeneratedValue(
            generator = "article_seq",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id_article")
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "author", nullable = false)
    private String author;
    @Column(name = "publication_date", nullable = false )
    private LocalDate date;
    @Column(name = "imageURL")
    private String image;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(
            name = "category",
            referencedColumnName = "id_category")
    private Category category;
    @Transient
    private int views;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Article() {
    }

    public Article(String title, String author, LocalDate date, String image, Category category, String text) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.image = image;
        this.text = text;
        this.category = category;
        this.views = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", views=" + views +
                '}';
    }
}
