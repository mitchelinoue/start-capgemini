package Classes;

public class Pessoa {
    
    //atributos
    private float peso;
    private float altura;
    
    //construtor
    public Pessoa(){
        
    }
    
    //metodos
    public float calcularIMC() {
        float imc = peso / (altura * altura);
        return imc;
    }
    
     //getter
    public float getPeso(){
        return peso;
    }
    
    public float getAltura(){
       return altura;
    }
    
    //setter
    public void setPeso( float peso){
        this.peso = peso;
    }
    
    public void setAltura( float altura){
        this.altura = altura;
    }
    
}
