package com.example.filmapps.app.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.core.di.CoreComponentManager
import com.example.filmapps.ComponentManager
import com.example.filmapps.R
import com.example.filmapps.Screens
import com.example.filmapps.databinding.ActivityMainBinding
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = AppNavigator(this, R.id.layoutCont)

    override fun onCreate(savedInstanceState: Bundle?) {
        CoreComponentManager.init(context = applicationContext)
        ComponentManager.getAppManager()
        ComponentManager.apppComponent.inject(this)
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null)
            router.newRootScreen(Screens.AuthorizationScreen())
        binding = ActivityMainBinding.inflate(layoutInflater)
            .also { layout -> setContentView(layout.root) }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}