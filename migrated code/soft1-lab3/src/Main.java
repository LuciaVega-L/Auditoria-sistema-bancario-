import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(new CuentaAhorros("AH-001", "Ana Torres", 200.0));
        cuentas.add(new CuentaCorriente("CC-001", "Luis Pérez", 100.0));

        System.out.println("Estado inicial");
        cuentas.forEach(System.out::println);

        System.out.println("\nComisiones mensuales");
        for (CuentaBancaria c : cuentas) {
            c.aplicarComisionMensual();
        }
        System.out.println("\nEstado final");
        cuentas.forEach(System.out::println);

        System.out.println("\nPrueba de RegistroAuditoriaBancaria");
        try (RegistroAuditoriaBancaria registro = new RegistroAuditoriaBancaria("auditoria_bancaria.log")) {
            registro.escribirLog("Comisión mensual aplicada en cuenta AH-001");
            registro.escribirLog("Comisión mensual aplicada en cuenta CC-001");
        }
    }
}