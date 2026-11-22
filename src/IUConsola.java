import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class IUConsola {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private final Scanner TECLADO = new Scanner(System.in);

    public LocalDateTime leerFechaHora(String mensaje) throws FormatoFechaException {
        System.out.println(mensaje + " (dd/MM/yyyy HH:mm)");
        String texto = TECLADO.nextLine();

        try {
            return LocalDateTime.parse(texto.trim(), FORMATO);
        } catch (DateTimeParseException e) {
            throw new FormatoFechaException();
        }
    }

    public void mostrarCoste(double coste) {
        System.out.printf("\nCoste total: %.2f €%n\n", coste);
    }

    public void mostrarError(String mensaje) {
        System.out.println("Error: " + mensaje);
    }
}
