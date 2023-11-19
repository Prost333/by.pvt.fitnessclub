package by.pvt.fitnesclub.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SaleResponse {
    private BigDecimal value;
    private String name;

    private LocalDate start;

    private LocalDate stop;

    private String stausUser;
}
