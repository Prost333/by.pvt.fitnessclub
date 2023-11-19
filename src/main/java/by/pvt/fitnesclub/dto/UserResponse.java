package by.pvt.fitnesclub.dto;

import lombok.Data;

@Data
public class UserResponse {
    private  Long id;
    private  String name;
    private  String surname;
    private Long age;
    private  String password;
    private  String status;
}
