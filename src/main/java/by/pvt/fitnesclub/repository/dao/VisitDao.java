package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.VisitUser;

import java.util.List;

public interface VisitDao {
    void addVisit(VisitUser visitUser);

    void delete(Long id);

    VisitUser findById(Long id);

    List<VisitUser> getAllVisit();
}
