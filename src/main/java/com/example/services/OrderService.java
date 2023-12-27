package com.example.services;

import com.example.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;


    public double total(Order order){
        double percente = (order.getBasic() * (order.getDiscount() / 100));
        return (order.getBasic() - percente) + shippingService.shipment(order);
    }
}
