package com.example.validacion_de_usuarios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.validacion_de_usuarios.databinding.ActivityMainBinding

/**
 * MainActivity
 * Esta actividad es la actividad principal y sirve para que un usuario registrado se conecte o para
 * enviarlo a un usuario no registrado a una pagina de registro
 *
 * @author Javier Ezquerra
 *
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var intentos=0
    override fun onCreate(savedInstanceState: Bundle?) {
        var actualUser : Usuario?
        super.onCreate(savedInstanceState)
        var permisos:ArrayList<String> = ArrayList()

        //Creacion de usuarios para pruebas
        permisos.add("Administrador")
        permisos.add("Profesor")
        ListaUsuarios.addUser(Usuario("U","U",permisos))
        permisos = ArrayList()
        permisos.add("Profesor")
        ListaUsuarios.addUser(Usuario("P","P",permisos))
        permisos = ArrayList()
        permisos.add("Administrador")
        ListaUsuarios.addUser(Usuario("AD","AD",permisos))
        permisos = ArrayList()
        permisos.add("Alumno")
        ListaUsuarios.addUser(Usuario("A","A",permisos))

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Boton para la conexion de usuarios, comprueba la coincidencia del nombre de usuario y su
        //contraseña con los usuarios de la clase ListaUsuarios y se le lleva a una vista u otra en funcion
        //de sus permisos si falla pierde un intento si llega a 3 se cierra la applicacion
        binding.buttonConectar.setOnClickListener{
            if (binding.editTextUsername.text.isNotEmpty()&&binding.editTextPassword.text.isNotEmpty()){
                actualUser=ListaUsuarios.containsUser(binding.editTextUsername.text.toString(),binding.editTextPassword.text.toString())
                if(actualUser!=null){
                    ActualUserClass.user=actualUser
                    intentos=0
                    if(actualUser!!.roles.size==2){
                        startActivity(Intent(this,RolElectionActivity::class.java))
                    }else if(actualUser!!.roles[0].equals("Alumno")){
                        startActivity(Intent(this,AlumnoActivity::class.java))
                    }else if(actualUser!!.roles[0].equals("Profesor")){
                        startActivity(Intent(this,ProfesorActivity::class.java))
                    }else if(actualUser!!.roles[0].equals("Administrador")){
                        startActivity(Intent(this,AdminActivity::class.java))
                    }
                }else{
                    intentos++
                }
            }
            binding.editTextUsername.text.clear()
            binding.editTextPassword.text.clear()
            if(intentos>=3){
                finish()
            }
        }
        
        //Envia al usuario a la pagina de registro
        binding.textViewRegister2.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }

    }
}