/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.treinandopooaula1;

import java.util.Scanner;// scanner de teclado 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;//pegar numero aleatório

public class TreinandoPOOAula1 {

    //nome poder e numero de jogadores vivos até o momento
    static int[] numPlayers = new int[100];
    static int totPlayerV = 0;// jogadores vivos
    static String[] nomePlayer = new String[100];
    static int[] nivelPower = new int[100];

    //nome e poder do morto
    static String[] playerEscapou = new String[100];
    static int totPlayerE = 0;
    static String[] nomeMorto = new String[100];
    static String[] poderDoMorto = new String[100];
    static int totPlayerM = 0;// jogadores mortos

    //metodo para data e ler o teclado
    static Scanner scanner = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) { // menu principal

        int opcao = 99;//iniciando a variavel
        int controleinsercao = 0;
        System.out.println("Bem vindo ao jogo do abate:");
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    System.out.println("Kenjaku leva um vazio roxo....");// matando Kenjaku
                    break;
                case 1:
                    adicionarPlayer();// chamada do metodo criar novo jogador
                    break;
                case 2:
                    listarPlayers();
                    break;
                case 3:
                    combate();
                    break;
                case 4:
                    escape();
                    break;
                case 5:
                    listarPlayerMorto();
                    break;
                case 6:
                    listarPlayerEscape();
                    break;
                case 7:
                    if (controleinsercao == 0) {
                        controleinsercao++;
                        insereautomatico();
                        System.out.println("A inserção efetuada");
                    } else {
                        System.out.println("A inserção já foi efetuada");
                    }
                    break;
                default:
                    System.out.println("Comando incorreto! Digite novamente!");
                    break;
            }
        } while (opcao != 0);
        scanner.close();
    }

    static void exibirMenu() {
        System.out.println("=========== MENU DE ESCOLHA ==========");
        System.out.println("1 - Adicionar um participante ao jogo do abate:"); // OK
        System.out.println("2 - Listar jogadores no participante do Abate:"); // OK 
        System.out.println("3 - Começar um confronto de feiticeiros:"); // TODO
        System.out.println("4 - Tentar escapar do jogo(Boa Sorte)"); // TODO 50%
        System.out.println("5 - Listar jogadores mortos"); // OK
        System.out.println("6 - Listar jogadores que escaparam do jogo"); // OK
        System.out.println("7 - inserção automatica em testes"); // OK
        System.out.println("0 - Kenjaku morre");//50%
        System.out.println("======================================");
    }

    static void adicionarPlayer() {
        Random gerador = new Random();// função random para o poder

        if (totPlayerV >= numPlayers.length) {// verifica se o numero de players foi atingido
            System.out.println("Limite máximo de contas atingido!\nContinue o jogo do abate quando alguém morrer pode ser colocado um novo jogador na barreira");
            return;
        }

        System.out.print("Digite o nome do jogador: ");
        scanner.nextLine(); // limpa o ENTER pendente
        nomePlayer[totPlayerV] = scanner.nextLine();// adiciona-se o nome de jogador
        //System.out.println(nomePlayer[totPlayerV]);
        nivelPower[totPlayerV] = gerador.nextInt(100) + 1;
        /*
        System.out.println("Digite o nivel de poder sendo de 0 a 100");
        int continuar = 0; // controle do satoru gojo
        while (continuar != -1) {
            nivelPower[totPlayerV] = scanner.nextInt();// adiciona o nivel de poder a esse novo participante//TODO FAZER RECEBER NUMERO ALEATÓRIO
            if (nivelPower[totPlayerV] >= 100) {
                System.out.println("O unico que é exceção a qualquer regra é satoru gojo não seja louco digite seu poder ...afinal vocÊ é fraco!");
            } else {
                continuar = -1; // encerra quando é um poder valido e menor que gojo
            }
        }
         */
        totPlayerV++;
        System.out.println("======================================");
        /*
        //Teste para ver se salvou:
        System.out.println("==============================================\nTeste para ver se salvou:");
        System.out.println("Feiticeiro: "+nomePlayer[totPlayerV]+"- Nivel de poder: "+nivelPower[totPlayerV]);
        totPlayerV++;// incrementa em 1 o numero de jogadores 
        System.out.println("TOTAL DE JOGADORES:"+totPlayerV);
        System.out.println("==============================================\nFIM DO TESTE");
         */
        //TODO Fazer tratativa para o poder ser aleatório ou digitado além de que controle do que o usuario digita 
    }

    static void listarPlayers() { // players vivos
        if (totPlayerV == 0) {
            System.out.println("Nenhum jogador encontrado,insira jogadores");
        } else {
            System.out.println("Listando jogadores:");
            for (int i = 0; i < totPlayerV; i++) {
                //System.out.println("incremento: " + i);
                System.out.println("Feiticeiro: " + nomePlayer[i] + "- Nivel de poder: " + nivelPower[i]);
            }
            System.out.println("======================================");
        }
    }

    static void insereautomatico() { // colocando feiticeiro automatico
        Random gerador = new Random();

        //teto de poder
        nomePlayer[totPlayerV] = "Satoru Gojo";
        nivelPower[totPlayerV] = 100; // O Feiticeiro mais forte
        totPlayerV++;

        nomePlayer[totPlayerV] = "Ryomen Sukuna";
        nivelPower[totPlayerV] = 100; // O Rei das Maldições
        totPlayerV++;

        // Tier 1: Grau Especial (Range 90 - 99)
        // Praticamente no n7ível do Gojo, mas com uma pequena margem de variação
        nomePlayer[totPlayerV] = "Yuta Okkotsu";
        nivelPower[totPlayerV] = gerador.nextInt(10) + 90;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Suguru Geto / Kenjaku";
        nivelPower[totPlayerV] = gerador.nextInt(10) + 90;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Toji Fushiguro"; // O Assassino de Feiticeiros
        nivelPower[totPlayerV] = gerador.nextInt(8) + 92;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Tengen";
        nivelPower[totPlayerV] = gerador.nextInt(10) + 90;
        totPlayerV++;

        // Tier 2: Grau 1 Elite e High-End (Range 75 - 89)
        nomePlayer[totPlayerV] = "Kinji Hakari";
        nivelPower[totPlayerV] = gerador.nextInt(15) + 85; // Pode chegar a 100 no "Jackpot"
        totPlayerV++;

        nomePlayer[totPlayerV] = "Hajime Kashimo";
        nivelPower[totPlayerV] = gerador.nextInt(10) + 88;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Kento Nanami";
        nivelPower[totPlayerV] = gerador.nextInt(10) + 75;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Mahito";
        nivelPower[totPlayerV] = gerador.nextInt(15) + 75;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Choso";
        nivelPower[totPlayerV] = gerador.nextInt(10) + 78;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Mei Mei";
        nivelPower[totPlayerV] = gerador.nextInt(10) + 75;
        totPlayerV++;

        // Tier 3: Grau 1 e Estudantes de Elite (Range 50 - 74)
        nomePlayer[totPlayerV] = "Yuji Itadori";
        nivelPower[totPlayerV] = gerador.nextInt(25) + 50; // Range largo pela sua evolução
        totPlayerV++;

        nomePlayer[totPlayerV] = "Aoi Todo";
        nivelPower[totPlayerV] = gerador.nextInt(15) + 60;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Maki Zenin";
        nivelPower[totPlayerV] = gerador.nextInt(25) + 50; // Versão intermediária
        totPlayerV++;

        nomePlayer[totPlayerV] = "Megumi Fushiguro";
        nivelPower[totPlayerV] = gerador.nextInt(20) + 50;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Hiromi Higuruma";
        nivelPower[totPlayerV] = gerador.nextInt(20) + 60;
        totPlayerV++;

        // Tier 4: Grau 2 e Suporte (Range 20 - 49)
        nomePlayer[totPlayerV] = "Nobara Kugisaki";
        nivelPower[totPlayerV] = gerador.nextInt(20) + 30;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Toge Inumaki";
        nivelPower[totPlayerV] = gerador.nextInt(15) + 35;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Panda";
        nivelPower[totPlayerV] = gerador.nextInt(15) + 30;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Noritoshi Kamo";
        nivelPower[totPlayerV] = gerador.nextInt(20) + 30;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Kokichi Muta (Mechamaru)";
        nivelPower[totPlayerV] = gerador.nextInt(30) + 20;
        totPlayerV++;
        // Tier 5: Nível de Entrada (Range 5 - 25)
        nomePlayer[totPlayerV] = "Kasumi Miwa";
        nivelPower[totPlayerV] = gerador.nextInt(15) + 5;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Mai Zenin";
        nivelPower[totPlayerV] = gerador.nextInt(15) + 10;
        totPlayerV++;

        nomePlayer[totPlayerV] = "Utahime Iori";
        nivelPower[totPlayerV] = gerador.nextInt(20) + 10; // Focada em suporte/buff
        totPlayerV++;
    }

    static void escape() {
        Random gerador = new Random();
        scanner.nextLine();
        System.out.println("Olá, qual o nome do feiticeiro que quer tentar escapar?");
        String nome = scanner.nextLine();

        int indiceEncontrado = -1;

        // Localizar o índice
        for (int i = 0; i < totPlayerV; i++) {
            if (nomePlayer[i].equalsIgnoreCase(nome)) {// compara o nome encontrado com o nome digitado 
                indiceEncontrado = i;
                break; // Encontramos o alvo, paramos o loop
            }
        }

        // Se o índice foi encontrado, removemos
        if (indiceEncontrado != -1) {
            String nomeRemovido = nomePlayer[indiceEncontrado]; // Guardamos para o print de tela final

            // O Loop de Shift: movemos todos da direita para a esquerda
            for (int j = indiceEncontrado; j < totPlayerV - 1; j++) {
                nomePlayer[j] = nomePlayer[j + 1];
                nivelPower[j] = nivelPower[j + 1];
            }

            // Atualizamos os metadados do sistema
            totPlayerV--; // menos 1 pessoa
            nomePlayer[totPlayerV] = null; // ajustando para nulo a ultima posição
            nivelPower[totPlayerV] = 0; // colocando um novo valor zerado

            int numDaSorte = gerador.nextInt(10);

            if (numDaSorte >= 5) { // definindo se vai morrer ou não por numero automatico
                System.out.println("Feiticeiro " + nomeRemovido + " saiu do Jogo do Abate com vida.");
                playerEscapou[totPlayerE] = nomeRemovido;
                totPlayerE++;// coloca uma casa a mais
            } else {
                System.out.println("Feiticeiro " + nomeRemovido + " saiu do Jogo do Abate MORTO.");
                nomeMorto[totPlayerM] = nomeRemovido;
                totPlayerM++;// coloca uma casa a mais
            }

        } else {
            // Se após percorrer todo o vetor o índice continuar -1
            System.out.println("Erro: Jogador '" + nome + "' não encontrado no sistema.");
        }
    }

    static void listarPlayerEscape() {
        if (totPlayerE == 0) {
            System.out.println("Nenhum jogador escapou ainda");
        } else {
            System.out.println("Listando jogadores:");
            for (int i = 0; i < totPlayerE; i++) {
                //System.out.println("incremento: " + i);
                System.out.println("Feiticeiro: " + playerEscapou[i]);
            }
            System.out.println("======================================");
        }
    }

    static void listarPlayerMorto() {
        if (totPlayerM == 0) {
            System.out.println("Nenhum jogador morto ainda");
        } else {
            System.out.println("Listando jogadores:");
            for (int i = 0; i < totPlayerM; i++) {
                //System.out.println("incremento: " + i);
                System.out.println("Feiticeiro: " + nomeMorto[i]);
            }
            System.out.println("======================================");
        }
    }

    static void combate() {
        // tem que ter pelo menos 2 pessoas vivas
        if (totPlayerV < 2) {
            System.out.println("Jogadores insuficientes para combate.");
            return;//quebra a função e retorna ao menu
        }
        // define o modo automatico
        Random gerador = new Random();

        int p1 = gerador.nextInt(totPlayerV);

        int p2;
        do {// não pode lutar com ele mesmo
            p2 = gerador.nextInt(totPlayerV);
        } while (p2 == p1);
        //é pego os valores dos feiticeiros vivos
        String feiticeiroA = nomePlayer[p1];
        int poderA = nivelPower[p1];

        String feiticeiroB = nomePlayer[p2];
        int poderB = nivelPower[p2];
        // mostra em tela os feiticeiros e niveis de poder
        System.out.println("Feiticeiro: " + feiticeiroA + " poder " + poderA);
        System.out.println("Feiticeiro: " + feiticeiroB + " poder " + poderB);
        
        int indiceRemover;// indice que será removido
        
        if (poderA > poderB) {
            indiceRemover = p2;
            System.out.println("Expansão de dominio realizada por "+feiticeiroA+" feiticeiro "+feiticeiroB+" morreu");
        } else if (poderB > poderA) {
            indiceRemover = p1;
            System.out.println("Expansão de dominio realizada por "+feiticeiroB+" feiticeiro "+feiticeiroA+" morreu");
        } else {
            System.out.println("Poderes iguais ambos saem machucados porém não morrem");
            return;
        }
        
        // registrando quem morreu no vetor dos mortos
        nomeMorto[totPlayerM] = nomePlayer[indiceRemover];
        totPlayerM++;

        for (int j = indiceRemover; j < totPlayerV - 1; j++) {// movendo elementos a esquerda
            nomePlayer[j] = nomePlayer[j + 1];
            nivelPower[j] = nivelPower[j + 1];
        }

        totPlayerV--; // definindo que morreu
        //limpando a ultima posição
        nomePlayer[totPlayerV] = null;
        nivelPower[totPlayerV] = 0;
    }
}
