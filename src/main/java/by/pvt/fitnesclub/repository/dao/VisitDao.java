package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.VisitUser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface VisitDao {
    void addVisit(VisitUser visitUser);

    void delete(Long id);

    VisitUser findById(Long id);

    List<VisitUser> getAllVisit();
    List<VisitUser> findByData(LocalDate start, LocalDate end);
    BigDecimal sumByDay(List<VisitUser> visitUserList);
}
