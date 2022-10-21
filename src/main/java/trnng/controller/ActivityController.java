package trnng.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import trnng.model.entities.Activity;
import trnng.service.ActivityService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ActivityController {
    private ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Activity getActivityById(@PathVariable(name = "id") Integer id){
        System.out.println(activityService.getById(id).toString());
        Activity activity = activityService.getById(id);
        System.out.println(activity);
        return activity;
    }












    @GetMapping
    public List<Activity> getAll(){
        return activityService.getAll();
    }

    @PostMapping
    public ResponseEntity<Activity> create(){
//            @RequestBody Activity activity
        Activity activity = new Activity();
        return ResponseEntity.ok(activityService.create(activity));
    }

}
