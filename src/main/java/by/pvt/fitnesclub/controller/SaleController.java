package by.pvt.fitnesclub.controller;

import by.pvt.fitnesclub.dto.SaleRequest;
import by.pvt.fitnesclub.dto.SaleResponse;
import by.pvt.fitnesclub.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sale")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping("/add")
    public SaleResponse add(@RequestBody @Validated SaleRequest saleRequest) {
        return saleService.add(saleRequest);
    }
    @DeleteMapping
    public void delete (Long id){
        saleService.delete(id);
    }
    @GetMapping("/findById")
    public SaleResponse findById(Long id){

        return saleService.findById(id);
    }
    @GetMapping("/findAll")
    public List<SaleResponse> findAll(){
        return saleService.findAll();
    }


}
