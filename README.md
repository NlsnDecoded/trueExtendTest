# trueExtendTest
#Notas

No se realizaron validaciones de campos, duplicados, etc.

No se creó el CRUD para la alta de Clases.

Se ha creado el listData de Clases.

Se ha creado el listData de Estudiantes.

Se ha creado un control de errores Exception,Response para la respuesta de servicios REST y lectura de JSON.

Se ha creado un servicio Rest para la alta de Estudiantes con la selección de curso.


Servicios REST
**El ID, es autoGenerado no necesario enviar en el servicio rest, basta con mandarlo como vacío


*Create Student

POST

http://localhost:8080/restService/createStudent/

JSON DATA

{"lastName":"usr1","firstName":"Nelson","id":""}





*Lista de Estudiantes
POST

http://localhost:8080/restService/listOfStudents/



*Lista de Estudiantes y Clases seleccionadas

POST

http://localhost:8080/restService/studentClassList/


