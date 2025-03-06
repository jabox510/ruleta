
package org.example;

import java.sql.SQLOutput;

public class CuentaBancaria {

    private String titular;
    private int saldo;
    private int numeroCuenta;

    public String getTitular() {
        return titular;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaBancaria(String titular, int saldo, int numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public void consignar(int valor) {
        this.saldo += valor;
        System.out.println("SU NUEVO SALDO: " + this.saldo);
    }
    public void retirar(int valor) {
        if (valor > saldo) {
            System.out.println("Fondos insuficientes.");
        } else {
            saldo -= valor;
            System.out.println("SU NUEVO SALDO: " + saldo);
        }
    }
    public void infocuenta(){

        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
        System.out.println("Numero Cuenta: " + numeroCuenta);

    }

}
