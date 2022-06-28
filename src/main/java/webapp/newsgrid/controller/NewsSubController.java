package webapp.newsgrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import webapp.newsgrid.entity.NewsSub;
import webapp.newsgrid.service.NewsSubService;

import java.util.List;

@RestController
@RequestMapping(path = "api/subscribers")
public class NewsSubController {
    public final NewsSubService newsSubService;

    @Autowired
    public NewsSubController(NewsSubService newsSubService) {
        this.newsSubService = newsSubService;
    }
    @GetMapping
    public List<NewsSub> getSubs(){
        return newsSubService.getSubs();
    }


    @PostMapping
    public void addNewSub(@RequestBody NewsSub newsSub){
        newsSubService.addNewSub(newsSub);
    }
}
