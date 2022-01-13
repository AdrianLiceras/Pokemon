package com.example.pokemon

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.control.ProgressBar
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import java.io.File
import kotlin.random.Random

class PokemonSeleccionadoController(pokemon: Pokemon) {

    var pokeselec=pokemon

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


    class InterfazPokeCombatSelect(var nombre: Label, var vida:ProgressBar, var ps:Label, var nivel:Label, var imagen: ImageView)
    class InterfazPokeCombatEnemy(var nombre: Label, var vida:ProgressBar, var ps:Label, var nivel:Label, var imagen: ImageView)




    fun inicializarSeleccion(interfazPokeCombat: InterfazPokeCombatSelect){

        val pokeSelect= File(pokeselec.imagenCombate)
        interfazPokeCombat.imagen.image=Image(pokeSelect.toURI().toString())

        interfazPokeCombat.nombre.text=pokeselec.nombre
        interfazPokeCombat.ps.text="PS"
        interfazPokeCombat.nivel.text="Nvl "+pokeselec.nivel
        interfazPokeCombat.vida.progress=pokeselec.vidaRest.toDouble()/pokeselec.vidaMax

    }
    fun inicializarEnemy(interfazPokeCombatEnemy: InterfazPokeCombatEnemy){
        val enemy= Random.nextInt(0, arrayPokeEnemy.size)
        val pokeEnemy=File(arrayPokeEnemy[enemy-1].image)
        interfazPokeCombatEnemy.imagen.image=Image(pokeEnemy.toURI().toString())

        interfazPokeCombatEnemy.nombre.text= arrayPokeEnemy[enemy].nombre
        interfazPokeCombatEnemy.ps.text="PS"
        interfazPokeCombatEnemy.nivel.text="Nvl "+arrayPokeEnemy[enemy].nivel
        interfazPokeCombatEnemy.vida.progress=arrayPokeEnemy[enemy].vidaRest.toDouble()/arrayPokeEnemy[enemy].vidaMax
    }
    @FXML
    fun initialize(){
        val enemyInterfaz=InterfazPokeCombatEnemy(nombreEnemy,progressEnemy,psEnemy,nivelEnemy,imagePokeEnemy)
        val atackInterfaz=InterfazPokeCombatSelect(nombreAtacante,progressAtacante,psAtacante,nivelAtacante,imagePokeSelect)
        inicializarEnemy(enemyInterfaz)
        inicializarSeleccion(atackInterfaz)
    }
    fun verVida(label: Label){
        label.text=pokeselec.vidaRest.toString()
    }
    fun resetVerVida(label: Label){
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
        verVida(psAtacante)
    }
    fun onMouseEnemyExited(){
        resetVerVida(psAtacante)
    }
}