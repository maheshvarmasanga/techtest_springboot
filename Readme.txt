******* SPRING BOOT APPLICATION TO DEMONSTRATE BASIC CRUD OPERATIONS USING H2 IN-MEMORY DATABASE *****

1. When you run this project for the first time, a table with name EMPLOYEES is created with 4 initial records.
   scripts can be found in the /resources folder.
   
2. By default this application runs on port 8098. To change the port change this in application.properties file
3. H2 in memory database has been used.

End points: 
http://localhost:8098/employees/create 
   creates a new employee record. 

http://localhost:8098/employees/
	Returns list of employees

http://localhost:8098/employees/{id}
    Returns a specific employee data. Example: http://localhost:8098/employees/3 returns employee with id 3

http://localhost:8098/employees/delete/2
    Deletes an employee with id 2... Replace 2 with any employee id you wish to delete 
