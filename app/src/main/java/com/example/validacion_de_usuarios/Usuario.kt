package com.example.validacion_de_usuarios

import com.example.validacion_de_usuarios.ActualUserClass.Companion.user

/**
 * Usuario
 * La clase sirve para generar una activity para un administrador
 *
 * @property nombre_Usuario  nombre del usuario
 * @property contraseña contraseña del usuario
 * @property roles roles del usuario
 *
 * @author Javier Ezquerra
 * @constructor Crea un usuario con una serie de atributos por parametro
 *
 */
  class Usuario (var nombre_Usuario:String,var contraseña:String,var roles: List<String>) {

}
