package com.example.pokemon

import kotlin.random.Random

data class Pokemon(val nombre:String,val image:String,val vidaMax:Int,var nivel:Int,val genero:String,var imagenCombate:String,var vidaRest:Int=vidaMax, var click:Boolean=false) {

    fun isAliveSelect():Boolean{
        var vivo=true

        if (vidaRest<=0)
            vivo=false

        return vivo
    }

    fun recibirAtack(i:Int){

        if (this.isAliveSelect())
            if (i==1)
                vidaRest-=20
            else if (i==2)
                 vidaRest-= Random.nextInt(10,26)
                 else if (i==3)
                    vidaRest-=Random.nextInt(0,51)


    }

    fun curarSelect(){
        vidaRest+=Random.nextInt(25,76)
    }
}
data class PokeEnemy(val nombre: String,val image: String,val nivel: Int,val vidaMax: Int,var vidaRest: Int=vidaMax){
    fun isAliveEnemy():Boolean{
        var vivo=true

        if (vidaRest<=0)
            vivo=false

        return vivo
    }
    fun recibirAtackPlayer(i:Int){
        if (this.isAliveEnemy())
            if (i==1)
                vidaRest-=20
            else if (i==2)
                vidaRest-= Random.nextInt(10,26)
                else if (i==3)
                    vidaRest-=Random.nextInt(0,51)
    }

    fun curarEnemy(){
        vidaRest+=Random.nextInt(25,76)
    }
}