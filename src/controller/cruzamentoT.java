package controller;

import java.util.Random;

import java.util.concurrent.Semaphore;

public class cruzamentoT extends Thread{

	private int carro;
	private Semaphore semaforo;
	
	public cruzamentoT(int carro, Semaphore semaforo) {
		this.carro = carro;
		this.semaforo = semaforo;
	}
	
	public void run() {
		direçãoCarro();
		
		try {
			semaforo.acquire();
			carroEspera();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforo.release();
			carroAnda();
		}
		
	}
	
	public void direçãoCarro() {
		switch(carro) {
		case 0:
			String carroVermelho = "sul";
			System.out.println("#" + carro + " está indo na direção " + carroVermelho);
			break;
		case 1:
			String carroAzul = "oeste";
			System.out.println("#" + carro + " está indo na direção " + carroAzul);
			break;
		case 2:
			String carroAmarelo = "norte";
			System.out.println("#" + carro + " está indo na direção " + carroAmarelo);
			break;
		case 3:
			String carroVerde = "leste";
			System.out.println("#" + carro + " está indo na direção " + carroVerde);
			break;
		}
	}
	
	public void carroAnda() {
		System.out.println("#" + carro + " está andando");
	}
	
	public void carroEspera() {
		System.out.println("#" + carro + " parou.");
	}
	
}
