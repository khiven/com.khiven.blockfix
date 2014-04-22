	Para probar los constructores, invocamos al constructor y verificamos que el objeto se genere con assertNotNull y que todos los par�metros est�n bien inizializados mediante assertEquals.

	Para probar los m�todos que a�aden elementos, creamos una gestion o un ArrayList nuevo y lo reseteamos. Verificamos entonces mediante assertNull que no tiene elementos de los que queremos a�adir, invocamos al m�todo add de la clase que probamos y verificamos que se a�aden los elementos y que tienen los par�metros especificados en la prueba.

	Para probar los m�todos que eliminan elementos, creamos una clase nueva y a�adimos un elemento. Verificamos que se ha a�adido mediante assertNotNull. Invocamos entonces al m�todo que lo elimina (generalmente remove o reset) y verificaos que el elemento ha sido eliminado mediante assertNull.

	Para probar los m�todos de carga (load), creamos una nueva clase de gesti�n y un elemento que cargar. Guardamos dicho elemento en el fichero binario de disco correcto de forma manual en el test. Llamamos entonces al m�todo de carga y verificamos que el elemento se ha cargado y que sus par�metros son correctos.

	Para probar los m�todos de guardado (save), creaoms una nueva clase de gesti�n y un elemento que salvar. A�adimos el elemento a la gesti�n e invocamos el m�todo save de la misma. Cargamos entonces el fichero correcto desde disco de forma manual y verificamos que el elemento se salv� correctamente y con los par�metros correctos.