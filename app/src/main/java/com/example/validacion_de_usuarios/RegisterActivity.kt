package com.example.validacion_de_usuarios


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.validacion_de_usuarios.databinding.ActivityRegisterBinding

/**
 * RegisterActivity
 * Esta actividad permite registrar un usuario con su contraseña y sus permisos
 *
 * @author Javier Ezquerra
 *
 */

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Este evento permite crear un usuario cuando se rellenan los campos correctamente, el nombre
        //de usuario no esta ocupado y se ha seleccionado un permiso mediante radiobuttons
        binding.buttonRegistrar.setOnClickListener{
            ;
            ;
            ;
            binding.radioButtonAdminProf.isChecked;
            var lista_Roles :ArrayList<String> = ArrayList()
            if (binding.editTextUsername.text.isNotEmpty()
                &&binding.editTextPassword.text.isNotEmpty()
                &&ListaUsuarios.containsUser((binding.editTextUsername.text.toString()))==null
                &&binding.editTextPassword.text.toString().equals(binding.editTextPassword2.text.toString())
                &&(
                        binding.radioButtonAdministrador.isChecked
                        ||binding.radioButtonAlumno.isChecked
                        ||binding.radioButtonProfesor.isChecked
                                ||binding.radioButtonAdminProf.isChecked
                        )
            ){

                if (binding.radioButtonAlumno.isChecked){
                    lista_Roles.add("Alumno")
                }
                if (binding.radioButtonProfesor.isChecked ){
                    lista_Roles.add("Profesor")
                }
                if (binding.radioButtonAdministrador.isChecked){
                    lista_Roles.add("Administrador")
                }
                if (binding.radioButtonAdminProf.isChecked){
                    lista_Roles.add("Administrador")
                    lista_Roles.add("Profesor")
                }
                ListaUsuarios.addUser(Usuario(binding.editTextUsername.text.toString(),binding.editTextPassword.text.toString(),lista_Roles))
                finish()
            }
        }
        //Estos checkers y sus funciones hacen que el usuario no pueda elegir ciertos permisos como
        // alumno y administrador
      /*  binding.checkAlumno.setOnCheckedChangeListener {
                compoundButton, b -> checkedAlumno()
        }
        binding.checkAdministrador.setOnCheckedChangeListener {
                compoundButton, b -> checkedAdministrador()
        }
        binding.checkProfesor.setOnCheckedChangeListener {
                compoundButton, b -> checkedProfesor()
        }*/

    }
    /*private fun checkedAlumno(){
        if (binding.checkAlumno.isChecked){
            binding.checkAlumno.isChecked=true
            binding.checkAdministrador.isChecked=false
            binding.checkProfesor.isChecked=false
        }
    }
    private fun checkedProfesor(){
        if (binding.checkProfesor.isChecked) {
            binding.checkProfesor.isChecked = true
            binding.checkAlumno.isChecked = false
        }
    }
    private fun checkedAdministrador(){
        if (binding.checkAdministrador.isChecked) {
            binding.checkAdministrador.isChecked = true
            binding.checkAlumno.isChecked = false
        }
    }*/
}