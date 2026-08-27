public class RegistroAuditoriaBancaria implements AutoCloseable {

    private final String nombreArchivoLog;
    private boolean cerrado;

    public RegistroAuditoriaBancaria(String nombreArchivoLog) {
        this.nombreArchivoLog = nombreArchivoLog;
        this.cerrado = false;
        System.out.println("[RegistroAuditoriaBancaria] Recurso abierto: " + nombreArchivoLog);
    }

    public void escribirLog(String mensaje) {
        if (cerrado) {
            throw new IllegalStateException("No se puede escribir: el recurso ya fue cerrado");
        }
        System.out.println("[LOG - " + nombreArchivoLog + "] " + mensaje);
    }

    @Override
    public void close() {
        cerrado = true;
        System.out.println("[RegistroAuditoriaBancaria] Recurso cerrado: " + nombreArchivoLog);
    }
}