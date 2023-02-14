package br.com.fiap.imposto.view;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Panel;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Button;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
 


@SuppressWarnings("deprecation")
public class CalculaPis implements Observer, TelaDeImposto {
	
	private TextField txtValorFaturado;
	private Button btnCalcular;
	
	public CalculaPis() {
		
		System.out.println("Construtor da view Chamado");
		
		Frame frame = new Frame("Cálculo do pis e Desing Patterns");
		
		frame.add("North", new Label("Valor Faturado"));
		
		txtValorFaturado = new TextField();
		frame.add("Center", txtValorFaturado);
		
		Panel panel = new Panel();
		btnCalcular = new Button("Calcular");
		panel.add(btnCalcular);
		
		frame.add("South", panel);
		
		frame.addWindowListener(new CloseListener());
		frame.setSize(200, 150);
		frame.setLocation(100, 100);
		frame.setVisible(true);
	
	}
	
	public float getValor() {
		return Float.parseFloat(txtValorFaturado.getText());
	}
	
	public void addController(ActionListener controller) {
		System.out.println("A Action acionou o controller");
		btnCalcular.addActionListener(controller);		
		
	}
	
	public void update(Observable objModel, Object estadoModel) {
		System.out.println("Atualizou o estado");
		String msg = objModel.getClass() + "" + objModel.toString() +"\n" + ((Float)estadoModel).floatValue();
		JOptionPane.showMessageDialog(null, msg);
		
	}
	
	public static class CloseListener extends WindowAdapter{
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
	
	
	
	
	
	
	
}