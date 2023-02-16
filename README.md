# Protectora Huellas

La protectora de animales Huellas de Ávila nos ha pedido digitalizar su producto con el objetivo de incrementar las
adopciones o las altas como socio. Tras varias reuniones con ellos hemos obtenido la siguiente información:

**Reunión con la protectora Huellas**

Disponen de un listado de animales que se encuentran en la protectora y que esperan a ser adoptados. Tienen dos tipos de
animales: perros y gatos.

- De los perros guardan la siguiente información: un identificador único, el nombre, fecha de nacimiento, el sexo, la
  raza
  y si es o no amigable con otros perros.

- De los gatos guardan la siguiente información: un identificador único, el nombre, fecha de nacimiento, sexo, y si
  tiene
  o no el virus de la leucemia felina.

Cuando una persona quiere adoptar un animal deben llevar un registro para identificar la operación realizada. De la
adopción se guarda: un identificador único, fecha de adopción, datos de la persona que lo adopta y el animal adoptado.

- De la persona que lo adopta se necesita: un identificador único, nombre, apellidos, dni, fecha de nacimiento,
  dirección.

Una vez el animal se ha adoptado, hay que eliminarlo del listado de animales para adoptar.

Además de las adopciones, la protectora lleva un control de los socios que tiene. Los socios son personas que donan una
cantidad de dinero al mes para ayudar con los gastos de los animales. De los socios se guarda: identificador único,
nombre, apellidos, dni, cuenta bancaria.

## Conceptos transversales a tener en cuenta

- Se tiene que tener en cuenta el Diagrama de Clases planteado.
- Se tiene que tener en cuenta el Diagrama de Casos de Uso planteado.
- El proyecto se desarrollará con la arquitectura vista en clase (Clean Architecture).
- Se deberá usar el patrón de diseño: Singleton.
- Se deberá usar el patrón de diseño: Repository.
- Se deberá tener en cuenta los principios **SO**LID:
    - S: Single Responsability, responsabilidad única. Función, Clase, Package.. deberían hacer sólo una cosa.
    - O: Open/Close, abierto a actualizaciones cerrado a modificaciones. Relacionado con la arquitectura, uso de
      interfaces, etc.
- Se deberá respetar el formato de nombres acordados en variables, métodos, clases, carpetas, etc.
- Todo el código y entrega del ejercicio se hará usando Git.

## Preguntas a resolver

**Ejercicio 1**
Haz un fork del proyecto. Un fork es copiar el proyecto en tu cuenta de GitHub. Añade al profesor como revisor.

**Ejercicio 2**
Identifica en el ejercicio cada una de las partes por las que se pasa en el desarrollo del software.

**Ejercicio 3**
Crear el Diagrama de Clases (dominio). Poned atención en las cardinalidades, flechas, rombos, etc.

**Ejercicio 4**
Crear los Casos de Uso necesarios para gestionar lo indicado en el problema.

**Ejercicio 5**
Crear un menú con las siguientes opciones:

1. Añadir un gato. Esta opción permite añadir al sistema un gato. Se pedirán los datos necesarios.
2. Eliminar un gato. El sistema nos pedirá el identificador único del gato que deseamos eliminar y lo eliminará.
3. Listar gatos. Visualiza el listado de gatos almacenados.
4. Añadir persona. Permite añadir una persona que desea adoptar a un animal.
5. Crear una nueva adopción. Se pedirá el ID único del gato, el ID único de la persona y el resto de datos.
6. Listar adopciones realizadas. Mostrará las adopciones hechas. Se valorará que en vez de mostrar el ID del animal o el
   ID de la persona que lo adopta se muestre su nombre.

Nota: se puede omitir el crear el menú por funciones que tengan la misma funcionalidad.

**Toda la información que aquí se gestiona se almacenará en un fichero. Para ello, el proyecto contiene una clase para
almacenar gatos en la carpeta de data llamada CatFileDataSource. Si se desean almacenar más información con otros
modelos, se deberá tomar esta clase como plantilla cambiando el modelo Cat por el deseado.**

**Ejercicio 6**
Esta parte es un extra. El ejercicio deberá realizar lo siguiente:

- Se iniciará con el fichero vacío.
- Si al pulsar sobre la opción **3. Listar gatos** devuelve un listado vacío, se obtendrá de remoto un listado de gatos
  y se almacenarán en local. Pista: esta condición
  de ``Si no tengo datos en local voy a red, los descargo, los guardo en local y devuelvo la información`` se hará en el
  propio método de 'getCats' del repositorio.
- Para poder recoger la información de los gatos desde remoto, se ejecutará el método ``getCats()`` de la
  clase ``CatApiRemoteDataSource``.
- El modelo creado de Cats deberá coincidir con esto:
  ``
  {
  "id": 1,
  "name": "Tux",
  "date_birth": "01/02/2022",
  "sex": "male",
  "has_virus": false
  }
  ``
