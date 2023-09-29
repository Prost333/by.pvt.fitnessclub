package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.Activites;
import by.pvt.fitnesclub.entity.User;

import java.util.List;

public interface ActivitesDao {
    void add(Activites activites);
    Activites findActivitesById(Long id);
    void deleteActivites(Long id);
    List<Activites> getAllActivites();
     Double lowPriceActivites();
}
