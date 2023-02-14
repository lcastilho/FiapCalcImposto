package br.com.fiap.imposto.model;

import java.util.Observable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import br.com.fiap.imposto.util.AliquotaSingleton;

@SuppressWarnings("deprecation")
public class Pis extends Observable implements Imposto {

	private static final Logger logger = (Logger) LogManager.getLogger(Pis.class);

	private final float ALIQUOTA = Float.parseFloat(AliquotaSingleton
			.getInstance()
			.getProperty("aliquotaPis"));
	
	private float valorDoPis = 0;

	
	public Pis() {
		// TODO Auto-generated constructor stub
	}
	
	public float getValorDoPis() {
		return valorDoPis;
	}

	public void setValorDoPis(float valorDoPis) {
		this.valorDoPis = valorDoPis;
	}

	public float getALIQUOTA() {
		return ALIQUOTA;
	}

	@Override
	public void calcularImposto(float valor) {
		this.valorDoPis = (this.ALIQUOTA * valor);
		logger.info("Calculando imposto :" + valorDoPis);
		setChanged();
		notifyObservers(valorDoPis);
		
		System.out.println(toString());
	}
	
	@Override
	public String toString() {
		return "Pis [ALIQUOTA = " + ALIQUOTA + ", valor do pis = " + valorDoPis + "]";
	}

}
