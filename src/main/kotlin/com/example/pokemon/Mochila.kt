package com.example.pokemon

import javafx.fxml.FXML
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
//Para usar la mochila con otro pokemon cierra la mochila
class Mochila {


    @FXML
    private lateinit var antidoto: Label
    @FXML
    private lateinit var anticongelar: Label
    @FXML
    private lateinit var antiquemar: Label
    @FXML
    private lateinit var vBox:VBox
    val stageMochila:Stage?=null
    var pokeCombatSelect=PokemonSeleccionadoController()
    var seleccionadoController=SeleccionDePokemonController()
    var pokemon=Pokemon("Jolteon","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Jolteon.gif",204,65,"src\\main\\resources\\com\\example\\pokemon\\Imagenes\\Macho.png","src\\main\\resources\\com\\example\\pokemon\\Imagenes\\JolteonCombate.gif")
    fun inicializar(pokemon: Pokemon){
        this.pokemon=pokemon
    }


    fun antiquemarClicked() {
        if (pokemon.quemado)

            pokemon.curarEstado(1)
        else

            alerta(antiquemar)


        seleccionadoController.actualizarAlteracion()
        pokeCombatSelect.actualizarEstadoEnCombate(pokemon)

    }

    fun anticongelarClicked() {
        if (pokemon.congelado)

            pokemon.curarEstado(2)
        else
            alerta(anticongelar)
        seleccionadoController.actualizarAlteracion()
        pokeCombatSelect.actualizarEstadoEnCombate(pokemon)
    }

    fun antidotoClicked() {
        if (pokemon.envenenado)

            pokemon.curarEstado(3)
        else
            alerta(antidoto)
        seleccionadoController.actualizarAlteracion()
        pokeCombatSelect.actualizarEstadoEnCombate(pokemon)
    }

    fun pasarController(seleccionDePokemonController: SeleccionDePokemonController,pokemonController: PokemonSeleccionadoController){
        seleccionadoController=seleccionDePokemonController
        pokeCombatSelect=pokemonController
    }

    fun alerta(nombre:Label) {
        val alert = Alert(Alert.AlertType.CONFIRMATION)
        alert.headerText = null
        alert.title = "Objeto Sin Efecto"
        alert.contentText = "El objeto " + nombre.text + " no ha tenido ningún efecto"
        val action = alert.showAndWait()
        if (action.get() == ButtonType.OK) {
            continuar()
        }
    }
    fun continuar() {

        val stage = vBox.scene.window as Stage
        stage.close()


    }
}