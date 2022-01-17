package com.example.pokemon

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.ProgressBar
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import java.io.File
import kotlin.random.Random

class PokemonSeleccionadoController() {


    @FXML
    private lateinit var imagePokeSelect:ImageView
    @FXML
    private lateinit var imagePokeEnemy:ImageView
    @FXML
    private lateinit var nombreAtacante:Label
    @FXML
    private lateinit var progressAtacante: ProgressBar
    @FXML
    private lateinit var borderAtacante: BorderPane
    @FXML
    private lateinit var nivelAtacante: Label
    @FXML
    private lateinit var borderEnemy: BorderPane
    @FXML
    private lateinit var progressEnemy: ProgressBar
    @FXML
    private lateinit var nivelEnemy: Label
    @FXML
    private lateinit var nombreEnemy: Label
    @FXML
    private  lateinit var psAtacante: Label
    @FXML
    private lateinit var psEnemy: Label
    @FXML
    private lateinit var ataqueMenu:BorderPane

    class InterfazPokeCombatSelect(var nombre: Label, var vida:ProgressBar, var ps:Label, var nivel:Label, var imagen: ImageView)
    class InterfazPokeCombatEnemy(var nombre: Label, var vida:ProgressBar, var ps:Label, var nivel:Label, var imagen: ImageView)
    var pokeselec= Pokemon("Jolteon","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Jolteon.gif",204,65,"src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\JolteonCombate.gif",50)


    fun cargarPokemon(pokemon : Pokemon) {
        pokeselec = pokemon
        pokemon.click=false
        val atackInterfaz=InterfazPokeCombatSelect(nombreAtacante,progressAtacante,psAtacante,nivelAtacante,imagePokeSelect)
        inicializarSeleccion(atackInterfaz)

    }


    fun inicializarSeleccion(interfazPokeCombat: InterfazPokeCombatSelect){

        val pokeSelect= File(pokeselec.imagenCombate)
        interfazPokeCombat.imagen.image=Image(pokeSelect.toURI().toString())

        interfazPokeCombat.nombre.text=pokeselec.nombre
        interfazPokeCombat.ps.text="PS"
        interfazPokeCombat.nivel.text="Nvl "+pokeselec.nivel
        interfazPokeCombat.vida.progress=pokeselec.vidaRest.toDouble()/pokeselec.vidaMax

        if (interfazPokeCombat.vida.progress<0.25)
            interfazPokeCombat.vida.style="-fx-accent:red"
        else{
            if (interfazPokeCombat.vida.progress<0.5)
                interfazPokeCombat.vida.style="-fx-accent:#ff8929"
        }

    }
    val enemy= Random.nextInt(0, arrayPokeEnemy.size)
    fun inicializarEnemy(interfazPokeCombatEnemy: InterfazPokeCombatEnemy){

        val pokeEnemy=File(arrayPokeEnemy[enemy].image)
        interfazPokeCombatEnemy.imagen.image=Image(pokeEnemy.toURI().toString())

        interfazPokeCombatEnemy.nombre.text= arrayPokeEnemy[enemy].nombre
        interfazPokeCombatEnemy.ps.text="PS"
        interfazPokeCombatEnemy.nivel.text="Nvl "+arrayPokeEnemy[enemy].nivel
        interfazPokeCombatEnemy.vida.progress=arrayPokeEnemy[enemy].vidaRest.toDouble()/arrayPokeEnemy[enemy].vidaMax

        if (interfazPokeCombatEnemy.vida.progress<0.25)
            interfazPokeCombatEnemy.vida.style="-fx-accent:red"
        else{
            if (interfazPokeCombatEnemy.vida.progress<0.5)
                interfazPokeCombatEnemy.vida.style="-fx-accent:#ff8929"
        }
    }

    @FXML
    fun initialize(){
        val enemyInterfaz=InterfazPokeCombatEnemy(nombreEnemy,progressEnemy,psEnemy,nivelEnemy,imagePokeEnemy)

        inicializarEnemy(enemyInterfaz)
    }
    fun verVida(label: Label){
        label.text=pokeselec.vidaRest.toString()
    }
    fun resetVerVida(label: Label){
        label.text="PS"
    }

    fun verVidaEnemy(label: Label){
        label.text= arrayPokeEnemy[enemy].vidaRest.toString()
    }
    fun resetVerVidaEnemy(label: Label){
        label.text="PS"
    }
    @FXML
    fun onMouseAtackEntered(){
        verVida(psAtacante)
    }

    @FXML
    fun onMouseAtackExited(){
        resetVerVida(psAtacante)
    }

    @FXML
    fun onMouseEnemyEntered(){
        verVidaEnemy(psEnemy)
    }
    fun onMouseEnemyExited(){
        resetVerVidaEnemy(psEnemy)
    }
    @FXML
    fun ataqueClicked(){
        ataqueMenu.disableProperty().set(false)
        ataqueMenu.opacity=1.0
    }
}