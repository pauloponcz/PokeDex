package br.com.pokedex;

import java.util.Scanner;

public class View {

    Scanner scanner = new Scanner(System.in);

    public void Header() {
        System.out.println("============================");
        System.out.println("|    LISTA DE POKEMONS     |");
        System.out.println("============================");
    }

    public int ShowMenu() {

        int x;

        System.out.println("============================");
        System.out.println("|         POKEDEX          |");
        System.out.println("============================");
        System.out.println("|  Escolha uma opcao:      |");
        System.out.println("| 1 - Ver Pokedex          |");
        System.out.println("| 2 - Sair                 |");
        System.out.println("============================");
        x = scanner.nextInt();

        return x;
    }

    public int ShowQuestion() {
        int x;

        System.out.println("| Escolha um pokemon: ");
        x = scanner.nextInt();
        return x;
    }

    public void ShowPokemon(String name, int pokemon) {
        System.out.println("============================");
        System.out.println("|  POKEMON " + pokemon);
        System.out.println("| Nome: " + name);
        System.out.println("| Habilidades: ");
    }

    // scanner.close();
}
