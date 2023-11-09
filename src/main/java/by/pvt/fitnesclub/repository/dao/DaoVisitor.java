package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.Sale;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.entity.VisitUser;
import by.pvt.fitnesclub.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DaoVisitor extends JpaRepository<Visitor,Long> {

}
