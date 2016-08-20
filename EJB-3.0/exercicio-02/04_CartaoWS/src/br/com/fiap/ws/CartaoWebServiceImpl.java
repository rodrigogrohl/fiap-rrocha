package br.com.fiap.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "cartaoendpoint")
public class CartaoWebServiceImpl implements CartaoWebService {

	@Override
	@WebMethod
	public String validarCartao(String numCartao, double valor) {
		if (numCartao.length() != 16) {
			return "Cart�o inv�lido";
		} else {
			return "D�bito de " + valor + " efetuado com sucesso";
		}
	}

}
