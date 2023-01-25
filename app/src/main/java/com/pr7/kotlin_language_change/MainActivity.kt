package com.pr7.kotlin_language_change



import android.app.ActivityOptions
import android.content.Intent
import android.content.SharedPreferences.Editor
import android.content.res.Configuration
import android.os.Bundle
import android.transition.Fade
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.pr7.kotlin_language_change.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private val TAG = "PR77777"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

        load()
        binding.apply {
            radiogrup.setOnCheckedChangeListener { radioGroup, i ->
                when(i){
                    R.id.radiobutton1->{
                        setLocale("en-EN")
                    }
                    R.id.radiobutton2->{
                        setLocale("ru-RU")
                    }
                    R.id.radiobutton3->{
                        setLocale("uz-UZ")
                    }

                }
            }
        }
    }

    fun setLocale(language: String?) {
        val appLocale: LocaleListCompat =
            LocaleListCompat.forLanguageTags(language)
        AppCompatDelegate.setApplicationLocales(appLocale)
        save(language)

    }



    fun save(text: String?) {
        val editor = getSharedPreferences("Pr", MODE_PRIVATE).edit() as Editor
        editor.putString("pr", text)
        editor.commit()
    }

    fun load() {
        val sharedPreferences = getSharedPreferences("Pr", MODE_PRIVATE)
        val savedtext = sharedPreferences.getString("pr", "en-EN")
        setLocale(savedtext)
        when(savedtext){
            "en-EN"->{binding.radiobutton1.isChecked=true}
            "ru-RU"->{binding.radiobutton2.isChecked=true}
            "uz-UZ"->{binding.radiobutton3.isChecked=true}
        }

        Toast.makeText(this@MainActivity,savedtext,Toast.LENGTH_SHORT).show()
    }




}