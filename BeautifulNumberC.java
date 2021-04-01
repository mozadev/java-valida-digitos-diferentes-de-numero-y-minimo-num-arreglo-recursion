

import java.util.Scanner;

public class BeautifulNumberC {

    public static void main(String[] args) {
        //declaracion de variables
        int n;
        int[] arreglo = new int[4]; // [2,3,4,5]
        int resultado;
        int resultado2;
        
        // ingreso de variables
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese el n: ");
        n = entrada.nextInt();
        //ingresado el arreglo
        
        for (int i = 0; i < 4; i++) {// [2,3,4,5]
            System.out.println("ingrese el elemento [" + i + "]" + "del arreglo:");
            arreglo[i] = entrada.nextInt();
            
        }
        //proceso
        resultado2 = minimumListNumber(arreglo);
        resultado = minimumNumber(n);
        
        //resultado
        System.out.println("minimo numero: " + resultado);
        
        System.out.println("minimo numero de una lista: " + resultado2);

    }

    public static int minimumNumber(int n) {
        int resultado;
        if (n < 1000 || n > 9000) {
            return 0;
        } else {

            if (isAllDifferentNumbers(n) == true) {
                resultado = n;
            } else {
                resultado = minimumNumber(n + 1);
            }
            //salida
            return resultado;

        }
    }
    private static boolean isAllDifferentNumbers(int n) {
        boolean tieneNumdif;
        int contadorCoincidencias = 0;
        String numeroCadena = Integer.toString(n);
        for (int i = 0; i < numeroCadena.length() - 1; i++) {
            for (int j = 1; j < numeroCadena.length() - i; j++) {
                if (numeroCadena.charAt(i) == numeroCadena.charAt(j + i)) {
                    contadorCoincidencias = contadorCoincidencias + 1;
                }

            }
        }
        if (contadorCoincidencias > 0) {
            tieneNumdif = false;
        } else {
            tieneNumdif = true;
        }
        return tieneNumdif;
    }

    private static int minimumListNumber(int[] arreglo) {
        int resultado;
        int menor = 999999;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] >= 1000 && arreglo[i] <= 9000) {
                if (menor >= arreglo[i]) {
                    menor = arreglo[i];
                }
            }

        }

        resultado = minimumNumber(menor);

        return resultado;

    }

}
