Requirements:
1. Admin should be able to login/logout - done
2. Admin should be able to change password - done
3. Admin can add/delete/modify products - done
4. Admin can change product categories -done
5. Admin can view list of all users
6. Admin can search users by name
7. Admin can view purchase reports
8. Admin can filter the purchase reports by date and category


Technologies Used:
Spring Boot
MySQL
Lombok
Spring Security
Spring MVC
Thymeleaf
Spring JPA (Hibernate implementation)
Spring REST
Swagger 2

Login:
Username: admin
Password: admin (store as encrypted in mysql db)
You will see the index.html page where the admin can logout or change password and there is a link for the Swagger UI


Swagger UI
http://localhost:8080/swagger-ui.html


Product API:
add
delete
read(page number & size)
update

Validations on Product:
Product name cannot be empty during adding
Product id is not null or empty during updation
Product id exists during updation
Get Products by providing valid size and page number


