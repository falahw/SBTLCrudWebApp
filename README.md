# SBTLCrudWebApp
Java Spring Boot Employee Management System

# TECH
## Java Spring Boot
This webapp use Java Spring Boot to take advantage of its JPA Hibernate so it will be easier to access and manipulate database of the webapp

## PostgreSQL
PostgreSQL is used to manage database of the webapp

## Thymeleaf
Thymeleaf is preferred to because it is easier to deploy not only user interface but also for backend.

# How-to-Use
- pull or download file 'SBTLCrudWebApp-0.0.1-SNAPSHOT.jar' and 'employees_sbtl' (this is csv file containing SQL data type)
- use postgresql or pgAdmin to import file 'employees_sbtl', database table will be extracted from the file
- open your terminal/prompt/console in your computer and locate file 'SBTLCrudWebApp.jar'
- run file 'SBTLCrudWebApp.jar' by typing 'java -jar SBTLCrudWebApp.jar'
- open your browser and type 'localhost:8080' in the web address and then hit button 'enter' on your keyboard
- after all steps above, you should see a web page with title 'Employees List' on top of the web page and also a table inside it

## Sorting Table
- you can sort the table's list ascending or descending by clicking on the column's title
- you can sort the table's list based on employee first name, employee last name, and employee's email

## Add Employee
- to add more employee data to the table, click on blue button 'Add Employee'. You will be redirected to other web page with title 'Save Employee'
- input employee first name, employee last name, and employee's email
- click button 'Save Employee' to save new data to the table
- you will be redirected to home page after click button 'Save Employee'

## Update Data
- to update employee data, click on blue button 'Update'. You will be redirected to other web page with title 'Update Employee'
- edit any field you want to change from the data whether it is the first name, the last name, or the email
- click button 'Update Employee' after you finish edit the data
- you will be redirected to home page after click button 'Update Employee'

## Delete Data
- to delete data from the table, click on red button 'Delete'. The deleted data will be vanished from the table
- during deleting process, you will stay in the home page