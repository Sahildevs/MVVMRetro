package com.example.retromvvmkt.ui.view

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.retromvvmkt.R
import com.example.retromvvmkt.R.id.*
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    /*
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

     */

    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        var recyclerview = findViewById<RecyclerView>(R.id.recyclerView)

        val viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitService))).get(
            MainViewModel::class.java)

        viewModel.movieList.observe(this, Observer {
            adapter.setMovieList(it)
        })
        viewModel.getAllMovies()

        recyclerview.adapter = adapter

         */

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        navController = Navigation.findNavController(this, mainContainer)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)


        val topAppBar = findViewById<MaterialToolbar>(R.id.toolBar)
        val drawer = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navDrawer = findViewById<NavigationView>(R.id.nav_drawer)




        //DEFINING ALL TOP LEVEL DESTINATIONS
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragment1, R.id.fragment2, R.id.fragment3), drawer
        )

        //SETTING THE TOOLBAR IN SYNC WITH THE NAVIGATION GRAPH
        setSupportActionBar(topAppBar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        //CONTROLLING TO SHOW BOTTOM NAVIGATION BAR ONLY ON TOP-LEVEL DESTINATIONS
        navController.addOnDestinationChangedListener { controller: NavController, destination: NavDestination, bundle: Bundle? ->
            bottomNavigationView.isVisible = appBarConfiguration.topLevelDestinations.contains(destination.id)
        }




        /*
        topAppBar.setNavigationOnClickListener{
            drawer.openDrawer(Gravity.LEFT)

        }

         */


        //NAV DRAWER MENU LISTNER
        navDrawer.setNavigationItemSelectedListener {
            when(it.itemId){

                R.id.explore -> {
                    navController.navigate(R.id.explore)
                    drawer.closeDrawer(Gravity.LEFT)
                }


                R.id.help -> {
                    navController.navigate(R.id.help)
                    drawer.closeDrawer(Gravity.LEFT)}


            }
            true
        }


    }

    //FOR THE BACK BUTTON
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}