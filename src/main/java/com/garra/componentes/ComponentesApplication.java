package com.garra.componentes;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.garra.componentes.entities.Order;
import com.garra.componentes.services.OrderService;

@SpringBootApplication
public class ComponentesApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ComponentesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com os dados: ");
		System.out.println();
		System.out.println("Codigo: ");
		int code = sc.nextInt();

			System.out.println("Digite o valor: ");
			double basic = sc.nextDouble();

			System.out.println("Digite o descontos $20.00 ou $12.00: ");
			double discount = sc.nextDouble();

	
		Order order = new Order(code, basic, discount);
		
		System.out.println();
		System.out.println("Pedido: " + order.getCode());
		System.out.println("Total: "+ String.format("%.2f", orderService.total(order)));

		sc.close();

	}

}
