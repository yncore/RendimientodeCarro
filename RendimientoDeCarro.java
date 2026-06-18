import java.util.Scanner;

public class RendimientoDeCarro {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   Configuracion Inicial del Vehiculo   ");
        System.out.println("========================================");

        System.out.print("Introduce los kilometros recorridos en tu ultimo viaje: ");
        double km = teclado.nextDouble();

        System.out.print("Introduce los galones consumidos en ese viaje: ");
        double galones = teclado.nextDouble();

        System.out.print("Introduce el precio actual del galon de gasolina: $");
        double precio = teclado.nextDouble();

        if (galones <= 0 || precio <= 0) {
            System.out.println("Error: Datos invalidos. Los galones y el precio deben ser mayores a cero.");
            teclado.close();
            return;
        }

        // 1. Calcular rendimiento base
        double rendimientoBase = km / galones;
        System.out.printf("%nRendimiento calculado: %.2f km/gal%n", rendimientoBase);

        // 2. Instanciar el cerebro matematico
        CalculadorViaje simulador = new CalculadorViaje(rendimientoBase, precio);

        // 3. Menu interactivo de circunstancias
        int opcion = 0;
        do {
            System.out.println("\n========================================");
            System.out.println(" ¿Qué necesitas saber? ");
            System.out.println("========================================");
            System.out.println("1. Presupuesto: Cuanto avanzo con la cantidad de dinero que tengo");
            System.out.println("2. Planificacion: Cuanto dinero cuesta viajar la distancia que quiero");
            System.out.println("3. Salir del programa");
            System.out.print("Elige una opcion (1-3): ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("\nIntroduce la cantidad de dinero disponible: $");
                    double dinero = teclado.nextDouble();
                    double kmPosibles = simulador.calcularDistanciaPorDinero(dinero);
                    System.out.printf("Con $%.2f puedes recorrer aproximadamente: %.2f km%n", dinero, kmPosibles);
                    break;

                case 2:
                    System.out.print("\nIntroduce la distancia que planeas recorrer (km): ");
                    double distancia = teclado.nextDouble();
                    double costoTotal = simulador.calcularCostoPorDistancia(distancia);
                    System.out.printf("Para recorrer %.2f km necesitaras invertir: $%.2f%n", distancia, costoTotal);
                    break;

                case 3:
                    System.out.println("\nSimulacion terminada. Buen viaje.");
                    break;
            
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 3);

        teclado.close();
    }
}