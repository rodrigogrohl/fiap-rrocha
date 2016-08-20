package br.com.fiap.ejbws;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Session Bean implementation class Conversor
 */
@Stateless
@WebService(serviceName = "Conversor", portName = "ConversorPort", endpointInterface = "br.com.fiap.ejbws.ConversorRemote", targetNamespace = "http://jaxws.exemplos.fiap.com.br")
public class Conversor implements ConversorRemote {

	private double valorDolar = 2.25;

	@Override
	public double DolarParaReal(double dolar) {
		return dolar * valorDolar;
	}

	@Override
	public double RealParaDolar(double real) {
		return real / valorDolar;
	}

}
