package webapp.newsgrid.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @SequenceGenerator(
            name = "categ_seq",
            sequenceName = "categ_seq",
            allocationSize = 1,
            initialValue = 100
    )
    @GeneratedValue(
            generator = "categ_seq",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id_category")
    private Long categoryId;
    @Column(unique = true)
    private String category;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "category"

    )
    private List<Article> articles;


    public Category(String category) {
        this.category = category;
    }
    public Category(){
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id_category=" + categoryId +
                ", category='" + category + '\'' +
                '}';
    }
}
