public class Funcionario {
    String nome;
    String cargo;
    double salario;

    public double calcularBonus(){
        if(salario>5000){
            return salario * 0.05;
        }
        return 0;
    }
    public double calcularGratificacao(){
        if(cargo.equalsIgnoreCase("Vendedor")){
            return salario * 0.05;
        }
        else{
            return 500;
        }
    }
    public double calcularIRPF(){
        double salarioFinal = salario + calcularBonus() + calcularGratificacao();
        if(salarioFinal <= 2259){
            return 0;
        }else if(salarioFinal >2259 && salarioFinal < 5000){
            return salarioFinal * 0.075;
        }else if(salarioFinal < 10000){
            return salarioFinal * 0.125;
        }else{
            return salarioFinal * 0.275;
        }


    }

}
