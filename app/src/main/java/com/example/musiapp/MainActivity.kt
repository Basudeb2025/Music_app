package com.example.musiapp

import android.content.ComponentCallbacks2
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var  toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val drawer:DrawerLayout = findViewById(R.id.drawer)
        val nav:NavigationView = findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(this,drawer,R.string.oprn,R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setIcon(R.drawable.img)
        supportActionBar?.title = getString(R.string.app_name)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this,R.color.dark)))
        //This code for hide the appAction Bar when it is opened
//        drawer.addDrawerListener(object : DrawerLayout.DrawerListener{
//            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {}
//            override fun onDrawerOpened(drawerView: View) {
//               supportActionBar?.hide()
//            }
//
//            override fun onDrawerClosed(drawerView: View) {
//                supportActionBar?.show()
//            }
//
//            override fun onDrawerStateChanged(newState: Int) {
//            }
//
//        })
        replacewith(First())
        val SendintentText: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,"The Type send")
            type = "text/plain"
        }
        val share = Intent.createChooser(SendintentText,null)
        nav.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home -> {
                    supportActionBar ?.title = getString(R.string.Home)
                    replacewith(First())
                }
                R.id.album -> {
                    supportActionBar ?.title = getString(R.string.Message)
                    replacewith(artisname())
                }
                R.id.artist -> {
                   // Toast.makeText(this, "This is the Sync", Toast.LENGTH_SHORT).show()
                    supportActionBar ?.title = getString(R.string.sync)
                    replacewith(artisname())
                }
                R.id.about -> {
                   // Toast.makeText(this,"Till now, its empty",Toast.LENGTH_SHORT).show()
                    supportActionBar ?.title = getString(R.string.profile)
                    replacewith(artisname())
                }
                R.id.delete -> {
                   // Toast.makeText(this,"This is the Delete",Toast.LENGTH_SHORT).show()
                    supportActionBar ?.title = getString(R.string.Delete)
                    replacewith(artisname())
                }
                R.id.setting ->{
                   // Toast.makeText(this,"This is the setting",Toast.LENGTH_SHORT).show()
                    supportActionBar ?.title = getString(R.string.settings)
                    startActivity(share)
                }
                R.id.shere -> {
                   // Toast.makeText(this,"This is the shere",Toast.LENGTH_SHORT).show()
                    supportActionBar ?.title = getString(R.string.Share)
                    replacewith(artisname())
                }
                //R.id.home -> Toast.makeText(this,"This is the Home",Toast.LENGTH_SHORT).show()
               R.id.about->{
                    Toast.makeText(this,"Hey, this app is made by BD Roy,",Toast.LENGTH_LONG).show()
               }
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun replacewith(home: Fragment) {
         val manager = supportFragmentManager
         val trans = manager.beginTransaction()
         trans.replace(R.id.frame,home)
         trans.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.newmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}