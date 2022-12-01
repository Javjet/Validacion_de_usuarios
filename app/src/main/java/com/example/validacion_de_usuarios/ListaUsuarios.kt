package com.example.validacion_de_usuarios
/**
 * ListaUsuarios
 * La clase sirve para almacenar los usuarios y tener acceso a ellos desde cualquier parte de la
 * aplicacion con un objeto constante
 *
 * @property lista_usuario ArrayList de Usuarios
 *
 * @author Javier Ezquerra
 *
 */

class ListaUsuarios {
    companion object{
        //Lista de usuarios
        private var lista_usuario: ArrayList<Usuario> = ArrayList()

        //Funcion para añadir usuarios si no existen
        fun addUser(user:Usuario){
            var existsUser=false
            lista_usuario.forEach {
                if (it.nombre_Usuario.equals(user.nombre_Usuario)){
                    existsUser=true
                }
            }
            if (!existsUser){
                lista_usuario.add(user)
            }
        }

        //Funcion para eliminar usuarios si existen
        fun deleteUser(user:Usuario){
            lista_usuario.forEach {
                if (it.nombre_Usuario.equals(user.nombre_Usuario)){
                    lista_usuario.remove(user)
                }
            }
        }
        /* containsUser
        * Params: nombre del usuario y contraseña
        * Funcion comprobar la existencia de un usuario, retornando null si no existe y retornando
        * el usuario en cuestion si existe (se usa durante la conexion)
        * */
        fun containsUser(nombre_Usuario:String, contraseña:String):Usuario?{
            var user : Usuario? =null
            lista_usuario.forEach {
                if (it.nombre_Usuario.equals(nombre_Usuario)&&it.contraseña.equals(contraseña)){
                    user=it;
                }
            }
            return user
        }
        /* containsUser
        * Params: nombre del usuario
        * Funcion comprobar la existencia de un usuario, retornando null si no existe y retornando
        * el usuario en cuestion si existe
        * */
        fun containsUser(nombre_Usuario:String):Usuario?{
            var user : Usuario? =null
            lista_usuario.forEach {
                if (it.nombre_Usuario.equals(nombre_Usuario)){
                    user=it;
                }
            }
            return user
        }
    }
}