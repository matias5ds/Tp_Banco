package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentaBancaria {

	//test  Sueldo
		@Test
		public void testDepostioCuentaSueldo() {
			CuentaSueldo miCuentaSueldo=new CuentaSueldo(1000.0);
			miCuentaSueldo.depositar(400.0);
			assertEquals(1400.0, miCuentaSueldo.getSaldo(),0.01);
		}
		@Test
		public void testExtraccionCuentaSueldoConSaldoSuperior() {
			CuentaSueldo miCuentaSueldo=new CuentaSueldo(1000.0);
			miCuentaSueldo.extraer(400.0);
			assertEquals(600.0, miCuentaSueldo.getSaldo(),0.01);
		}
		
		@Test
		public void testExtraccionCuentaSueldoConSaldoInsuficiente() {
			CuentaSueldo miCuentaSueldo=new CuentaSueldo(1000.0);
			miCuentaSueldo.extraer(1400.0);
			assertEquals(1000.0, miCuentaSueldo.getSaldo(),0.01); //1er sysout de error
		}
		
		//test Caja de Ahorro
		@Test
		public void testDepositoCajaAhorro(){
			CajaDeAhorro miCajaDeAhorro=new CajaDeAhorro(1000.0);
			miCajaDeAhorro.depositar(400.0);
			assertEquals(1400.0, miCajaDeAhorro.getSaldo(),0.01);
		}
		@Test
		public void testExtraccionCajaAhorroSinComision(){
			CajaDeAhorro miCajaDeAhorro=new CajaDeAhorro(1000.0);
			miCajaDeAhorro.extraer(400.0);
			assertEquals(600.0, miCajaDeAhorro.getSaldo(),0.01);
		}
		@Test
		public void testExtraccionCajaAhorroConComision(){
			CajaDeAhorro miCajaDeAhorro=new CajaDeAhorro(1000.0);
			miCajaDeAhorro.extraer(100.0); //primera extraccion
			miCajaDeAhorro.extraer(100.0); //segunda extraccion
			miCajaDeAhorro.extraer(100.0); //tercera extraccion
			miCajaDeAhorro.extraer(100.0);
			miCajaDeAhorro.extraer(100.0);
			miCajaDeAhorro.extraer(100.0); //sexta extraccion con comision
			assertEquals(6,miCajaDeAhorro.getContadorExtraccion(),0.01);
			assertEquals(394.0, miCajaDeAhorro.getSaldo(),0.01);
		}
		@Test
		public void testExtraccionCajaAhorroSinSaldoSuperior(){
			CajaDeAhorro miCajaDeAhorro=new CajaDeAhorro(500.0);
			miCajaDeAhorro.extraer(100.0); //primera extraccion
			miCajaDeAhorro.extraer(100.0); //segunda extraccion
			miCajaDeAhorro.extraer(100.0); //tercera extraccion
			miCajaDeAhorro.extraer(100.0);
			miCajaDeAhorro.extraer(100.0);
			miCajaDeAhorro.extraer(100.0);//sexta extraccion con comision pero sin saldo
			assertEquals(0.0, miCajaDeAhorro.getSaldo(),0.01); //2do sysout de error
		}
		//test Cuenta Corriente
		@Test
		public void testDepositoCuentaCorriente(){
			CuentaCorriente miCuentaCorriente = new CuentaCorriente(100.0, 150.0);
			miCuentaCorriente.depositar(200.0);
			assertEquals(300.0, miCuentaCorriente.getSaldo(), 0.01);
		}
		
		@Test
		public void testExtraccionCuentaCorriente(){
			CuentaCorriente miCuentaCorriente = new CuentaCorriente(100.0, 150.0);
			miCuentaCorriente.extraer(200.0);
			assertEquals(-105.0, miCuentaCorriente.getSaldo(), 0.01);
		}
		@Test
		public void testExtraccionCuentaCorrienteSuperandoGiroDescubierto(){
			CuentaCorriente miCuentaCorriente = new CuentaCorriente(100.0, 150.0);
			miCuentaCorriente.extraer(300.0);
			assertEquals(100.0, miCuentaCorriente.getSaldo(), 0.01); //3er sysout de error
		}


}
