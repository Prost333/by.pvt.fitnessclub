package by.pvt.fitnesclub.service.imp;

import by.pvt.fitnesclub.entity.Visitor;
import by.pvt.fitnesclub.repository.dao.DaoVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorServiceImp {
    @Autowired
    private DaoVisitor dao;


//    @Transactional
    public Visitor add (Visitor office){
        return  dao.save(office);
    }
    public void delete (Visitor office){
        dao.delete(office);
    }

    public Visitor findID (Long id){
        Optional<Visitor> sale= Optional.of(dao.findById(id).orElseThrow());
        return  sale.get();
    }

    public List<Visitor> getAll(){
        return dao.findAll();
    }
}
