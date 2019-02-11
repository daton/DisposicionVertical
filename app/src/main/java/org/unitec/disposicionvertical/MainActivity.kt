package org.unitec.disposicionvertical

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Vamos a invocar el servicio del vibradordddd
     var vibrador=    getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrador.vibrate(3000)

        //Las siguientes lineas de codigo sirven para navegar
        //de esta activity a las del menu
          navegar.setOnClickListener {
          // aqui se maneja la logica dl cliqueo del boton
              var i=Intent(this,MenuActivity::class.java)
              //la siguiente linea nos invoca la navegacion
              startActivity(i)

          }

    }
}
