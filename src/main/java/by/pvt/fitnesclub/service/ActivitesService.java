package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.entity.Activites;

import java.util.List;

public interface ActivitesService {
    Activites add (Activites activites);
    void delete (Activites activites);
    Activites findID (Long id);
    List<Activites> getAll();
}
