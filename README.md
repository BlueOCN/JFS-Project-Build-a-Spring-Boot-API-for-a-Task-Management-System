# JFS-Project-Build-a-Spring-Boot-API-for-a-Task-Management-System
You are tasked with developing a Spring Boot API for a Task Management System. The API will:

- Allow users to manage a list of tasks.
- Include operations to create, view, update, and delete tasks.
- Use a database (H2 or MySQL) to persist task data.
- Expose endpoints for managing tasks, with functionality for marking tasks as completed.
- Return proper HTTP status codes and structured responses.

## Objectives
By the end of this project, you should be able to:

- Create a Spring Boot API to manage a task list.
- Use annotations like @RestController, @GetMapping, @PostMapping, and @PutMapping to handle HTTP requests.
- Perform CRUD operations (Create, Read, Update, Delete) using Spring Data JPA.
- Integrate the application with a simple database (H2 or MySQL).
- Handle user input validation and return structured JSON responses.

## Learning Outcomes
By completing this project, you will:

- Understand how to set up and run a Spring Boot API.
- Learn to build RESTful APIs using controllers and annotations.
- Gain experience with database integration and CRUD operations using Spring Data JPA.
- Handle user input validation and implement error-handling mechanisms.
- Develop problem-solving skills by building a real-world API.

---

## Instructions

### Step 1: Setup the Project
1. Use Spring InitializerLinks to an external site. to generate a new Spring Boot project.
   - Add the following dependencies:
   - Spring Web (to create RESTful APIs).
   - Spring Data JPA (to interact with the database).
   - H2 Database (or MySQL for persistent storage).
2. Import the generated project into your IDE (IntelliJ, Eclipse, etc.).

### Step 2: Create the Task Entity
1. Define a Task class to represent the structure of the data you’ll manage.
2. Include fields such as:
   - id (unique identifier)
   - title (name of the task)
   - description (details of the task)
   - status (to indicate if the task is completed)
   - createdDate (timestamp for when the task was created)
3. Configure the class as a database entity to enable persistence.

### Step 3: Create the Task Repository
1. Create a repository interface to handle database interactions for the Task entity.
2. Use the repository to perform operations like saving, retrieving, updating, and deleting task records.

### Step 4: Create the Task Controller
1. Build a REST controller to expose the endpoints for managing tasks.
2. Define the following endpoints:
   - Get All Tasks: Retrieve a list of all tasks.
   - Get Task by ID: Retrieve details of a specific task.
   - Add a New Task: Create a new task.
   - Update a Task: Update the details or status of a task.
   - Delete a Task: Remove a task from the system.

### Step 5: Configure the Application
1. Use the application.properties file to configure the database:
   - For H2: Enable the H2 console for easy database visualization.
   - For MySQL: Add the database URL, username, and password.
2. Configure other properties such as the server port (if needed).

### Step 6: Add Validation and Error Handling
1. Use annotations like @Valid and @NotNull to validate user input (e.g., title should not be empty).
2. Implement exception handling to return meaningful error messages for invalid requests or missing resources.

### Step 7: Run and Test the Application
1. Start the Spring Boot application using the main() method in the Application class.
2. Use tools like Postman, cURL, or your web browser to test the endpoints.
   - Test creating, retrieving, updating, and deleting tasks.
   - Verify that the application correctly validates input and handles errors gracefully.
