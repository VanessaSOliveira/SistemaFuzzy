
package projeto3_ia;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import org.jfree.chart.JFreeChart;


//import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class Projeto3_IA {

    public static void main(String[] args) {
        final int anguloInicial = 45;
        final int velocidadeInicial = 20;
        final int Yc = 5;
        final int posAlvoX = 10;
        final int posAlvoY = 10;
        
        Sistema sistema = new Sistema(anguloInicial, velocidadeInicial, Yc);
        double Vx = sistema.calculaVelocidadeX(anguloInicial, velocidadeInicial);
        double Vy = sistema.calculaVelocidadeY(anguloInicial, velocidadeInicial);
        
        double tempoX = sistema.calculaTempoX(Yc, Vx);
        double tempoY = sistema.calculaTempoY(posAlvoY, Yc, Vy);
        
        int Xr = (int) sistema.calculaX(tempoX, Vx);
        int Yr = (int) sistema.calculaY(tempoY, Yc, Vy);
        
        System.out.println(Xr + "aaaaaaaaaaaaa" + Yr);
        
        int DX = sistema.diferencaDx(Xr, posAlvoX);
        int DY = sistema.diferencaDy(Yr, posAlvoY);
        
        System.out.println(DX + "bbbbbbbbbbbbb" + DY);
        
        //colocar parte do jfuzzylogic para inserir os valores de entrada
        
        
    }
}

    
    

