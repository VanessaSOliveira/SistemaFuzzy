
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
        Sistema sistema = new Sistema(anguloInicial, velocidadeInicial, Yc);
        double Vx = sistema.calculaVelocidadeX(anguloInicial, velocidadeInicial);
        double Vy = sistema.calculaVelocidadeY(anguloInicial, velocidadeInicial);
        
        double tempoY = 
        
        double x = sistema.calculaX(tempo, Vx);
        double y = sistema.calculaY(tempo, Yc, Vy);
    }
}

    
    

