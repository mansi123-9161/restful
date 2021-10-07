#restful
========================================================= 
Social Media Application Resource Mappings 
User Posts== one to many 
Retrieve all Users- GET /users 
Create a User - POST /users 
Retrieve one User - GET /users/{id}
Delete a User - DELETE /users/{id}
Retrieve all posts for a User - GET /users/{id}/posts 
Create a posts for a User - POST /users/{id}/posts 
Retrieve details of a post - GET /users/{id}/posts/

===============================
spring boot starter web has dependency over spring mvc thats why Dispatcher servlet is getting executed internally
