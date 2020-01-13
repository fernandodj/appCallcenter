# appCallcenter

Proyecto creado con Apache maven 3.6.3 

En la carpeta Source packages encontramos todas las clases utilizadas en la solucion:
- **Dispatcher**: Clase que maneja la cola de llamadas entrantes (implementada con una LikedBlockingQueue, se trata de una cola que mantiene el hilo esperando cuando se requiere sacar un elemento de una cola vacia), se implementa a traves de hilo, que se dispara en cada llamada entrante.
- **Employee**: Clase abstracta en la cual se maneja la cola de empleados disponibles (implementada a traves de una PriorityBlockingQueue, que es una cola priorizada para manejar la concurrencia), se dispara un hilo por cada atencion de llamada.
- **Call**: Clase con atributos y metodos de una llamada.
- **Operator**, **Director**, **Supervisor**: Clases que heredan de la clase Employee, en las cuales se les asigna la prioridad luego usada en la cola de empleados.
- **EmployeePriority**: Enum en el cual se definen las prioridades de cada tipo de empleado.

En la carpeta Test packages encontramos el Test del Dispatcher, para 4, 10 y 15 llamadas.

Con la implementacion de ambas colas se da solucion a los puntos Extras, ya que en el caso de que no haya empleado libre o que lleguen mas de 10 llamadas de forma concurrente, la llamada queda en espera.