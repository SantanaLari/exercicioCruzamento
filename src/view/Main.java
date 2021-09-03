package view;

import java.util.concurrent.Semaphore;

import controller.cruzamentoT;

public class Main {

	public static void main(String[] args) {
		
		int permissoes = 4;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int carro = 0; carro < 4; carro++) {
			Thread carroT = new cruzamentoT(carro, semaforo);
			carroT.start();
		}

	}

}
