package com.example.pokemon

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.chart.BarChart
import javafx.scene.chart.PieChart
import javafx.scene.chart.XYChart


var damageDone=0.0
var damageTaken=0.0

class EstadisticasController (){
    @FXML
    private lateinit var pieChart: PieChart


    @FXML
    private lateinit var barChart: BarChart<String, Int>



    fun actualizarpie() {

        val pieChartData = FXCollections.observableArrayList(
            PieChart.Data("Daño realizado", damageDone),
            PieChart.Data("Daño recibido", damageTaken)
        )
        pieChart.data = pieChartData
        pieChart.data[0].node.style="-fx-pie-color: #861010"
        pieChart.data[1].node.style="-fx-pie-color: #b59431"

    }
    fun enviarController():EstadisticasController{
        return this
    }
    var posiciones=0

   /* fun actualizarbarras(pokemon :Pokemon) {

        val serie = XYChart.Series<String, Int>()
        serie.name = pokemon.nombre
        serie.data.add(XYChart.Data(pokemon.nombre,pokemon.contVeces))
        if (bar.data.isEmpty()){
            bar.data.add(serie)
            posiciones++
            pokemon.id=posiciones-1}
        else{
            if (bar.data.size<pokemon.id){
                bar.data.add(serie)
                pokemon.id=bar.data.size-1
            }else
                bar.data[pokemon.id]=serie
        }
    }*/
    @FXML
    fun initialize() {

    }

}