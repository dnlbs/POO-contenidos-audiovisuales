package poo.util;

/**
 * Interfaz para serialización/deserialización a CSV
 */
public interface ExportableACSV {
    /**
     * Serializa el objeto a formato CSV
     */
    String toCSV();
    
    /**
     * Deserializa el objeto desde CSV
     */
    void fromCSV(String lineaCSV);
    
    /**
     * Método default para escapar caracteres especiales en CSV
     */
    default String escapeCSV(String campo) {
        if (campo == null) return "";
        return campo.replace("\\", "\\\\")
                  .replace(",", "\\,")
                  .replace("\n", "\\n")
                  .replace("\r", "\\r");
    }
    
    /**
     * Método default para desescapar valores CSV
     */
    default String unescapeCSV(String campo) {
        if (campo == null) return "";
        return campo.replace("\\,", ",")
                  .replace("\\n", "\n")
                  .replace("\\r", "\r")
                  .replace("\\\\", "\\");
    }
}