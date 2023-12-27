package com.example.demo;

import com.example.entities.Order;
import com.example.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.example"})
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

		Integer code = scanner.nextInt();
		Double basic = scanner.nextDouble();
		Double discount = scanner.nextDouble();

		Order order = new Order(code,basic,discount);

        System.out.println("Pedido código " + order.getCode());
		System.out.println("Valor total: " + orderService.total(order));


    }
}
