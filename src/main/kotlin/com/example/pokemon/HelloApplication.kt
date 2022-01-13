package com.example.pokemon

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

var arrayPokemon= ArrayList<Pokemon>()
var arrayPokeEnemy=ArrayList<PokeEnemy>()
class HelloApplication : Application() {
    override fun start(stage: Stage) {

        //Creación de objetos Pokemon
        val poke00=Pokemon("Jolteon","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Jolteon.gif",204,65,"src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\JolteonCombate.gif",50)
        val poke01=Pokemon("Charizard","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Charizard.gif",148,45,"src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\CharizardCombate.gif",10)
        val poke02=Pokemon("Vaporeon","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Vaporeon.gif",234,54,"src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\VaporeonCombate.gif",160)
        val poke10=Pokemon("Blastoise","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Blastoise.gif",222,65,"src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\BlastoiseCombate.gif",200)
        val poke11=Pokemon("Mewtwo","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Mewtwo.gif",298,75,"file:","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\MewtwoCombate.gif",145)
        val poke12=Pokemon("Butterfree","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Butterfree.gif",160,54,"src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\ButterfreeCombate.gif",120)
        //Creacción de objetos Pokemon enemigos
        val pokeEnemy1=PokeEnemy("Onix","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\OnixCombate.gif",60,200)
        val pokeEnemy2=PokeEnemy("Palkia","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\PalkiaCombate.gif",70,240)
        val pokeEnemy3=PokeEnemy("Snorlax","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\SnorlaxCombate.gif",55,220)
        val pokeEnemy4=PokeEnemy("Scizor","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\ScizorCombate.gif",60,190)
        //Rellenar lista de Pokemon Enemigo
        arrayPokeEnemy.add(pokeEnemy1)
        arrayPokeEnemy.add(pokeEnemy2)
        arrayPokeEnemy.add(pokeEnemy3)
        arrayPokeEnemy.add(pokeEnemy4)

        //Rellenar la lista de Pokemon
        arrayPokemon.add(poke00)
        arrayPokemon.add(poke01)
        arrayPokemon.add(poke02)
        arrayPokemon.add(poke10)
        arrayPokemon.add(poke11)
        arrayPokemon.add(poke12)


        val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("seleccion_pokemon_menu.fxml"))
        val scene = Scene(fxmlLoader.load(), 663.0, 397.0)

        stage.title = "Pokemon"
        stage.scene = scene
        stage.isResizable=false
        stage.show()
    }
}

fun main() {

    Application.launch(HelloApplication::class.java)


}