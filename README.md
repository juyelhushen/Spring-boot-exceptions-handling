
## Global Exception Handling

### 1. **GlobalExceptionsHandler Class**

The `GlobalExceptionsHandler` class handles exceptions globally across all controllers. This class extends `ResponseEntityExceptionHandler` and uses `@RestControllerAdvice` to manage exceptions.

- **`@RestControllerAdvice`**: This annotation indicates that the class provides advice across the entire application.
- **`@ExceptionHandler`**: This annotation is used to handle specific exceptions and return custom error responses.

### Example Methods in GlobalExceptionsHandler

- **`resourceNotFound()`**: Handles custom `ResourceNotFound` exceptions.
- **`handleResponseStatusException()`**: Handles `ResponseStatusException` and returns a `404 Not Found` status.
- **`handleSQLException()`**: Handles `SQLException` and `NullPointerException` and returns a `500 Internal Server Error` status.
- **`handlerMethodArgumentTypeMismatchException()`**: Handles `MethodArgumentTypeMismatchException` and returns a `400 Bad Request` status.
- **`handleExceptionclass()`**: Handles all other generic exceptions and returns a `503 Service Unavailable` status.

### 2. **Custom Exception Classes**

- **`ResourceNotFound`**: A custom exception class annotated with `@ResponseStatus(HttpStatus.NOT_FOUND)`. It is used when a requested resource is not found.

### Example of Custom Exception

```java
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message) {
        super(message);
    }
}
```
### Error Response Format
 - The error response is encapsulated in the ErrorDetails class, which includes:

 - **` Error Message (error)`**: A description of the error.
 - **`Status Code (code)`**: The HTTP status code.
- **`Timestamp (timestamp)`**: The date and time when the error occurred.
### Example ErrorDetails Class
```angular2html
public class ErrorDetails {
    private String error;
    private int code;
    private Date timestamp;

    public ErrorDetails(String error, int code, Date timestamp) {
        this.error = error;
        this.code = code;
        this.timestamp = timestamp;
    }

    // Getters and Setters...
}

```

### How to run
- Clone the Repository
```bash 
git clone https://github.com/juyel/exception-handling-demo.git
cd exception-handling-demo

```
- Build the Project
```bash 
mvn clean install
- ```

- Run the Application
```bash
mvn spring-boot:run
```

### Contributing
Contributions are welcome! Please open an issue or submit a pull request if you have any improvements or bug fixes