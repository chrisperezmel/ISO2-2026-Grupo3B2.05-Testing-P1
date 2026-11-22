import java.time.LocalDateTime;

public class Principal {
    public static void main(String[] args) {
        IUConsola consola = new IUConsola();
        CalculadoraTarifa calculadora = new CalculadoraTarifa();

        try {
            LocalDateTime entrada = consola.leerFechaHora("Entrada");
            LocalDateTime salida = consola.leerFechaHora("Salida");
            consola.mostrarCoste(calculadora.calcularTarifa(entrada, salida));
        } catch (FormatoFechaException | ValorNuloException | HorasIncoherentesException e) {
            consola.mostrarError(e.getMessage());
        }
    }
}
