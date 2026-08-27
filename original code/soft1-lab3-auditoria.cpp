// SistemaBancarioLegacy.cpp - Código a auditar por los estudiantes
#include <iostream>
#include <fstream>
#include <string>

struct CuentaLegacy {
    char* titular;
    double saldo;
    int tipoCuenta; // 1: Ahorros, 2: Corriente
    double limiteSobregiro;
    // el struct público esta sin encapsulamiento. 
    //todos los campos son accesibles y modificables violando el principio de oecnapsulamiento 
};

CuentaLegacy* crearCuenta(const char* nombre, double saldoInicial, int tipo) {
    CuentaLegacy* c = new CuentaLegacy();
    //'c' se reserva con new y nunca se libera 
    c->titular = new char[50];
     //se reserva memoria dinámica para 'titular' y tampoco se libera nunca con delete
    strcpy(c->titular, nombre);
    // no se valida la longitud de 'nombre' lo que puede generar un overflow 
    c->saldo = saldoInicial;
    c->tipoCuenta = tipo;
    c->limiteSobregiro = (tipo == 2) ? 500.0 : 0.0;
    // el tipo de cuenta se maneja con un entero (1 o 2) en vez de una jerarquía de clases lo que viola
    // el Principio Abierto/Cerrado (OCP)
    return c;
}

void procesarRetiro(CuentaLegacy* c, double monto) {
    if (c->tipoCuenta == 1 && c->saldo >= monto) {
        c->saldo -= monto;
    } else if (c->tipoCuenta == 2 && (c->saldo + c->limiteSobregiro) >= monto) {
        c->saldo -= monto; // Fuga potencial de lógica y sin registro de auditoría
    }
    //No hay ningun tipo de registro, asi que no se puede saber quien retiro->no hay historial
    //la validación de saldo está dentro de un solo método con condicionales,
    //lo que viola el principio single responsability SRP, ya que cada tipo de cuenta deberia validar su saldo
    //en vez de que cada tipo de cuenta encapsule su propia regla
    // NOTA: No hay liberación de memoria de 'titular' ni de 'c' al terminar el programa
}
