package by.pvt.fitnesclub.service.imp;

import by.pvt.fitnesclub.entity.Office;
import by.pvt.fitnesclub.repository.dao.DaoOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeServiceImp {
    @Autowired
    private DaoOffice dao;



    public Office add (Office office){
        return  dao.save(office);
    }

    public void delete (Office office){
        dao.delete(office);
    }

    public Office findID (Long id){
        Optional<Office> sale= Optional.of(dao.findById(id).orElseThrow());
        return  sale.get();
    }

    public List<Office> getAll(){
        return dao.findAll();
    }

}
