/**
 * Servicio.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre:{
      type: 'string'
    },
    //configuración del hijo
    fkUsuario:{
      model:'usuario',
      // required: true OPCIONAL -> Siempre se ingresa el FK
    }



  },

};

