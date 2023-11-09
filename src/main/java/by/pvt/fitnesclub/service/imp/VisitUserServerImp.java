package by.pvt.fitnesclub.service.imp;

import by.pvt.fitnesclub.entity.VisitUser;
import by.pvt.fitnesclub.repository.dao.VisitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VisitUserServerImp {
    @Autowired
    private VisitDao visitDao;

    @Transactional
    public void addVisit(VisitUser visitUser) {
        visitDao.save(visitUser);
    }

    @Transactional
    public void delete(VisitUser visitUser) {
        visitDao.delete(visitUser);
    }

    @Transactional
    public List<VisitUser> findById(Long id) {
        Optional<VisitUser> sale = Optional.of(visitDao.findById(id).orElseThrow());
        return (List<VisitUser>) sale.get();
    }

    @Transactional
    public List<VisitUser> getAllVisit() {
        return visitDao.findAll();
    }
}
