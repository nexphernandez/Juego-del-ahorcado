# Juego del Ahorcado

## Descripción del Juego
El **Juego del Ahorcado** es una aplicación interactiva desarrollada en JavaFX que permite a los usuarios disfrutar del clásico juego de adivinar palabras. Los jugadores deben adivinar letras o palabras completas antes de que se complete el dibujo del ahorcado. El juego incluye diferentes niveles de dificultad, un sistema de puntuación y funcionalidades avanzadas como registro de usuarios y recuperación de contraseñas.

## Características Principales
- **Registro y autenticación de usuarios**: Crea una cuenta o inicia sesión para guardar tu progreso.
- **Niveles de dificultad**: Fácil, medio y difícil, adaptados a diferentes habilidades.
- **Sistema de puntuación**: Obtén puntos según el nivel de dificultad y tu desempeño.
- **Recuperación de contraseña**: Recupera tu cuenta en caso de olvidar tu contraseña.
- **Gestión de usuarios**: Listado de usuarios registrados en el sistema.

## Tecnologías Utilizadas
- **Java 17**: Lenguaje de programación principal.
- **JavaFX**: Framework para la creación de interfaces gráficas modernas y dinámicas.
- **SQLite**: Base de datos ligera para almacenar usuarios, niveles y palabras.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.
- **ControlsFX**: Biblioteca adicional para mejorar la experiencia de usuario.

## Requisitos Previos
Antes de ejecutar el proyecto, asegúrate de cumplir con los siguientes requisitos:
- Tener instalado **Java 17** o superior.
- Tener configurado **Maven** en tu sistema.
- Utilizar un entorno de desarrollo como **IntelliJ IDEA** o **Visual Studio Code**.

## Cómo Iniciar el Juego
Sigue estos pasos para ejecutar el juego en tu máquina local:

1. **Clona este repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/juego-del-ahorcado.git
   cd juego-del-ahorcado
   ```

2. **Instala las dependencias**:
   ```bash
   mvn install
   ```

3. **Ejecuta el juego**:
   ```bash
   mvn javafx:run
   ```

4. **Disfruta del juego**:
   - En la pantalla principal, podrás:
     - **Iniciar sesión** si ya tienes una cuenta registrada.
     - **Registrarte** como nuevo usuario para comenzar a jugar.
   - Selecciona el nivel de dificultad (fácil, medio o difícil) y comienza a adivinar las palabras antes de que se complete el dibujo del ahorcado.
   - El sistema de puntuación se actualizará automáticamente según tu desempeño.

## Estructura del Proyecto
El proyecto está organizado de la siguiente manera:

- **`src/main/java`**: Contiene el código fuente principal.
  - **`controller`**: Controladores que manejan la lógica de la interfaz gráfica.
  - **`model`**: Clases de modelo y servicios para la interacción con la base de datos.
- **`src/main/resources`**: Archivos de recursos del proyecto.
  - **`*.fxml`**: Archivos de diseño para las interfaces gráficas.
  - **`styles.css`**: Archivo de estilos para la interfaz.
  - **`ahorcado.db`**: Base de datos SQLite utilizada por la aplicación.
- **`pom.xml`**: Archivo de configuración de Maven para gestionar dependencias y configuraciones del proyecto.

## Base de Datos
El proyecto utiliza una base de datos SQLite (`ahorcado.db`) que incluye las siguientes tablas:

- **usuarios**: Almacena la información de los usuarios registrados, como nombre de usuario, contraseña y correo electrónico.
- **niveles**: Define los niveles de dificultad disponibles (fácil, medio y difícil).
- **palabras**: Contiene las palabras asociadas a cada nivel de dificultad.

La base de datos se encuentra en el directorio `src/main/resources` y se inicializa automáticamente al ejecutar el juego.

## Capturas de Pantalla (Opcional)
Puedes incluir capturas de pantalla del juego para mostrar su interfaz gráfica. Por ejemplo:
- **Pantalla de Inicio**:
  ![Inicio](src/main/resources/imagenes/inicio.png)
- **Pantalla de Juego**:
  ![Juego](src/main/resources/imagenes/juego.png)

## Contribuciones
¡Las contribuciones son bienvenidas! Si deseas colaborar en este proyecto:
1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad:
   ```bash
   git checkout -b nueva-funcionalidad
   ```
3. Realiza tus cambios y haz un commit:
   ```bash
   git commit -m "Añadida nueva funcionalidad"
   ```
4. Envía un pull request para revisión.

## Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## Contacto
Si tienes preguntas o sugerencias, no dudes en contactarme a través de [mi correo electrónico](mailto:tu-correo@ejemplo.com) o abre un issue en el repositorio.

---

¡Gracias por usar el **Juego del Ahorcado**! Diviértete jugando y mejorando tus habilidades.