[![Quality gate](https://sonarcloud.io/api/project_badges/quality_gate?project=PDSW-ECI_spring-mvc-with-bootstrap)](https://sonarcloud.io/summary/new_code?id=PDSW-ECI_spring-mvc-with-bootstrap)

# MVC + Bootstrap CSS

## Structure Directory
https://studygyaan.com/spring-boot/spring-boot-project-folder-structure-and-best-practices


En el back-end lo primero que se hizo fue crear el modelo de la base de datos, el cual se encuentra en el archivo Employee.java en la carpeta model. En este archivo se definen los atributos de la tabla de la base de datos, así como los métodos get y set para cada uno de los atributos.

Posteriormente se creó el repositorio de la base de datos, el cual se encuentra en el archivo EmployeeRepository.java en la carpeta repository. En este archivo se definen los métodos que se utilizarán para interactuar con la base de datos, como por ejemplo, guardar un empleado, obtener un empleado por su id, obtener todos los empleados, etc.
    
Después se creó el controlador, el cual se encuentra en el archivo EmployeeController.java en la carpeta controller. En este archivo se definen los métodos que se utilizarán para manejar las peticiones HTTP que se hagan al back-end, como por ejemplo, guardar un empleado, obtener un empleado por su id, obtener todos los empleados, etc.

Finalmente se creó el servicio, el cual se encuentra en el archivo EmployeeService.java en la carpeta service. En este archivo se definen los métodos que se utilizarán para interactuar con el repositorio, como por ejemplo, guardar un empleado, obtener un empleado por su id, obtener todos los empleados, etc.

Se uso el employeeDTO para la comunicación entre el front y el back y el employee para la persistencia en la base de datos.

El mapper se encarga de convertir el employeeDTO en employee y viceversa.

Este EmployeeDTO se creo con la finalidad de que el front-end no tenga que conocer la estructura de la base de datos, y así poder cambiarla sin afectar al front-end.

En los services, se creo un EmployeeServiceImpl que implementa la interfaz EmployeeService, en este se implementan los métodos que se utilizarán para interactuar con el repositorio, como por ejemplo, guardar un empleado, obtener un empleado por su id, obtener todos los empleados, etc.