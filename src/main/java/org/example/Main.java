package org.example;

import org.w3c.dom.ls.LSOutput;
import java.util.Scanner;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion =0;
        CuentaBancaria cuenta1 = new CuentaBancaria("javier", 0, 1234);
        CuentaBancaria cuenta2 = new CuentaBancaria("daniel", 0, 12345);
        CuentaBancaria cuenta3 = new CuentaBancaria("fabio", 0, 123456);

        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(cuenta1);
        cuentas.add(cuenta2);
        cuentas.add(cuenta3);


        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("--- CUENTAS  ---");
            for (CuentaBancaria cuenta : cuentas) {
                System.out.println("NUMERO DE CUENTA: " + cuenta.getNumeroCuenta() + " - TITULAR: " + cuenta.getTitular());
            }

            System.out.println("\nSELECCIONE LA TRANSACCION QUE QUIERE REALIZAR:");
            System.out.println("1. CONSIGNAR");
            System.out.println("2. RETIRAR");
            System.out.println("3. CONSULTAR INFO DE LA CUENTA");
            System.out.println("4. CREAR CUENTA");
            System.out.println("5. SALIR");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            if (opcion == 1 || opcion == 2 || opcion == 3) {
                System.out.print("INGRESE EL NUMERO DE LA CUENTA: ");
                int numerocta = scanner.nextInt();
                CuentaBancaria ctaseleccionada = null;

                for (CuentaBancaria cuenta : cuentas) {
                    if (cuenta.getNumeroCuenta() == numerocta) {
                        ctaseleccionada = cuenta;
                        break;
                    }
                }
                if (ctaseleccionada == null) {
                    System.out.println("CUENTA NO VALIDA");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        System.out.print("INGRESE VALOR A CONSIGNAR: ");
                        int valoraconsignar = scanner.nextInt();
                        ctaseleccionada.consignar(valoraconsignar);
                        break;
                    case 2:
                        System.out.print("INGRESE VALOR A RETIRAR: ");
                        int valoraretirar = scanner.nextInt();
                        ctaseleccionada.retirar(valoraretirar);
                        break;
                    case 3:
                        ctaseleccionada.infocuenta();
                        break;
                }
            } else if (opcion == 4) {
                System.out.print("INGRESE NOMBRE DEL TITULAR: ");
                scanner.nextLine();
                String nuevoTitular = scanner.nextLine();

                System.out.print("INGRESE NUMERO DE CUENTA: ");
                int nuevoNumero = scanner.nextInt();

                System.out.print("INGRESE SALDO INICIAL: ");
                int nuevoSaldo = scanner.nextInt();

                CuentaBancaria nuevacuenta = new CuentaBancaria(nuevoTitular, nuevoSaldo, nuevoNumero);
                cuentas.add(nuevacuenta);
                System.out.println("CUENTA CREADA EXITOSAMENTE");
            } else if (opcion == 5) {
                System.out.println("SALIENDO DEL PROGRAMA...");
            } else {
                System.out.println("OPCION NO VALIDA");
            }

        } while (opcion != 5);
    }
}