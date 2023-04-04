package com.example.pokemonapp.pokeapi;

import com.example.pokemonapp.models.Pokemon;
import com.example.pokemonapp.models.PokemonRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeapiService {
    @GET("pokemon")
    Call<PokemonRequest> obtenirPokemonListe(@Query("limit") int limit,@Query("offset") int offset);
    @GET("{dexNumOrName}/")
    Call<Pokemon> getPokemon(@Path("dexNumOrName") String dexNumOrName);
}
