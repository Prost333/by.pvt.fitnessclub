package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.entity.Visitor;

import java.util.List;

public interface DaoVisitor {
    void add(Visitor visitor);
    Visitor findVisitorById(Long id);
    void deleteVisitor(Long id);
    List<Visitor> getAllVisitor();
}
