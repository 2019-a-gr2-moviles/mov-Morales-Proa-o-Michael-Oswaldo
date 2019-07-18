/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type: 'string'
    },
    apellido:{
      type: 'string'
    },
    email:{
    type:'string'
    },
    cedula:{
      type: 'string'
    },
    fechaDeNacimiento:{
      type: 'string'
    },
    perfil:{
      type:'string'
    },
    contrasenia:{
      type:'string'
    },
    mascotasDeUsuario:{
      collection:'mascota',
      via: 'fkUsuario'
    },
    rolesDeUsuario: {
      collection: 'rolUsuario',
      via: 'fkUsuario'
    }
  },

};

