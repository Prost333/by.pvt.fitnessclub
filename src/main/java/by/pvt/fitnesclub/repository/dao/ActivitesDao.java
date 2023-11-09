package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.Activites;
import by.pvt.fitnesclub.entity.Sale;
import by.pvt.fitnesclub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivitesDao extends JpaRepository<Activites,Long> {
//    Long lowPriceActivites();
}
