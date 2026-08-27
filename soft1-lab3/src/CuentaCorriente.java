public class CuentaCorriente extends CuentaBancaria {

    private final double limiteSobregiro;
    private static final double comisionMensual = 15.0;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial) {
        this(numeroCuenta, titular, saldoInicial, 500.0);
    }

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        if (limiteSobregiro < 0) {
            throw new IllegalArgumentException("El límite de sobregiro no puede ser negativo");
        }
        this.limiteSobregiro = limiteSobregiro;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }
    @Override
    public void aplicarComisionMensual() {
        setSaldo(getSaldo() - comisionMensual);
    }
}