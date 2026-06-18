public class CalculadorViaje {
    private double rendimiento; // km/gal
    private double precioGalon;  // Precio en dinero

    // Constructor
    public CalculadorViaje(double rendimiento, double precioGalon) {
        this.rendimiento = rendimiento;
        this.precioGalon = precioGalon;
    }

    // Circunstancia 1: Cuanto dinero necesito para recorrer X distancia
    public double calcularCostoPorDistancia(double distancia) {
        double galonesNecesarios = distancia / rendimiento;
        return galonesNecesarios * precioGalon;
    }

    // Circunstancia 2: Cuantos kilometros puedo recorrer con X cantidad de dinero
    public double calcularDistanciaPorDinero(double dinero) {
        double galonesComprados = dinero / precioGalon;
        return galonesComprados * rendimiento;
    }

    // Getters por si los necesitamos en la GUI despues
    public double getRendimiento() { return rendimiento; }
    public double getPrecioGalon() { return precioGalon; }
}