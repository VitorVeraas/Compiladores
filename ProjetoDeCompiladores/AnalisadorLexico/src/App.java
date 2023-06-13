import java.util.Scanner;

public class App {

    static boolean alfabetoNaoAceito(char tk) {
        if (tk == ' ' || tk == 'j' || tk == 'J' || tk == 'w' || tk == 'W' || tk == 'k' || tk == 'K' || tk == 'y' || tk == 'Y' || tk == 'ç' || tk == 'Ç' || tk == 'h' || tk == 'H' || tk == 'q' || tk == 'Q' || tk == '/' || tk == '(' || tk == ')' || tk == '&' || tk == '%' || tk == '$' || tk == '#' || tk == '@' || tk == '!') {
            return true; //Não Aceita
        } else {
            return false; //Aceita
        }
    }

    static boolean testeConsoante(char tk) {

        if (tk == 'b' || tk == 'B' || tk == 'c' || tk == 'C' || tk == 'd' || tk == 'D' || tk == 'f' || tk == 'F' || tk == 'g' || tk == 'G' || tk == 'l' || tk == 'L' || tk == 'm' || tk == 'M' || tk == 'n' || tk == 'N' || tk == 'p' || tk == 'P' || tk == 'r' || tk == 'R' || tk == 's' || tk == 'S' || tk == 't' || tk == 'T' || tk == 'v' || tk == 'V' || tk == 'x' || tk == 'X' || tk == 'z' || tk == 'Z') {
            return true; // Aceita
        } else {
            return false; //Não Aceita
        }
    }

    static boolean testeVogal(char tk) {
        char ch = Character.toUpperCase(tk);
        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true; // Aceita
        } else {
            return false; //Não Aceita
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a sequencia de caracteres: ");
        String texto = sc.nextLine();
        //0 consoante 1 vogal
        boolean flag = false;
        int index = 0;
        //verifica se todos os caracteres são aceitos
        for (char ch : texto.toCharArray()) {
            if(index > 9){//tamanho do tk 0 a 9
                System.out.println("Aviso: A palavra passa de 10 Caracteres.");
                break;// skipa pois não precisa ter + de 10 elementos, ignora o resto.
            }
            if (alfabetoNaoAceito(ch)) {
                System.out.println("Esse caracter não faz parte do alfabeto: " + ch);
                return;
            }
            if((index == 0) && (texto.toUpperCase().charAt(index) == 'Z') || (texto.toUpperCase().charAt(index) == 'X')){
                System.out.println("Palavra reservada: " + ch);
                return;
            }
            //se o ultimo caracter é um numero
            else if (!(index == texto.length() - 1) && Character.isDigit(ch)) {
                System.out.println("Caracter invalido  não deveria ser numero: " + ch);
                return;
            }else{
                if(testeConsoante(ch) && flag == false){
                    flag = true;
                }else if(testeConsoante(ch) && flag == true){
                    System.out.println("Caracter invalido  deveria ser vogal: " + ch);
                    return;
                }
                if(testeVogal(ch) && flag == true){
                    flag = false;
                }else if(testeVogal(ch) && flag == false){
                    System.out.println("Caracter invalido  deveria ser consoante: " + ch);
                    return;
                }
            }
            index++;
        }
            System.out.print("Sucesso" + "\n");
    }
}