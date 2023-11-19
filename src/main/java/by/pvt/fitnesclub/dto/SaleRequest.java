package by.pvt.fitnesclub.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SaleRequest {
    @NotNull
    @Positive
    private BigDecimal value;
    @NotBlank(message = "not null!")
    @Size(max = 100)
    private String name;
    @NotNull
    private LocalDate start;
    @NotNull
    private LocalDate stop;

    private String stausUser;
    @AssertTrue
    private boolean isdateCheck(){
        if (stop.isAfter(start)){
            return  true;
        }else {
            return false;
        }
    }
}
