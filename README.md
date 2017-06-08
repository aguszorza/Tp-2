Ejemplo                                                                                                                                                                 
==========

[![Build Status](https://nicopaez.ci.cloudbees.com/view/Algo3/job/proyecto-base-aglo3/badge/icon)](https://nicopaez.ci.cloudbees.com/view/Algo3/job/proyecto-base-aglo3/)

Este proyecto es un simple ejemplo que muestra un proyecto base en Java para la material Algo3.

## Definición de pruebas
### Nombrar correctamente los archivos de pruebas

Al momento de definir un nuevo archivo que contendrá pruebas, ya sean unitarias o de integración, el patrón del nuevo archivo **deberá** ser `*Test.java`; además de ubicarse en `<directorio del proyecto>/test/`. A modo de ejemplo: `<mi proyecto>/test/<paquete>/MiNuevoArchivoTest.java`.

# Tp-2

## Informe

* https://drive.google.com/open?id=1qPvXjlvmrWRvYs8TpUmnDC_y19A1FnEjZF-ZNFLHEuA

## Comandos para escribir en archivo markdown

* http://joedicastro.com/pages/markdown.html

## Comandos de git

* http://rogerdudler.github.io/git-guide/index.es.html
* Crear un repositorio vacío: git init
* Añadir nuevos archivos para próximo commit: git add  
	Las distintas formas de ejecutarlo son:
   1. git add "nombre archivo"
   2. git add -A (añade todo)
   3. git add . (añade todo)
   4. git remote add origin https://github.com/"nombre usuario"/"nombre repositorio".git
* Quitar archivos añadidos para próximo commit: git reset  
Las distintas fofrmas de ejecutarlo son:
   1. git reset (quita todo)
   2. git reset "nombre archivo"
* Preparar cambios para subir al servidor: git commit  
	Las distintas fofrmas de ejecutarlo son:
   1. git commit -m "comentario"
   2. git commit -am "comentario" (permite hacer un add+commit)
* Visualizar los cambios realizados desde el último commit: git status
* Ver reseña de cambios: git log / git log --summary
* Subir repositorio al repositorio del servidor: git push  
	Se puede ejecutar como:  
   1. git push -u "origin" "master" ("origin" es el nombre del repositorio y "master" el branch)
* Actualizar el repositorio local a partir del repositorio del servidor: git pull  
	Se puede ejecutar como:  
   1. git pull "origin" "master"
* Descargar un repositorio: git clone  
	Se ejecuta como: git clone https://github.com/<"nombre de usuario"/"nombre del repositorio"
	
* Restaurar al estado del último commit: git checkout  
	Las distintas fofrmas de ejecutarlo son:
   1. git checkout -- <archivo>  (Restaura el archivo)
   2. git checkout <branch> (Permite cambiar de branch)

* Crear un nuevo branch: git branch "nombre del branch"
* Eliminar un branch: git branch -d "nombre del branch"
* Unificar un branch con el master: git merge "nombre del branch"
