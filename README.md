# Oracle DB with Spring Boot and Testcontainers

This project demonstrates how to use separate database users for DDL and DML using Oracle DB with Spring Boot and
Testcontainers. Using a distinct database user to create the database objects and an application user with
only DML (Data Manipulation Language) rights provides several benefits, particularly in terms of security, isolation,
and maintainability. Here is a breakdown of the benefits:

### 1. Enhanced Security

- **Minimize Permissions for Application User**: By restricting the application user's permissions to only what it
  needs (SELECT, INSERT, UPDATE, DELETE), the risk of accidental or malicious actions (e.g., schema modifications or
  data loss) is significantly reduced.
- **Protection of Schema**: The application user cannot drop or alter schema objects (tables, views, stored procedures),
  ensuring that critical database structures are not modified or deleted inadvertently or intentionally.

### 2. Role Separation and Least Privilege Principle

- Using a separate database owner adheres to the principle of "least privilege," where each user is granted only the
  permissions required to perform their function.
- The database owner manages schema changes (like table creation or alterations), while the application user focuses
  solely on data access and manipulation.

### 3. Simplified Maintenance and Schema Versioning

- **Database Schema Updates**: The application layer does not need elevated privileges for upgrades or schema
  migrations, simplifying the deployment process by keeping schema changes controlled by a designated owner or a
  migration tool like Liquibase or Flyway.
- **Version Control**: Schema changes can be better managed and audited since only the database owner user will be used
  for such operations.

### 4. Prevention of Data Corruption

- Restricting the application's user from modifying schema objects (e.g., truncating tables, dropping constraints)
  minimizes the risk of data integrity issues or invalid database states during runtime.

### 5. Test Environment Isolation

- In environments like those using **Testcontainers**, the owner user can pre-define the schema setup for tests while
  the application user is used to simulate how the actual application interacts with the database. This provides a
  realistic and production-like scenario in tests.

### 6. Auditing and Accountability

- By separating users, we can easily track and audit actions performed by the application user versus schema
  creation or maintenance. This enhances accountability and simplifies troubleshooting.

### 7. Ease of Migration and Testing

- When using tools such as **Testcontainers**, the separate user roles allow for flexibility:
    - The DDL user can be used by the containerized environment during test setup (e.g., schema initialization).
    - The DML user can simulate the actual application behavior, ensuring the separation of concerns.

### 8. Reduced Attack Surface

- If the application user credentials are compromised, attackers would only have access to the DML operations set,
  reducing the impact. They would not be able to alter schema objects or perform privileged database actions.

### Example in this Project

- `DEMOOWNER`:
    - Used during schema setup by Testcontainers and migrations with Flyway. It has full rights to modify the schema.

- `DEMOUSER`:
    - Used by the application itself. It operates strictly within the boundaries of predefined DML permissions, reducing
      the risks to the schema and structural integrity of the database.

For convenience the `DEMOUSER` has synonyms to not have to prefix the table names with the schema name.

