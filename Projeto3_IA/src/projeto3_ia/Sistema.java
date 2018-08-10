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
/*public class Sistema {
    
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
        double var = 2.0*(Math.abs(Yc - velocidadeY)) / 9.8;
        return Math.sqrt(var);
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

}*/



public class Sistema {
    
    private int Xr, Yr, Xa, Ya, Yc;
    private double angulo, velocidade;
    
    public Sistema(int Yc, int Xa, int Ya){
        this.angulo = 0;
        this.velocidade=0;
        this.Yc = Yc;
        this.Xa=Xa;
        this.Ya=Ya;
    }
    
    public void entradas(double angulo, double velocidade){
            this.angulo = this.angulo + angulo;
            this.velocidade = this.velocidade + velocidade;
           
        /*
        this.angulo = angulo;
        this.velocidade = velocidade;*/
    }
    
    private double calculaVelocidadeX(double velocidadeInicial, double angulo){
        //Vx = V0 cos(Ao)
        double rad = (Math.PI/180) * angulo;
        double cos = Math.cos(rad);
        
        double velocidadex = velocidadeInicial * cos;
        return velocidadex;
    }
    
    private double calculaVelocidadeY(double velocidadeInicial, double angulo){
        //Vy = V0 sen(Ao)
        double rad = (Math.PI/180) * angulo;
        double seno = Math.sin(rad);
        
        double velocidadey = velocidadeInicial * seno; 
        return velocidadey;
    }
    
    private double calculaX(double tempo, double velocidadeX){ //o principal
        //x(t) = Vx t
      
        double x = velocidadeX * tempo;
        return x;
    }
    
    private double calculaY(double tempo, double velocidadeY){ //o principal
        //y(t) = Yc + Vy t - gt^2/2

        double y =  Yc + (velocidadeY * tempo) - (9.8 * (Math.pow(tempo, 2)/2));
       
        
        return y;
    }
    
    private double calculaTempoY(double vx){
        //
        
        double tempoy = Xa / vx;
        return tempoy; 
    }
    
    private double calculaTempoX(double velocidadeY){
        
       /* double tempox = Math.sqrt(2*(Yc - velocidadeY) / 9.8); // da NaN aqui pq o valor ta dando negativo 
        System.out.println("yc - velocidadeY " + (Yc - velocidadeY));
        System.out.println("2*(yc - velocidade)/9.8"+ (2*(Yc - velocidadeY) / 9.8));
        System.out.println("math " + Math.sqrt(2*(Yc - velocidadeY) / 9.8) );*/
       //double delta = 2* Math.pow(velocidadeY, 2) + 78.4*Yc;
       
       double delta = Math.pow(velocidadeY, 2) + 4 * 9.8 * Yc;
      // double tempox=0;
       if(!(delta<0)){
           //double t1 = ((-2*velocidadeY) + Math.sqrt(delta))/(-9.8);
           //double t2 = ((-2*velocidadeY) - Math.sqrt(delta))/(-9.8);
           
           double t1 = ((-1*velocidadeY) + Math.sqrt(delta))/(2*-9.8);
           double t2 = ((-1*velocidadeY) - Math.sqrt(delta))/(2*-9.8);
           if(t2>=0){
               return t2;
           }
           else if(t1>=0){
               return t1;
           }
       }
       return -1;
       
       
       
       // return tempox;
    }
    
    private double calculaXr(){
        double tempox = calculaTempoX(calculaVelocidadeY(velocidade,angulo));
        if(tempox != -1){
            double xr = calculaX(tempox,calculaVelocidadeX(velocidade,angulo));
            return xr;
        }
        
        
        return -1;
    }
    
    private double calculaYr(){
        double yr = calculaY(calculaTempoY(calculaVelocidadeX(velocidade,angulo)), calculaVelocidadeY(velocidade,angulo));
        return yr; 
    }

    public double diferencaDx(){ //principal
        double xr = calculaXr();
        if(xr!= -1){
            double dx = xr - Xa;
            return dx;
        }
        return -1;
    }
    
    public double diferencaDy(){ //principal
        double dy = calculaYr() - Ya;
        return dy;
    }

   /* public static void main(String[] args){
        int velocidade=50, angulo=10, yc=1, xa= 2, ya=4;
        Sistema s = new Sistema(yc,xa,ya);
        s.entradas(angulo, velocidade);
        Double dx = s.diferencaDx();
        Double dy = s.diferencaDy();
        System.out.println("Dx: " + dx + " Dy : " + dy);
    }*/
}


