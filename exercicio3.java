import java.util.Scanner;
class UrnaEleitoral {
public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] candidatos = {"Bolsonaro", "Padrekelmon", "Lula", "Ana Maria Braga", "Pelé"};
            int[] numeros = {1, 2, 3, 4, 5};
            int[] votos = new int[candidatos.length];
            int votosTotais = 0;
            boolean houveSegundoTurno = false;
            int primeiroLugar = -1;
            int segundoLugar = -1;
            
            System.out.println("Bem-vindo à urna eleitoral!");
            
            while (true) {
                System.out.println("Candidatos:");
                for (int i = 0; i < candidatos.length; i++) {
                    System.out.println(numeros[i] + " - " + candidatos[i]);
                }
                
                System.out.print("Digite o número do candidato que você deseja votar (0 para sair): ");
                int numeroVoto = scanner.nextInt();
                scanner.nextLine();
                
                if (numeroVoto == 0) {
                    break;
                }
                
                int candidatoIndex = -1;
                for (int i = 0; i < numeros.length; i++) {
                    if (numeros[i] == numeroVoto) {
                        candidatoIndex = i;
                        break;
                    }
                }
                if (candidatoIndex == -1) {
                    System.out.println("Número de candidato inválido!");
                    continue;
                }
                
                votos[candidatoIndex]++;
                votosTotais++;
                System.out.println("Seu voto foi registrado com sucesso para " + candidatos[candidatoIndex] + "!");
                

                if (!houveSegundoTurno) {
                    for (int i = 0; i < votos.length; i++) {
                        if (((double) votos[i]) / votosTotais >= 0.5) {
                            System.out.println(candidatos[i] + " ganhou com " + votos[i] + " votos!");
                            break;
                        }
                    }
                    if (votosTotais >= 2 && votosTotais % 2 == 0) {
                        for (int i = 0; i < votos.length; i++) {
                            if (primeiroLugar == -1 || votos[i] > votos[primeiroLugar]) {
                                segundoLugar = primeiroLugar;
                                primeiroLugar = i;
                            } else if (segundoLugar == -1 || votos[i] > votos[segundoLugar]) {
                                segundoLugar = i;
                            }
                        }
                        if (((double) votos[primeiroLugar]) / votosTotais < 0.5) {
                            System.out.println("Houve segundo turno entre " + candidatos[primeiroLugar] + " e " + candidatos[segundoLugar] + "!");
                            houveSegundoTurno = true;
                        }
                    }
                } else {
                    if (votos[primeiroLugar] > votos[segundoLugar]) {
                        System.out.println(candidatos[primeiroLugar] + " ganhou com " + votos[primeiroLugar] + " votos!");
                        break;
                    } else if (votos[segundoLugar] > votos[primeiroLugar]) {
                        System.out.println(candidatos[segundoLugar] + " ganhou com " + votos[segundoLugar] + " votos!");
                        break;
                    } else {
                        System.out.println("Houve empate no segundo turno!");
                    }
                }
            }
        }
        System.out.println("Obrigado por votar na urna eleitoral!");
    }
}    