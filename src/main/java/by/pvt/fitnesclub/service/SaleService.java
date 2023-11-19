package by.pvt.fitnesclub.service;

import by.pvt.fitnesclub.dto.SaleRequest;
import by.pvt.fitnesclub.dto.SaleResponse;
import by.pvt.fitnesclub.entity.Sale;

import java.util.List;

public interface SaleService {
    SaleResponse add(SaleRequest saleRequest);
    Sale addEntity (Sale sale);
    SaleResponse findById(Long id);
    Sale findEntityById(Long id);
    void delete (Long id);
    List<SaleResponse> findAll();
}
