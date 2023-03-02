
package EstruturaCondicionalSe;

public class App {
    

    public static void main(String[] args) {
        
        int media = 7;
        if(media >= 7){
            if(media == 10){
                //aprovado com nota máxima
            } else {
                //aprovado
            }
        } else {
            //reprovado
        }
        
        String codigoProduto = "asdf";
        switch(codigoProduto){
            case "abc" -> System.out.println("caso 1");
            case "def" -> System.out.println("caso 2");
            default -> System.out.println("caso 3");
        }
        
        
        
    }
}
