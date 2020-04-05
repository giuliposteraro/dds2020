# dds2020

Entrega 0

Objetivos
- Puesta en marcha del ambiente de desarrollo
- Repasar / familiarizarse con las tecnologías básicas a utilizar

Contexto
Se debe modelar e implementar el siguiente requerimiento de la entrega 1 del TP:
Una operación de egreso es un gasto realizado por una organización. Una operación
de egresos puede contener varios artículos (o ítems de servicios). En general, una
operación de egreso está asociada a un documento comercial.
Requerimientos
Crear un proyecto Maven siguiendo el arquetipo básico. El mismo debe ser creado
sobre un repositorio Github creado por el alumno. El proyecto debe cumplir los siguientes
requerimientos:

● La operación de egreso debe poder calcular su valor en base a los items que contiene.
● Una vez que la operación está cerrada, no se le puede cambiar el precio.
● Tenga en cuenta que pasa si se cambia el precio de un artículo.
● La operación de compra genera el documento remito, solo si todos los ítems son artículos
(no servicios).
● Los tests deben ejecutarse correctamente cuando se ejecute por consola “mvn test".
