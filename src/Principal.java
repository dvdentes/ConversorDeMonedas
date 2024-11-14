import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda(); //Busqueda consulta = new Busqueda();

        int opcion = 0;
        Double valorAConvertir;

        System.out.println("*****************************************");
        System.out.println("Bienevenido al conversor de monedas:");
        String menu = """
                1.Dolar => Peso argentino
                2.Peso argentino => Dolar
                3.Dolar => Real brasileño
                4.Real brasileño => Dolar
                5.Dolar => Boliviano
                6.Boliviano => Dolar
                7.Dolar => Peso chileno
                8.Peso chileno => Dolar
                9.Dolar => Peso colombiano
                10.Peso colombiano => Dolar
                11.Salir""";


        while (opcion != 11) {
            System.out.println("\n");
            System.out.println(menu);
            System.out.println("\nSeleciona una opcion valida. ");
            opcion = lectura.nextInt();


            String base_code = null;
            String target_code = null;


            switch (opcion) {
                case 1:
                    base_code = "USD";
                    target_code = "ARS";
                    System.out.println("dolar a peso argentino");
                    break;
                case 2:
                    base_code = "ARS";
                    target_code = "USD";
                    System.out.println("peso argentino a dolar");
                    break;
                case 3:
                    base_code = "USD";
                    target_code = "BRL";
                    System.out.println("dolar a peso real brasileño");
                    break;
                case 4:
                    base_code = "BRL";
                    target_code = "USD";
                    break;
                case 5:
                    base_code = "USD";
                    target_code = "BOB";
                    break;
                case 6:
                    base_code = "BOB";
                    target_code = "USD";
                    break;
                case 7:
                    base_code = "USD";
                    target_code = "CLP";
                    break;
                case 8:
                    base_code = "CLP";
                    target_code = "USD";
                    break;
                case 9:
                    base_code = "USD";
                    target_code = "COP";
                    System.out.println("dolar a peso colombiano");
                    break;
                case 10:
                    base_code = "COP";
                    target_code = "USD";
                    break;

                case 11:
                    System.out.println("Saliendo de la aplicación...");
                    continue; // Termina el ciclo
                default:
                    System.out.println("Opción inválida. Intente de nuevo. \n");
                    continue;

            }

            System.out.println("Ingresa el valor a convertir");
            valorAConvertir = lectura.nextDouble();

            try {

                double conversionRate = consulta.buscaMoneda(base_code, target_code);
                System.out.println("La tasa de cambio de " + base_code + " a " + target_code + " es: " + conversionRate);

                double valorFinal = valorAConvertir * conversionRate;
                System.out.println("El valor que obtendras es: " + valorFinal +" " + target_code);

            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("finalizando aplicación");
            }

        }

        lectura.close(); // Cierra el Scanner para liberar recursos
    }
}







