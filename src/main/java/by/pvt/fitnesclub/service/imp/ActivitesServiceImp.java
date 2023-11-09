package by.pvt.fitnesclub.service.imp;

import by.pvt.fitnesclub.dto.ActivitesRes;
import by.pvt.fitnesclub.dto.UserResponse;
import by.pvt.fitnesclub.entity.*;
import by.pvt.fitnesclub.mapper.ActivitesMapper;
import by.pvt.fitnesclub.repository.dao.ActivitesDao;
import by.pvt.fitnesclub.service.ActivitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActivitesServiceImp implements ActivitesService {
    @Autowired
    private ActivitesDao activitesDao;
    @Autowired
    private ActivitesMapper activitesMapper;

//    @Transactional
    public Activites add (Activites activites){
        return activitesDao.save(activites);

    }
//    @Transactional
    public void delete (Activites activites){
        activitesDao.delete(activites);
    }
//    @Transactional
    public Activites findID (Long id){
        Optional<Activites> sale= Optional.of(activitesDao.findById(id).orElseThrow());
        return  sale.get();
    }

    public List<Activites> getAll(){
        return activitesDao.findAll();
    }

    public List<ActivitesRes> getAllActivRes() {
        List<Activites> users = getAll();
        List<ActivitesRes> userResponses = users.stream().map(activites -> activitesMapper.userToUserResponse(activites)).toList();
        return userResponses;
    }
}
