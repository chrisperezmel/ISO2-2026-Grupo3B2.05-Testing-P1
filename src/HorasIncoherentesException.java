public class HorasIncoherentesException extends Exception {

    public HorasIncoherentesException() {
        super("La fecha y hora de salida no puede ser anterior a la fecha y hora de entrada");
    }
    
}
