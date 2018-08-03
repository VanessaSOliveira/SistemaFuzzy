/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto3_ia;

/**
 *
 * @author aluno
 */
public class Sistema {
    
    private int Xr, Yr, Xa, Ya, Yc;
    private double angulo, velocidade;
    
    public Sistema(double angulo, double velocidade, int Yc){
        this.angulo = angulo;
        this.velocidade = velocidade;
        this.Yc = Yc;
    }
    
    public void entradas(double angulo, double velocidade){
        this.angulo = angulo;
        this.velocidade = velocidade;
    }
    
    public double calculaVelocidadeX(double velocidadeInicial, double angulo){
        //Vx = V0 cos(Ao)
        double rad = (Math.PI/180) * angulo;
        double cos = Math.cos(rad);
        
        return velocidadeInicial * cos;
    }
    
    public double calculaVelocidadeY(double velocidadeInicial, double angulo){
        //Vy = V0 sen(Ao)
        double rad = (Math.PI/180) * angulo;
        double seno = Math.sin(rad);
        
        return velocidadeInicial * seno;
    }
    
    public double calculaX(double tempo, double velocidadeX){
        //x(t) = Vx t
        return velocidadeX * tempo;
    }
    
    public double calculaY(double tempo, double Yc, double velocidadeY){
        //y(t) = Yc + Vy t - gt^2/2
        return Yc + (velocidadeY * tempo) - (9.8 * (Math.pow(tempo, 2)/2));
    }
    
    public double calculaTempoX(int x, double velocidadeX){
        return x/velocidadeX;//testar se fica int ou double
    }
    
    public double calculaTempoY(int y, double Yc, double velocidadeY){
        return Math.sqrt(2*(Yc - velocidadeY) / 9.8);
    }
    
    public int calculaXr(double tempo, double Yc, double velocidadeY){
       while(true){
           if(calculaY(tempo, Yc, velocidadeY) == 0){
               Xr = (int) calculaX(tempo, calculaVelocidadeX(velocidade, angulo));
           }
       }
    }

    public int diferencaDx(int Xr, int Xa){
        return Xr - Xa;
    }
    
    public int diferencaDy(int Yr, int Ya){
        return Yr - Ya;
    }

}
