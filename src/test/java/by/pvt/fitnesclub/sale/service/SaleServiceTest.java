package by.pvt.fitnesclub.sale.service;

import by.pvt.fitnesclub.dto.SaleRequest;
import by.pvt.fitnesclub.dto.SaleResponse;
import by.pvt.fitnesclub.entity.Sale;
import by.pvt.fitnesclub.mapper.SaleMapper;
import by.pvt.fitnesclub.repository.dao.SaleRepository;
import by.pvt.fitnesclub.service.imp.SaleServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

//@SpringBootTest
@ExtendWith({MockitoExtension.class})
public class SaleServiceTest {
    @Mock
    private SaleRepository saleRepository;

    @InjectMocks
    private SaleServiceImp saleService;
    @Mock
    private SaleMapper saleMapper;
//    @Test
//    public void addSale_when_saleIsNew(){
//        String code = "firstSale";
//        SaleResponse saleResponse=new SaleResponse();
//        when(saleService.add(getSale(code))).thenReturn(saleResponse);
//        SaleResponse expeSale= new SaleResponse();
//        expeSale.setName("sa");
//        assertEquals(expeSale,saleResponse);
//    }
//
//    private  SaleRequest getSale(String code){
//        SaleRequest saleRequest=new SaleRequest();
//        return saleRequest;
//
//    }
    @Test
    public void addSale_when_saleIsNew() {
        // Assuming SaleServiceImp has a method add that takes a Sale object
        String code = "firstSale";
        SaleRequest sale= new SaleRequest();

        // Assuming getSale(code) returns a Sale object
        when(saleService.add((SaleRequest) any())).thenReturn(getRes(code));

        // Call the method under test
        SaleResponse actualSale = saleService.add(getSale(code));

        // Assuming SaleResponse has a setName method
        SaleResponse expectedSale = new SaleResponse();
        expectedSale.setName("firstSale");


        assertEquals(expectedSale, actualSale);
    }

    // Assuming there is a method to create a Sale object based on the code
    private SaleRequest getSale(String code) {
        SaleRequest saleRequest =new SaleRequest();
        return saleRequest;
    }
    private SaleResponse getRes(String code){
        return  new SaleResponse();
    }
}
