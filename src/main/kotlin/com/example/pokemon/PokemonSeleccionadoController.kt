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
    @FXML
    private lateinit var atacarLabel: Label
    @FXML
    private lateinit var ataqueSeguro: Label
    @FXML
    private lateinit var ataqueArriesgado: Label
    @FXML
    private lateinit var ataqueMuyArriesgado: Label
    @FXML
    private lateinit var curarLabel: Label
    @FXML
    private lateinit var cancelarAtack: Label
    @FXML
    private lateinit var borderMenu: BorderPane


    class InterfazPokeCombatSelect(var nombre: Label, var vida:ProgressBar, var ps:Label, var nivel:Label, var imagen: ImageView)
    class InterfazPokeCombatEnemy(var nombre: Label, var vida:ProgressBar, var ps:Label, var nivel:Label, var imagen: ImageView, var pokeEnemy: PokeEnemy)
    var pokeselec=Pokemon("Jolteon","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Jolteon.gif",204,65,"src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\JolteonCombate.gif")


    fun cargarPokemon(pokemon :Pokemon) {
        pokemon.click=false
        pokeselec = pokemon

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
        if(interfazPokeCombat.vida.progress>0.5)
            interfazPokeCombat.vida.style="-fx-accent: #20ee31"
        else
            if(interfazPokeCombat.vida.progress>0.25)
                interfazPokeCombat.vida.style="-fx-accent: #ff8929"
            else
                if (interfazPokeCombat.vida.progress<0.25)
                    interfazPokeCombat.vida.style="-fx-accent:red"
                  else
                      if (interfazPokeCombat.vida.progress<0.5)
                           interfazPokeCombat.vida.style="-fx-accent:#ff8929"


    }
    val enemy= Random.nextInt(0, arrayPokeEnemy.size)
    val enemigo= arrayPokeEnemy[enemy]
    fun inicializarEnemy(interfazPokeCombatEnemy: InterfazPokeCombatEnemy){

        val pokeEnemy=File(enemigo.image)
        interfazPokeCombatEnemy.imagen.image=Image(pokeEnemy.toURI().toString())

        interfazPokeCombatEnemy.nombre.text= enemigo.nombre
        interfazPokeCombatEnemy.ps.text="PS"
        interfazPokeCombatEnemy.nivel.text="Nvl "+enemigo.nivel
        interfazPokeCombatEnemy.vida.progress=enemigo.vidaRest.toDouble()/enemigo.vidaMax
        if(interfazPokeCombatEnemy.vida.progress>0.5)
            interfazPokeCombatEnemy.vida.style="-fx-accent: #20ee31"
        else
            if(interfazPokeCombatEnemy.vida.progress>0.25)
                interfazPokeCombatEnemy.vida.style="-fx-accent:#ff8929"
            else
                if (interfazPokeCombatEnemy.vida.progress<0.25)
                    interfazPokeCombatEnemy.vida.style="-fx-accent:red"
                else{
                    if (interfazPokeCombatEnemy.vida.progress<0.5)
                        interfazPokeCombatEnemy.vida.style="-fx-accent:#ff8929"
        }
    }

    @FXML
    fun initialize(){
        val enemyInterfaz=InterfazPokeCombatEnemy(nombreEnemy,progressEnemy,psEnemy,nivelEnemy,imagePokeEnemy,enemigo)

        inicializarEnemy(enemyInterfaz)
    }
    fun verVida(label: Label){
        label.text=pokeselec.vidaRest.toString()
    }
    fun resetVerVida(label: Label){
        label.text="PS"
    }

    fun verVidaEnemy(label: Label){
        label.text=enemigo.vidaRest.toString()
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
        borderMenu.visibleProperty().set(false)
        ataqueMenu.visibleProperty().set(true)
    }

    @FXML
    fun underlineTrue(label:Label){
        label.underlineProperty().set(true)
    }
    @FXML
    fun underlineFalse(label:Label){
        label.underlineProperty().set(false)
    }


    @FXML
    fun atackEntered(){
        underlineTrue(atacarLabel)
    }
    @FXML
    fun atackExited(){
        underlineFalse(atacarLabel)
    }
    @FXML
    fun ataqueSeguroEntered(){
        underlineTrue(ataqueSeguro)
    }
    @FXML
    fun ataqueSeguroExited(){
        underlineFalse(ataqueSeguro)
    }
    @FXML
    fun ataqueArriesgadoEntered(){
        underlineTrue(ataqueArriesgado)
    }
    @FXML
    fun ataqueArriesgadoExited(){
        underlineFalse(ataqueArriesgado)
    }
    @FXML
    fun ataqueMuyArriesgadoEntered(){
        underlineTrue(ataqueMuyArriesgado)
    }
    @FXML
    fun ataqueMuyArriesgadoExited(){
        underlineFalse(ataqueMuyArriesgado)
    }
    @FXML
    fun curarLabelEntered(){
        underlineTrue(curarLabel)
    }
    @FXML
    fun curarLabelExited(){
        underlineFalse(curarLabel)
    }
    @FXML
    fun cancelarAtackEntered(){
        underlineTrue(cancelarAtack)
    }
    @FXML
    fun cancelarAtackExited(){
        underlineFalse(cancelarAtack)
    }
    @FXML
    fun cancelarAtackClicked(){
        borderMenu.visibleProperty().set(true)
        ataqueMenu.visibleProperty().set(false)

    }

    @FXML
    fun ataqueSeguroClicked(){

        enemigo.recibirAtackPlayer(1)
        val enemyInterfaz=InterfazPokeCombatEnemy(nombreEnemy,progressEnemy,psEnemy,nivelEnemy,imagePokeEnemy,enemigo)
        inicializarEnemy(enemyInterfaz)

        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            pokeselec.recibirAtack(1)
            cargarPokemon(pokeselec)
        }

    }
    @FXML
    fun ataqueArriesgadoClicked(){
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
        enemigo.recibirAtackPlayer(2)
        val enemyInterfaz=InterfazPokeCombatEnemy(nombreEnemy,progressEnemy,psEnemy,nivelEnemy,imagePokeEnemy,enemigo)
        inicializarEnemy(enemyInterfaz)
        }
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            pokeselec.recibirAtack(2)
            cargarPokemon(pokeselec)
        }

    }
    @FXML
    fun ataqueMuyArriesgadoClicked(){
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            enemigo.recibirAtackPlayer(3)
            val enemyInterfaz =
                InterfazPokeCombatEnemy(nombreEnemy, progressEnemy, psEnemy, nivelEnemy, imagePokeEnemy, enemigo)
            inicializarEnemy(enemyInterfaz)
        }
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            pokeselec.recibirAtack(3)
            cargarPokemon(pokeselec)
        }
    }

    @FXML
    fun curarLabelClicked(){
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
            if (enemigo.vidaRest<enemigo.vidaMax) {
               enemigo.curarEnemy()
               val enemyInterfaz = InterfazPokeCombatEnemy(nombreEnemy, progressEnemy, psEnemy, nivelEnemy, imagePokeEnemy, enemigo)
               inicializarEnemy(enemyInterfaz)
           }
       }
        if (enemigo.isAliveEnemy() and pokeselec.isAliveSelect()) {
         if (pokeselec.vidaRest<pokeselec.vidaMax) {
               pokeselec.curarSelect()
               cargarPokemon(pokeselec)
           }
       }
    }
}