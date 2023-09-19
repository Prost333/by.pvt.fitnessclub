package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.entity.Visitor;
import by.pvt.fitnesclub.repository.dao.Dao;
import by.pvt.fitnesclub.repository.dao.DaoVisitor;

import java.util.List;

public class VisitorService {
    private  final DaoVisitor dao;

    public VisitorService(DaoVisitor dao) {
        this.dao = dao;
    }

    public void add(Visitor visitor){
        dao.add(visitor);
    }
    public User findVisitorById(Long id){
        return dao.findVisitorById(id);
    }
    public void deleteVisitor(Long id){
        dao.deleteVisitor(id);
    }
    public List<Visitor> getAllVisitor(){
        return  dao.getAllVisitor();
    }
}
