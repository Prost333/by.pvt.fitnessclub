package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.entity.VisitUser;
import by.pvt.fitnesclub.repository.dao.DaoOffice;
import by.pvt.fitnesclub.repository.dao.VisitDao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class VisitUserService {
    private final VisitDao dao;

    public VisitUserService(VisitDao dao) {
        this.dao = dao;
    }

    public void addVisit(VisitUser visitUser) {
        dao.addVisit(visitUser);
    }
    public void delete(Long id) {
        dao.delete(id);
    }
    public VisitUser findById(Long id) {
        return dao.findById(id);
    }
    public List<VisitUser> getAllVisit() {
        return dao.getAllVisit();
    }
    public List<VisitUser> findByData(LocalDate start, LocalDate end){
        return dao.findByData(start,end);
    }
    public BigDecimal sumByDay(List<VisitUser> visitUserList){
        return dao.sumByDay(visitUserList);
    }
}
