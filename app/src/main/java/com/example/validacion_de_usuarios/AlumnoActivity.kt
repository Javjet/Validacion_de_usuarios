package com.example.validacion_de_usuarios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.validacion_de_usuarios.databinding.ActivityAlumnoBinding

/**
 * AlumnoActivity
 * Esta actividad sirve para genera una vista para un alumno
 *
 * @author Javier Ezquerra
 *
 */

class AlumnoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAlumnoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAlumnoBinding.inflate(layoutInflater)
        binding.Bienvenido.text= getString(R.string.bienvenidoAlumno)+" "+ActualUserClass.user?.nombre_Usuario
        setContentView(binding.root)
    }
}