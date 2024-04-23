package ejercicios_avanzados.clases;

import java.util.Objects;

// Esta clase corresponde al ejercicio 44

public class CuentaBancaria {
	private long numeroDeCuenta;
	private double saldo;
	public long getNumeroDeCuenta() {
		return numeroDeCuenta;
	}
	public void setNumeroDeCuenta(long numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public CuentaBancaria() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Las cuentas son iguales si tienen el mismo númeroDeCuenta
	@Override
	public int hashCode() {
		return Objects.hash(numeroDeCuenta);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		return numeroDeCuenta == other.numeroDeCuenta;
	} 
	
	
	
}
