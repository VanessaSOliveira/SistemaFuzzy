package projeto3_ia;

public class Main {
    public static void main(String[] args){
        double angulo=20, velocidade=10;
        int alturaCanhao=1, xAlvo=30, yAlvo=3; //xmax = 50 ymax =10 
        Sistema sistema = new Sistema(alturaCanhao, xAlvo, yAlvo);
        Fuzzy fuzzy = new Fuzzy();
        double dx,dy;
        while(true){
            System.out.println("Angulo : " + angulo + " Velocidade : " + velocidade);
            
            sistema.entradas(angulo, velocidade);
            dx = sistema.diferencaDx();
            dy = sistema.diferencaDy();
            if(!((dx>(-0.2) && dx<0.2) && (dy>(-0.2) && dy<0.2))){
                System.out.println("Dx : " + dx + " Dy : " + dy);

                fuzzy.calculaVelocidadeEAngulo(dx, dy);
                angulo = fuzzy.getAngulo();
                velocidade = fuzzy.getVelocidade();
            }
            else{
                System.out.println("Final -- Dx : " + dx + " Dy : " + dy +" Angulo : "+ angulo+ " Velocidade : " + velocidade);
                return;
            }
            
        }
        
       
        
    }
}
