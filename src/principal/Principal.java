package principal;

import model.ConvertirMoneda;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Principal {

    private static Scanner teclado = new Scanner(System.in);
    private static ConvertirMoneda ejecuta = new ConvertirMoneda();
    static DecimalFormat formato = new DecimalFormat("#0.00");

    public static void main(String[] args){
        var principalEjecucion = new Principal();
        principalEjecucion.muestraMenu();
    }

    public void muestraMenu(){
        int opcion = -1;
        while (opcion != 7){

            String menu = """
                    ************************************
                    Bienvenido/a al Conversor de Moneda
                    1 - Peso Mexicano ==> Dólar
                    2 - Dólar ==> Peso Mexicano
                    3 - Peso Mexicano ==> Peso Argentino
                    4 - Peso Argentino ==> Peso Mexicano
                    5 - Peso Mexicano ==> Real Brasileño
                    6 - Real Brasileño ==> Peso Mexicano
                    7 - Salir
                    ************************************
                    
                    Elija una opción válida:""";

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    pesoMexicanoADolar();
                    break;
                case 2:
                    dolarAPesoMexicano();
                    break;
                case 3:
                    pesoMexiAPesoArge();
                    break;
                case 4:
                    pesoArgeAPesoMexi();
                    break;
                case 5:
                    pesoMexicanoAReal();
                    break;
                case 6:
                    realAPesoMexicano();
                    break;
                case 7:
                    System.out.println("Cerrando la aplicación, vuelva pronto!!...");
                    break;
                default:
                    System.out.println("Opción inválida");

            }
        }
    }
    private static void pesoMexicanoADolar() {
        System.out.println("Ingrese el valor que desea convertir");
        double valor = teclado.nextDouble();
        double cantidad = valor;
        String divisaOrigen = "MXN";
        String divisaDestino = "USD";
        double resultado = ejecuta.convertir(cantidad, divisaOrigen, divisaDestino);
        System.out.println("El valor " + valor + "[MXN]" + " equivale a >>>>" + formato.format(resultado)  + "[USD]");
    }

    private static void dolarAPesoMexicano() {
        System.out.println("Ingrese el valor que desea convertir");
        double valor = teclado.nextDouble();
        double cantidad = valor;
        String divisaOrigen = "USD";
        String divisaDestino = "MXN";
        double resultado = ejecuta.convertir(cantidad, divisaOrigen, divisaDestino);
        System.out.println("El valor " + valor + "[USD]" + " equivale a >>>>" + formato.format(resultado) + "[MXN]");
    }

    private static void pesoMexiAPesoArge(){
        System.out.println("Ingrese el valor que desea convertir");
        double valor = teclado.nextDouble();
        double cantidad = valor;
        String divisaOrigen = "MXN";
        String divisaDestino = "ARS";
        double resultado = ejecuta.convertir(cantidad, divisaOrigen, divisaDestino);
        System.out.println("El valor " + valor + "[MXN]" + " equivale a >>>>" + formato.format(resultado) + "[ARS]");
    }

    private static void pesoArgeAPesoMexi(){
        System.out.println("Ingrese el valor que desea convertir");
        double valor = teclado.nextDouble();
        double cantidad = valor;
        String divisaOrigen = "ARS";
        String divisaDestino = "MXN";
        double resultado = ejecuta.convertir(cantidad, divisaOrigen, divisaDestino);
        System.out.println("El valor " + valor + "[ARS]" + " equivale a >>>>" + formato.format(resultado) + "[MXN]");
    }

    private static void pesoMexicanoAReal(){
        System.out.println("Ingrese el valor que desea convertir");
        double valor = teclado.nextDouble();
        double cantidad = valor;
        String divisaOrigen = "MXN";
        String divisaDestino = "BRL";
        double resultado = ejecuta.convertir(cantidad, divisaOrigen, divisaDestino);
        System.out.println("El valor " + valor + "[MXN]" + " equivale a >>>>" + formato.format(resultado) + "[BRL]");
    }

    private static void realAPesoMexicano(){
        System.out.println("Ingrese el valor que desea convertir");
        double valor = teclado.nextDouble();
        double cantidad = valor;
        String divisaOrigen = "BRL";
        String divisaDestino = "MXN";
        double resultado = ejecuta.convertir(cantidad, divisaOrigen, divisaDestino);
        System.out.println("El valor " + valor + "[BRL]" + " equivale a >>>>" + formato.format(resultado) + "[MXN]");
    }
}
