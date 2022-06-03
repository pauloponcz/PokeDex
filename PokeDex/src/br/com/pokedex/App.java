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

        if (views.ShowMenu() == 1) {
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

            // JSONArray abilitiesArray = objectPokemon.getJSONArray("abilities");

        }
    }
}
