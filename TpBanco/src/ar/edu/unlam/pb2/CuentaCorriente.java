package ar.edu.unlam.pb2;

public class CuentaCorriente extends Cuenta {
	
	private Double giroEnDescubierto;
	private Double comision=0.05;
	
	public CuentaCorriente(Double saldoInicial, Double giroEnDescubierto){
		super(saldoInicial);
		this.giroEnDescubierto=giroEnDescubierto;
	}
	
	public void extraer(Double montoExtraccion){
		Double extraccionDisponible=getSaldo()+giroEnDescubierto;
		Double usoGiroDescubierto=montoExtraccion-getSaldo();
		Double montoComision=usoGiroDescubierto*comision;
		if(montoExtraccion<=extraccionDisponible){
			setSaldo(getSaldo()-montoExtraccion-montoComision);
		}
		else{
			System.out.println("Supera el monto de giro en descubierto");
		}
			
	}
}
