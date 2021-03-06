package com.example.pokemon

import kotlin.random.Random

data class Pokemon(val nombre:String,val image:String,val vidaMax:Int,var nivel:Int,val genero:String,var imagenCombate:String,var vidaRest:Int=vidaMax, var click:Boolean=false,var contVeces:Int=0,var id: Int = 99,var alterado:Boolean=false) {

    var quemado=false
    var envenenado=false
    var congelado=false


    fun estado(i: Int){

        if (i==0) {
            quemado = true
            alterado=true
        }
        if (i==1) {
            congelado = true
            alterado=true
        }
        if (i==2) {
            envenenado = true
            alterado=true
        }
    }

    fun isAliveSelect():Boolean{
        var vivo=true

        if (vidaRest<=0)
            vivo=false

        return vivo
    }

    fun recibirAtack(i:Int){
        var atack2=0
        var atack3=0
        if (envenenado)
            if (vidaRest-10<0) {
                vidaRest = 0
            }else{
                vidaRest-=10
            }
        if (this.isAliveSelect())
            if (i==1){
                damageDone+=20
                if (quemado){

                    if (vidaRest-40<0)
                        vidaRest=0
                    else
                        vidaRest-=40

                }else{

                if (vidaRest-20<0)
                    vidaRest=0
                else
                    vidaRest-=20}

            }
            else if (i==2) {

                atack2 = Random.nextInt(10, 26)
                if (quemado){
                    atack2*=2
                }
                damageDone+=atack2
                  if (vidaRest-atack2<0)
                    vidaRest=0
                  else
                    vidaRest-=atack2
            }
                 if (i==3){
                     atack3=Random.nextInt(0,51)
                     if (quemado){
                         atack3*=2
                     }

                     damageDone+=atack3
                    if (vidaRest-atack3<0)
                        vidaRest=0
                    else
                        vidaRest-=atack3
                 }

    }

    fun curarSelect(){
        var curarAliado=Random.nextInt(25,76)
        if (vidaRest+curarAliado>vidaMax)
            vidaRest=vidaMax
        else
            vidaRest+=curarAliado
    }
    fun curarEstado(i: Int){
        if (i==1)
            quemado=false

        if (i==2)
            congelado=false
        if (i==3)
            envenenado=false
    }
}
data class PokeEnemy(val nombre: String,val image: String,val nivel: Int,val vidaMax: Int,var vidaRest: Int=vidaMax){
    fun isAliveEnemy():Boolean{
        var vivo=true

        if (vidaRest<=0)
            vivo=false

        return vivo
    }
    fun recibirAtackPlayer(i:Int,congel:Boolean){
        var atack2=0
        var atack3=0
        if (this.isAliveEnemy())
            if (i==1){
                damageTaken+=20
                if (congel){
                    if (vidaRest-10<0)
                        vidaRest=0
                    else
                        vidaRest-=10

                }else{
                    if (vidaRest-20<0)
                        vidaRest=0
                    else
                        vidaRest-=20
                }
            }
            else if (i==2) {
                atack2 = Random.nextInt(10, 26)
                if (congel){
                    atack2/=2
                }
                damageTaken+=atack2
                if (vidaRest-atack2<0)
                    vidaRest=0
                else
                    vidaRest-=atack2
            }
            if (i==3){
                atack3=Random.nextInt(0,51)
                if (congel){
                    atack3/=2
                }
                damageTaken+=atack3
                if (vidaRest-atack3<0)
                    vidaRest=0
                else
                    vidaRest-=atack3
            }

    }

    fun curarEnemy(){
        var curarEnemigo=Random.nextInt(25,76)
        if (vidaRest+curarEnemigo>vidaMax)
            vidaRest=vidaMax
        else
            vidaRest+=curarEnemigo
    }
}