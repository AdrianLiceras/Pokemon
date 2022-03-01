package com.example.pokemon

import javafx.collections.FXCollections
import javafx.fxml.FXML
import javafx.scene.chart.BarChart
import javafx.scene.chart.PieChart
import javafx.scene.chart.XYChart
import javafx.scene.chart.XYChart.Series


var damageDone=0.0
var damageTaken=0.0

class EstadisticasController (){
    @FXML
    private lateinit var pieChart: PieChart


    @FXML
    private lateinit var barChart: BarChart<String, Int>

    var serie1=Series<String,Int>()
    var serie2=Series<String,Int>()
    var serie3=Series<String,Int>()
    var serie4=Series<String,Int>()
    var serie5=Series<String,Int>()
    var serie6=Series<String,Int>()

    var listaXYSeries=ArrayList<Series<String,Int>>(
        arrayListOf(serie1,serie2,serie3,serie4,serie5,serie6)
    )



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

   fun actualizarBarChart(pokemon :Pokemon) {

        val serie = Series<String, Int>()
        serie.name = pokemon.nombre
        serie.data.add(XYChart.Data(pokemon.nombre,pokemon.contVeces))
        if (barChart.data.isEmpty()){
            barChart.data.add(serie)
            posiciones++
            pokemon.id=posiciones-1}
        else{
            if (barChart.data.size<pokemon.id){
                barChart.data.add(serie)
                pokemon.id=barChart.data.size-1
            }else
                barChart.data[pokemon.id]=serie
        }
    }


    @FXML
    fun initialize() {

    }

}