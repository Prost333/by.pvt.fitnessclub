package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.entity.Office;
import by.pvt.fitnesclub.entity.User;
import by.pvt.fitnesclub.repository.Dao;
import by.pvt.fitnesclub.repository.DaoOffice;

import java.math.BigDecimal;
import java.util.List;

public class OfficeServise {
    private final DaoOffice dao;

    public OfficeServise(DaoOffice dao) {
        this.dao = dao;
    }
    public void add1(Office office, Long iventarNumer){
        dao.add1(office,iventarNumer);
    }

    public void add(Office office){
        dao.add(office);
    }
    public Office findUserById(Long id){
        return dao.findOfficeById(id);
    }
    public void deleteOff(Office office){
        dao.deleteOffice(office);
    }
    public List<Office> getAllUser(){
        return  dao.getAll();
    }

    public void changPrice(Long id, BigDecimal bigDecimal){
        dao.changPrice(id,bigDecimal);
    }
    public void changeMAXUser(Long id, Long maxUser) {
        dao.changeMAXUser(id,maxUser);
    }
    public BigDecimal priceForUser(Long id){
        Office office=dao.findOfficeById(id);
        Double d=office.getCost().doubleValue()/office.getMaxUser();
        return new BigDecimal(d);
    }

}