package webapp.newsgrid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webapp.newsgrid.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
