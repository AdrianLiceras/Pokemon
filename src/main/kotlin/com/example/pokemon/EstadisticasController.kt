package com.example.pokemon

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.chart.PieChart
import javafx.stage.Stage


var damageDone=0.0
var damageTaken=0.0

class EstadisticasController (){
    @FXML
    private lateinit var pieChart: PieChart
    fun inicializarPie() {
        val pieChartData = FXCollections.observableArrayList(
            PieChart.Data("Daño Hecho", damageDone),
            PieChart.Data("Daño Recibido", damageTaken),

            )
        pieChartData.forEachIndexed { index, data ->
            pieChart.data.add(index, data)
        }
    }
    @FXML
    fun initialize() {
        inicializarPie()
    }
}