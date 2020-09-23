package io.sokol.eautomarket.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Customer extends User {

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = new ArrayList<>();

    private void addOrder(Order o) { orders.add(o); }
    private void removeOrder(Order o) { orders.remove(o); }

    private void addAddress(Address a) { addresses.add(a); }
    private void removeAddress(Address a) { addresses.remove(a); }

}
