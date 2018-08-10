
package projeto3_ia;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

/**
 *
 * @author Vanessa
 */
public class Fuzzy {
    //private Double dx, dy; // entradas
    private Double velocidade, angulo;// saidas
    
    
    public Fuzzy(){
        
    }
    
    
    //chama esse metodo e depois pega as saidas pelo get
    public void calculaVelocidadeEAngulo(Double dx, Double dy){
        String filename = "arquivo.fcl";
        FIS fis = FIS.load(filename, true);

        if (fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
	}

	// Get default function block
	FunctionBlock fb = fis.getFunctionBlock(null);
              ////////////n sei se ate essa parte tem q repetir toda vez 

	// Set inputs
	fb.setVariable("dx", dx);
	fb.setVariable("dy", dy);
                

	// Evaluate
	fb.evaluate();

	// Show output variable's chart
	fb.getVariable("Velocidade").defuzzify();
        fb.getVariable("Angulo").defuzzify();

	// Print ruleSet
	//System.out.println(fb);
        
        this.velocidade = fb.getVariable("Velocidade").getValue();
        this.angulo = fb.getVariable("Angulo").getValue();
        
	/*System.out.println("Velocidade: " + this.velocidade +
            " Angulo: " + this.angulo);*/
    }
    
    public Double getVelocidade(){
        return this.velocidade;
    }
    
    public Double getAngulo(){
        return this.angulo;
    }
    
   /* public static void main(String[] args){
        Fuzzy fuzzy = new Fuzzy();
        fuzzy.calculaVelocidadeEAngulo(20.0, 2.0);
        System.out.println("Velocidade igual a : " + fuzzy.getVelocidade());
        System.out.println("Angulo igual a : " + fuzzy.getAngulo());
        
        fuzzy.calculaVelocidadeEAngulo(2.0, 5.0);
        System.out.println("Velocidade igual a : " + fuzzy.getVelocidade());
        System.out.println("Angulo igual a : " + fuzzy.getAngulo());
        
        
        
        
    }*/
    
}
