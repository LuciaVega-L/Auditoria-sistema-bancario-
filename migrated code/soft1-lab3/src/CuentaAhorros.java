public class CuentaAhorros extends CuentaBancaria {

    private static final double saldoMinimoSinComision = 100.0;
    private static final double comisionMensual = 5.0;
    private static final double tasaInteresMensual = 0.002; // 0.2%

    public CuentaAhorros(String numeroCuenta, String titular, double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);
    }

    @Override
    public void aplicarComisionMensual() {
        if (getSaldo() < saldoMinimoSinComision) {
            setSaldo(getSaldo() - comisionMensual);

        }
        double interes = getSaldo() * tasaInteresMensual;
        setSaldo(getSaldo() + interes);
    }
}