package by.pvt.fitnesclub.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ActivitesReq {

    private  Long id;
    private String name;
    private  Long cost;
}
