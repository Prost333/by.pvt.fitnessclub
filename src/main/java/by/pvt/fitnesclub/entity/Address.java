package by.pvt.fitnesclub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "fitness", name = "Address")
public class Address {
    private  String city;
    private  String streat ;
    private  String numderHouse;
    private  String index;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreat() {
        return streat;
    }

    public void setStreat(String streat) {
        this.streat = streat;
    }

    public String getNumderHouse() {
        return numderHouse;
    }

    public void setNumderHouse(String numderHouse) {
        this.numderHouse = numderHouse;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
