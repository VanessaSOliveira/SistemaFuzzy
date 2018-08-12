package projeto3_ia;

public class Main {
    public static void main(String[] args){
        double angulo=22, velocidade=10;
        int alturaCanhao=3, xAlvo=4, yAlvo=4; //xmax = 10 ymax =7 
        Sistema sistema = new Sistema(alturaCanhao, xAlvo, yAlvo);
        Fuzzy fuzzy = new Fuzzy();
        double dx,dy;
        int cont = 0;
        while(true){
            //System.out.println("Angulo : " + angulo + " Velocidade : " + velocidade);
            System.out.println(" ------------ Iteração : " + cont);
            sistema.entradas(angulo, velocidade);
            dx = sistema.diferencaDx();
            dy = sistema.diferencaDy();
            if((dx>(-10) && dx<10)&& dy>(-7) && dy<7 ){
                    if((dx<(-0.6) || dx>0.6) ||(dy<(-0.6) || dy>0.6)  ){
                  // if(!(dx>= -0.2 && dx<=0.2 && dy>=-0.2 && dy<=0.2)){
                  //if(dx>-50 && dx<50 && dy>-22 && dy<22 ){
                   // if(true){
                            System.out.println("Dx : " + dx + " Dy : " + dy);

                            fuzzy.calculaVelocidadeEAngulo(dx, dy);
                            angulo = fuzzy.getAngulo();
                            velocidade = fuzzy.getVelocidade();
                            System.out.println("Valores retornados do fuzzy : Velocidade : " + velocidade + " Angulo : " + angulo );

                    }

                    else{
                        System.out.println("Final -- Dx : " + dx + " Dy : " + dy +" Angulo : "+ angulo+ " Velocidade : " + velocidade);
                        System.out.println("Iteração que acertou o alvo : " + cont);
                        return;
                    }
           }
            cont++;
        }
        
       
        
    }
}
