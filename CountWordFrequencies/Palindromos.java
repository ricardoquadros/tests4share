import java.util.*;

public class Palindromos {
  public static void main(String args[]) {
    //String word = "Socorram me subi no onibus em Marrocos";
    //String word0 = "A dama admirou o rim da amada";
    String word0 = "O troto torto";
    
    String word1 = word0.toUpperCase().replaceAll("\\s+","");
    
    int tam = word1.length() -1;
    char[] letras = word1.toCharArray();
    
    System.out.println(word0 + " -> " + word1.length());
    boolean p = true;
    for(int i=0;i<tam/2;i++) {
        System.out.println("(" + i +", " + (tam-i) + "): " + letras[i] + "." + letras[tam-i]);
        if(letras[i] != letras[tam-i]){
            p = false;
            break;
        }
    }
    
    System.out.println(p);
  }
}
