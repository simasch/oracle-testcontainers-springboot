# Oracle DB with Spring Boot and Testcontainers

## Separating DDL and DML Users

This project shows how to use separate database users for DDL and DML when working with Oracle DB, Spring Boot, and
Testcontainers. Having one user for creating database objects (DDL) and another user for application-level data
operations (DML) has many benefits. It improves security, keeps things organized, and makes maintenance easier. Here's a
detailed explanation:

### 1. Better Security

- **Limit Permissions for the Application User**: The application user only has permissions for tasks like SELECT,
  INSERT, UPDATE, and DELETE. This reduces the risk of mistakes or malicious actions, such as deleting or changing the
  database structure.
- **Protect the Schema**: The application user cannot change or delete important database structures like tables, views,
  or stored procedures. This ensures the schema stays safe.

### 2. Clear Role Separation

- Using separate users follows the "least privilege" principle. Each user only gets the permissions they need.
- The database owner handles schema changes (like creating or altering tables), while the application user only works
  with the data.

### 3. Easier Maintenance and Schema Management

- **Simpler Schema Updates**: The application doesn’t need extra privileges for database updates or migrations. These
  tasks can be handled by tools like Liquibase or Flyway using the database owner.
- **Better Version Control**: Since only the database owner makes schema changes, these updates are easier to track and
  audit.

### 4. Prevent Data Issues

- Limiting the application user’s permissions prevents problems like accidentally deleting tables or modifying
  constraints, which could cause data integrity issues.

### 5. Testing with Isolation

- In test environments like **Testcontainers**, the schema can be set up by the owner user. The application user then
  interacts with the database in a way that mimics real-world usage. This makes the tests more realistic.

### 6. Auditing and Accountability

- Separating users makes it easier to track who did what. For example, you can see whether a schema change or a data
  update caused an issue.

### 7. Flexible Testing and Migration

- Tools like **Testcontainers** benefit from separate users:
    - The DDL user sets up the schema during test initialization.
    - The DML user behaves like the application, focusing only on data operations.

### 8. Smaller Attack Surface

- If the application user’s credentials are leaked, the damage is limited to DML operations. Attackers cannot modify the
  schema or perform other high-level database actions.

### Example Setup in This Project

- `DEMOOWNER`:  
  This user sets up the schema during tests using **Testcontainers**. It has full rights to create tables, add
  constraints, and perform other schema-related tasks.

- `DEMOUSER`:  
  The application uses this user for all data operations. It only has DML permissions, keeping the schema and database
  structure safe.

To simplify queries, `DEMOUSER` has synonyms, so you don’t need to prefix table names with the schema name.
