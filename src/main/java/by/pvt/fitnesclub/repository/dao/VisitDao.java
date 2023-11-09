package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.VisitUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VisitDao extends JpaRepository<VisitUser,Long> {

//    List<VisitUser> findByData(LocalDate start, LocalDate end);
//    BigDecimal sumByDay(List<VisitUser> visitUserList);
}
