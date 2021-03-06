package org.unitec.disposicionvertical

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.app_bar_menu.*

class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setSupportActionBar(toolbar)

           //oculta todo y solo muestra la de inicio
         ocultarTodo()

        var inicio=findViewById(R.id.layout_inicio) as ConstraintLayout
        inicio.visibility=View.VISIBLE




        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_inicio -> {
                // Handle the camera action
                //oculta todo y solo muestra la de inicio
                ocultarTodo()

                var inicio=findViewById(R.id.layout_inicio) as ConstraintLayout
                inicio.visibility=View.VISIBLE
            }
            R.id.nav_perfil -> {
                //oculta todo y solo muestra la de inicio
                ocultarTodo()

                var inicio=findViewById(R.id.layout_perfil) as ConstraintLayout
                inicio.visibility=View.VISIBLE
            }
            R.id.nav_servicios -> {
                //oculta todo y solo muestra la de inicio
                ocultarTodo()

                var inicio=findViewById(R.id.layout_servicios) as ConstraintLayout
                inicio.visibility=View.VISIBLE
            }
            R.id.nav_contacto -> {
                //oculta todo y solo muestra la de inicio
                ocultarTodo()

                var inicio=findViewById(R.id.layout_contacto) as ConstraintLayout
                inicio.visibility=View.VISIBLE
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun ocultarTodo(){
        var inicio=findViewById(R.id.layout_inicio) as ConstraintLayout
        inicio.visibility=View.INVISIBLE

        var perfil=    findViewById(R.id.layout_perfil) as ConstraintLayout
        perfil.visibility=View.INVISIBLE

        var servicios=    findViewById(R.id.layout_servicios) as ConstraintLayout
        servicios.visibility=View.INVISIBLE

        var contacto=    findViewById(R.id.layout_contacto) as ConstraintLayout
        contacto.visibility=View.INVISIBLE
    }
}
