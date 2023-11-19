package by.pvt.fitnesclub.service.imp;

import by.pvt.fitnesclub.dto.SaleRequest;
import by.pvt.fitnesclub.dto.SaleResponse;
import by.pvt.fitnesclub.entity.Sale;
import by.pvt.fitnesclub.mapper.SaleMapper;
import by.pvt.fitnesclub.repository.dao.SaleRepository;
import by.pvt.fitnesclub.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleServiceImp implements SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleMapper saleMapper;

    public SaleResponse add(SaleRequest saleRequest) {
        Sale sale = saleMapper.toEntity(saleRequest);
        saleRepository.save(sale);
        return saleMapper.toResponse(sale);
    }

    @Override
    public Sale addEntity(Sale sale) {
        return saleRepository.save(sale);
    }

    public void delete(Long id) {
        saleRepository.deleteById(id);
    }

    public SaleResponse findById(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("error"));
        return saleMapper.toResponse(sale);
    }

    @Override
    public Sale findEntityById(Long id) {
        Sale sale = saleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("error"));
        return  sale;
    }


    public List<SaleResponse> findAll() {
        return saleRepository.findAll().stream().map(sale -> saleMapper.toResponse(sale)).collect(Collectors.toList());
    }

}
