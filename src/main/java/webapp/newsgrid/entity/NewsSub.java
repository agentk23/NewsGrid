package webapp.newsgrid.entity;

import javax.persistence.*;

@Entity
@Table(name = "subscriber",
        uniqueConstraints = @UniqueConstraint(
        name = "UK_subscriber_email",
        columnNames = "email"
))
public class NewsSub {
    @Id
    @SequenceGenerator(
            name = "subscriber_seq",
            sequenceName = "subscriber_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "subscriber_seq",
            strategy = GenerationType.SEQUENCE
    )
    @Column(name = "id_subscriber")
    private Long id;
    @Column(name = "email")
    private String email;

    public NewsSub(){}

    public NewsSub(String email){
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "id_subscriber=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
