	Para probar los constructores, invocamos al constructor y verificamos que el objeto se genere con assertNotNull y que todos los parámetros estén bien inizializados mediante assertEquals.

	Para probar los métodos que añaden elementos, creamos una gestion o un ArrayList nuevo y lo reseteamos. Verificamos entonces mediante assertNull que no tiene elementos de los que queremos añadir, invocamos al método add de la clase que probamos y verificamos que se añaden los elementos y que tienen los parámetros especificados en la prueba.

	Para probar los métodos que eliminan elementos, creamos una clase nueva y añadimos un elemento. Verificamos que se ha añadido mediante assertNotNull. Invocamos entonces al método que lo elimina (generalmente remove o reset) y verificaos que el elemento ha sido eliminado mediante assertNull.

	Para probar los métodos de carga (load), creamos una nueva clase de gestión y un elemento que cargar. Guardamos dicho elemento en el fichero binario de disco correcto de forma manual en el test. Llamamos entonces al método de carga y verificamos que el elemento se ha cargado y que sus parámetros son correctos.

	Para probar los métodos de guardado (save), creaoms una nueva clase de gestión y un elemento que salvar. Añadimos el elemento a la gestión e invocamos el método save de la misma. Cargamos entonces el fichero correcto desde disco de forma manual y verificamos que el elemento se salvó correctamente y con los parámetros correctos.