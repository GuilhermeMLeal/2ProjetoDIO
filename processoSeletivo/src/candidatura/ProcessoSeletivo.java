package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class ProcessoSeletivo {
    public static void main(String[] args) {
    	imprimirListaCandidatos();
    }
    public static void imprimirListaCandidatos() {
    	 String[] candidatos = {"Guilherme", "Marcia", "Jonas"};
    	 System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
    	 for(int i=0;i<candidatos.length;i++) {
    		entrandoContato(candidatos[i]);
    	 }
    }
    public static void entrandoContato(String candidato) {
    	int tentativasRealizadas=1;
    	boolean continuarAtendendo = true;
    	boolean atendeu = false;
    	do {
    		
    		atendeu= atender();
    		continuarAtendendo = !atendeu;
    		if(continuarAtendendo)
    			tentativasRealizadas++;
    		else
    			System.out.println("Contato realizado com sucesso!");
    		
    	}while(continuarAtendendo && tentativasRealizadas<3);
    	
    	if(atendeu)
    		System.out.println("Conseguimos contato com "+candidato+ " "+tentativasRealizadas+" tentativa");
    	else
    		System.out.println("Não conseguimos contato com "+candidato+" ,número máximo tentativas"+tentativasRealizadas);
    }
    public static boolean atender() {
    	return new Random().nextInt(3)==1;
    }
    public static void selecaoCandidatos() {
        String[] candidatos = {"Guilherme", "Marcia", "Jonas"};
        int candidatoSelecionado = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatoSelecionado <= 4 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatoSelecionado++;
            }
            candidatosAtual++;
        }
    }

    public static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    public static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para cliente");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Aguardando o resultado dos demais candidatos");
        } else {
            System.out.println("Aguardando seleção");
        }
    }
}
