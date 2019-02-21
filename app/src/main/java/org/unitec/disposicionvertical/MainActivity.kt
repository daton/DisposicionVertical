package org.unitec.disposicionvertical

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.EditText
import android.widget.Toast
import com.mobsandgeeks.saripaar.ValidationError
import com.mobsandgeeks.saripaar.Validator
import com.mobsandgeeks.saripaar.annotation.Email
import com.mobsandgeeks.saripaar.annotation.Password
import kotlinx.android.synthetic.main.activity_main.*
import com.mobsandgeeks.saripaar.annotation.Password.Scheme




class MainActivity : AppCompatActivity() , Validator.ValidationListener{

    @Email(message = "correo inválido")
    private var login:EditText?=null

    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC, message = "passwrdo no valido")
    private var password: EditText? = null



    override fun onValidationFailed(errors: MutableList<ValidationError>?) {
        var mensa="men"

        for (error in errors!!) {
            val view = error.view

            mensa=error.getCollatedErrorMessage(applicationContext)
        }

  Toast.makeText(applicationContext, "Error "+mensa, Toast.LENGTH_LONG).show()
    }

    override fun onValidationSucceeded() {

        Toast.makeText(applicationContext, "Datos correctos", Toast.LENGTH_SHORT).show()
        // aqui se maneja la logica dl cliqueo del boton
        var i=Intent(this,MenuActivity::class.java)
        //la siguiente linea nos invoca la navegacion
        startActivity(i)


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var validator = Validator(this);

        validator.setValidationListener(this);
        login= txtLogin
        password=txtPassword



        navegar.setOnClickListener {
            validator.validate()

        }

        //Vamos a invocar el servicio del vibradordddd
     var vibrador=    getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrador.vibrate(3000)

        //Las siguientes lineas de codigo sirven para navegar
        //de esta activity a las del menu


    }
}
