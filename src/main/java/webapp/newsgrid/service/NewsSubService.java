package webapp.newsgrid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.newsgrid.entity.NewsSub;
import webapp.newsgrid.repository.NewsSubRepository;

import java.util.List;
@Service
public class NewsSubService {
    public final NewsSubRepository newsSubRepository;

    @Autowired
    public NewsSubService(NewsSubRepository newsSubRepository) {
        this.newsSubRepository = newsSubRepository;
    }

    public List<NewsSub> getSubs() {
        return newsSubRepository.findAll();
    }
    public void addNewSub(NewsSub newz) {
        newsSubRepository.save(newz);
    }
}
