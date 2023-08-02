import javax.swing.*;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int cantLetras=6;

        String[] palabras= {"rapido","ligero","tiempo","camino","huecos"};

        String[] [] palLetras=new String[5][cantLetras];
        int indPalabra=0; // la fila

        do{
            String palabra = palabras[indPalabra];
            for (int i=0;i<cantLetras;i++){
                palLetras[indPalabra][i] = String.valueOf(palabra.charAt(i)); //la letra la convierto en un string//
            }
            indPalabra++;

        }while(indPalabra<palabras.length);
        JOptionPane.showMessageDialog(null, "Bienvenido al ahorcado", "ahorcado", JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(Main.class.getResource("/img/ahorcado.png")));
        int letrasCorrecta=0;
        int letrasIncorrecta= 0;

        Random random = new Random();
        int posicionPalabra = random.nextInt(palabras.length);

        String palabraArmada= "";

        for(int i = 0; i< cantLetras; i++){
            palabraArmada = palabraArmada + "_";
        }

        while (letrasCorrecta < 6 && letrasIncorrecta< 6){

            String letra= JOptionPane.showInputDialog(null,"Ingrese una letra");
            if (letra.length()==1){
                boolean equivocado = true;
                String nuevaPalabraArmada= "";
                for(int i = 0; i< cantLetras; i++){
                    if(palLetras[posicionPalabra][i].equals(letra) && String.valueOf(palabraArmada.charAt(i)).equals("_")){
                        equivocado = false;
                        nuevaPalabraArmada=nuevaPalabraArmada+letra;
                    }else{
                        nuevaPalabraArmada=nuevaPalabraArmada+palabraArmada.charAt(i);
                    }
                }
                palabraArmada=nuevaPalabraArmada;
                JOptionPane.showMessageDialog(null,nuevaPalabraArmada + " - tu palabra");

                if (equivocado) {
                    letrasIncorrecta++;

                    switch (letrasIncorrecta){
                        case 1:
                            JOptionPane.showMessageDialog(null, "tu proceso " + palabraArmada, "ahorcado", JOptionPane.INFORMATION_MESSAGE,
                                    new ImageIcon(Main.class.getResource("/img/ahorcado-pierna.png")));
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "tu proceso " + palabraArmada, "ahorcado", JOptionPane.INFORMATION_MESSAGE,
                                    new ImageIcon(Main.class.getResource("/img/ahorcado-sinpiernas.png")));
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "tu proceso " + palabraArmada, "ahorcado", JOptionPane.INFORMATION_MESSAGE,
                                    new ImageIcon(Main.class.getResource("/img/ahorcado-brazo.png")));
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "tu proceso " + palabraArmada, "ahorcado", JOptionPane.INFORMATION_MESSAGE,
                                    new ImageIcon(Main.class.getResource("/img/ahorcado-sinbrazos.png")));
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, "tu proceso " + palabraArmada, "ahorcado", JOptionPane.INFORMATION_MESSAGE,
                                    new ImageIcon(Main.class.getResource("/img/ahorcado-cuerpo.png")));
                            break;
                        case 6:
                            JOptionPane.showMessageDialog(null, "tu proceso " + palabraArmada, "ahorcado", JOptionPane.INFORMATION_MESSAGE,
                                    new ImageIcon(Main.class.getResource("/img/ahorcado-fin.png")));
                            break;
                    }
                } else {
                    letrasCorrecta++;
                    
                }
            }
        }



        if(letrasCorrecta == cantLetras){
            JOptionPane.showMessageDialog(null, "FELICIDADES!!! " + palabraArmada, "ahorcado", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(Main.class.getResource("/img/winner.png")));
        }else{
            JOptionPane.showMessageDialog(null, "FFF " + palabraArmada, "ahorcado", JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(Main.class.getResource("/img/loser.png")));
        }
    }
}