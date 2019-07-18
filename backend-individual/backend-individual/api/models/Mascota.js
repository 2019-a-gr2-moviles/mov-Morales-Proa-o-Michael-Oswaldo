/**
 * Mascota.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type:'string'
    },
    descripcion:{
      type:'string'
    },
    edad:{
      type:'string'
    },
    raza:{
      type:'string'
    },
    tamanio:{
      type:'string'
    },
    genero:{
      type: 'string'
    },
    fkUsuario:{
      model:'usuario'
    }
  },

};

