package trnng.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trnng.model.entities.Activity;
import trnng.model.repository.ActivityRepository;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ActivityService {
    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity getById(Integer id){
        return activityRepository.findById(id).get();
    }

    public Activity create(Activity activity){
        return activityRepository.save(activity);
    }
    public List<Activity> getAll(){
        return activityRepository.findAll();
    }
}
