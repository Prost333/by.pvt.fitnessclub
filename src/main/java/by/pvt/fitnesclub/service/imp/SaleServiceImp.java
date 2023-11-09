package by.pvt.fitnesclub.service.imp;

import by.pvt.fitnesclub.entity.Sale;
import by.pvt.fitnesclub.repository.dao.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImp {
    @Autowired
    private SaleRepository saleRepository;

    public Sale add(Sale sale){
        return saleRepository.save(sale);
    }

    public void delete (Sale sale){
        saleRepository.delete(sale);
    }

    public Sale findID (Long id){
        Optional<Sale> sale= Optional.of(saleRepository.findById(id).orElseThrow());
        return  sale.get();
    }

    public List<Sale> getAll(){
        return saleRepository.findAll();
    }

}
