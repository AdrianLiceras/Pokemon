package com.example.pokemon

data class Pokemon(val nombre:String,val image:String,val vidaMax:Int,var nivel:Int,val genero:String,var imagenCombate:String,var vidaRest:Int=vidaMax, var click:Boolean=false) {

    fun isAliveSelect():Boolean{
        var vivo=true

        if (vidaRest<=0)
            vivo=false

        return vivo
    }


}
data class PokeEnemy(val nombre: String,val image: String,val nivel: Int,val vidaMax: Int,var vidaRest: Int=vidaMax){
    fun isAliveEnemy():Boolean{
        var vivo=true

        if (vidaRest<=0)
            vivo=false

        return vivo
    }
}