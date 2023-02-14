package br.com.fiap.imposto.view;

import br.com.fiap.control.ImpostoController;
import br.com.fiap.imposto.model.Pis;

public class TestaCalculo {

	public static void main(String[] args) {

		Pis modelPis = new Pis();
		CalculaPis viewCalculaPis = new CalculaPis();
		ImpostoController controller = new ImpostoController(modelPis, viewCalculaPis);
		viewCalculaPis.addController(controller);
	}

}
