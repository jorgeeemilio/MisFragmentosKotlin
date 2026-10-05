package es.studium.misfragmentoskotlin

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnFuego = findViewById<Button>(R.id.btnFuego)
        val btnAgua = findViewById<Button>(R.id.btnAgua)
        val btnTierra = findViewById<Button>(R.id.btnTierra)
        val btnAire = findViewById<Button>(R.id.btnAire)

        btnFuego.setOnClickListener {
            replaceFragment(FuegoFragment())
        }

        btnAgua.setOnClickListener {
            replaceFragment(AguaFragment())
        }

        btnTierra.setOnClickListener {
            replaceFragment(TierraFragment())
        }

        btnAire.setOnClickListener {
            replaceFragment(AireFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }
}
