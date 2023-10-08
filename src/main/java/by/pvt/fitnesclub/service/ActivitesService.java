package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.entity.Activites;
import by.pvt.fitnesclub.entity.Employee;
import by.pvt.fitnesclub.repository.dao.ActivitesDao;
import by.pvt.fitnesclub.repository.dao.Dao;
import by.pvt.fitnesclub.repository.dao.DaoEmployee;

import java.util.List;

public class ActivitesService {
    private static ActivitesDao dao;

    public ActivitesService(ActivitesDao dao) {
        this.dao = dao;
    }

    public void add(Activites activites){
        dao.add(activites);
    }

    public Activites findActivitesById(Long id){
        return dao.findActivitesById(id);
    }

    public void deleteActivites(Long id){
        dao.deleteActivites(id);
    }

    public List<Activites> getAllActivites(){
        return dao.getAllActivites();
    }
    public Long lowPriceActivites(){
        return dao.lowPriceActivites();
    }
}
