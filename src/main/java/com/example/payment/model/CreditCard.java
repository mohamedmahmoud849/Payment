package com.example.payment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credit_card")
public class CreditCard {
    @Id
    private String card_number;
    @Column
    private int balance;

    /*@ManyToOne
    @JsonBackReference
    private Person person;*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CreditCard other = (CreditCard) obj;
        if (card_number == null) {
            if (other.card_number != null)
                return false;
        } else if (!card_number.equals(other.card_number))
            return false;

        return true;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((card_number == null) ? 0 : card_number.hashCode());
        return result;
    }
}
