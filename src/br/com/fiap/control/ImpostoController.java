package br.com.fiap.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.fiap.imposto.model.Imposto;
import br.com.fiap.imposto.view.TelaDeImposto;

public class ImpostoController implements ActionListener {
	
	private Imposto model;
	private TelaDeImposto view;

	public ImpostoController(Imposto model, TelaDeImposto view) {
		this.model = model;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		model.calcularImposto(view.getValor());
	}

	
}
