package org.unitec.disposicionvertical

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Vamos a invocar el servicio del vibrador
     var vibrador=    getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrador.vibrate(3000)

    }
}
