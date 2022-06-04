package br.com.pokedex;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.pokedex.network.HTTPRequest;
import br.com.pokedex.View;

public class App {
    public static void main(String[] args) throws Exception {

        JSONObject object = new HTTPRequest().requestGetMethod("https://pokeapi.co/api/v2/pokemon?limit=151cls");

        JSONArray array = object.getJSONArray("results");

        View views = new View();
        int pokemon;

        while (views.ShowMenu() == 1) {

            System.out.println("============================");
            System.out.println("|    LISTA DE POKEMONS     |");
            System.out.println("============================");

            for (int index = 0; index < array.length(); index++) {

                JSONObject pokeObject = array.getJSONObject(index);
                String pokeNome = pokeObject.getString("name");
                // String pokeUrl = pokeObject.getString("url");

                System.out.println("| " + index + " -> " + pokeNome);
            }

            System.out.println("============================");

            pokemon = views.ShowQuestion();

            String url = array.getJSONObject(pokemon).getString("url");
            JSONObject objectPokemon = new HTTPRequest().requestGetMethod(url);
            String name = objectPokemon.getString("name");

            views.ShowPokemon(name, pokemon);

            // Mostra as Habilidades
            JSONArray abilitiesArray = objectPokemon.getJSONArray("abilities");
            for (int i = 0; i < abilitiesArray.length(); i++) {
                JSONObject ability = abilitiesArray.getJSONObject(i).getJSONObject("ability");
                String nameAbility = ability.getString("name");
                System.out.println("|  - " + nameAbility);
            }

            // Mostra de qual tipo eh o pokemon
            System.out.println("| Tipo: ");
            JSONArray typesArray = objectPokemon.getJSONArray("types");
            for (int i = 0; i < abilitiesArray.length(); i++) {
                JSONObject stats = typesArray.getJSONObject(i).getJSONObject("type");
                String nameType = stats.getString("name");
                System.out.println("|  - " + nameType);
            }

            // Mostra de qual eh os movimentos do pokemon
            System.out.println("| Movimentos: ");
            JSONArray movesArray = objectPokemon.getJSONArray("moves");
            for (int i = 0; i < abilitiesArray.length(); i++) {
                JSONObject move = movesArray.getJSONObject(i).getJSONObject("move");
                String nameMove = move.getString("name");
                System.out.println("|  - " + nameMove);
            }
        }
    }
}
