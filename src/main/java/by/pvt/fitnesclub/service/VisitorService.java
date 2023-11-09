package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.entity.VisitUser;
import by.pvt.fitnesclub.entity.Visitor;

import java.util.List;

public interface VisitorService {
    void add(Visitor visit);
    void delete(Visitor visit);
    Visitor findById(Long id);
    List<Visitor> getAllVisit();
}
