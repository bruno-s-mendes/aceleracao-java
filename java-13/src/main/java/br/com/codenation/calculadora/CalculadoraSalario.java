package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		double inss;
		double irrf;
		double salarioliquido;
		double salarioIntermediario;
		double salarioMinimo = 1039;

		if (salarioBase <= salarioMinimo) { return 0;};

		inss = calcularInss(salarioBase);
		salarioIntermediario = salarioBase - inss;

		if (salarioIntermediario <= 3000){
			salarioliquido = salarioIntermediario;
		} else  {
			irrf = calcularIrrf(salarioIntermediario);
			salarioliquido = salarioIntermediario - irrf;
		}
		return Math.round(salarioliquido);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		if (salarioBase <= 1500) {
			return 0.08 * salarioBase;
		} else if (salarioBase <= 4000){
			return 0.09 * salarioBase;
		} else {
			return 0.11 * salarioBase;
		}
	}

	private double calcularIrrf(double salariIntermediario) {
		if (salariIntermediario <= 3000) {
			return 0;
		} else if (salariIntermediario <= 6000){
			return 0.075 * salariIntermediario;
		} else {
			return 0.15 * salariIntermediario;
		}
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/