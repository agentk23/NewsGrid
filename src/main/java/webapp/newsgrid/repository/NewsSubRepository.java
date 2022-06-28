package webapp.newsgrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import webapp.newsgrid.entity.NewsSub;

@Repository
public interface NewsSubRepository extends JpaRepository<NewsSub, Long> {

}
