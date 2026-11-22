
import java.time.Duration;
import java.time.LocalDateTime;

public class CalculadoraTarifa {

    public double calcularTarifa(LocalDateTime entrada, LocalDateTime salida) throws ValorNuloException, HorasIncoherentesException {
        if (entrada == null || salida == null)
            throw new ValorNuloException();
        if (salida.isBefore(entrada))
            throw new HorasIncoherentesException();

        return calcularCoste(Duration.between(entrada, salida).toMinutes(), true);
    }

    private double calcularCoste(long minutos, boolean aplicarGratis) {
        double coste = 0;
        long dias = minutos / 1440; //1440 minutos por día
        long resto = minutos % 1440; //lo que queda. Si el tiempo es inferior a un día dias será 0 y los minutos serán lo mismo que resto

        if (dias <  1) {
            long minutosGratis = 0;
            if (aplicarGratis) //para saber si debemos aplicar el descuento de 30 minutos gratis o no
                minutosGratis = 30;

            if (resto > minutosGratis) {
                coste = (resto - minutosGratis) * 0.05;

                if (coste > 20) {
                    coste = 20;
                }
        } else
            coste = dias * 20 + calcularCoste (resto, false);
            
        return coste;
    }
    
}