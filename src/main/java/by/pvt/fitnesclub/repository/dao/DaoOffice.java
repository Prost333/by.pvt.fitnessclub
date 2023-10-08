package by.pvt.fitnesclub.repository.dao;

import by.pvt.fitnesclub.entity.Office;
import by.pvt.fitnesclub.entity.OfficeWithSubSelect;
import by.pvt.fitnesclub.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface DaoOffice {
    void add(Office office);

    void add1(Office office, Long iventarNumer);

    Office findOfficeById(Long id);

    void deleteOffice(Office office);

    List<Office> getAll();

    void changPrice(Long id, BigDecimal bigDecimal);

    void changeMAXUser(Long id, Long maxUser);

    List<OfficeWithSubSelect> getSmallOffice();

    Long getCountGuest();
    List<Office> findAllByUserAndPrice(Long minUser, Long maxUser);
}
