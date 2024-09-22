## DAT250: Software Technology Experiment Assignment 4

# Questions:

Explain the used database
The database is a H2 type in-memory database. In this case the data is stored after shutdown as a local file: DB.mv.db

When does the database run?
The database runs when the main method is run and the application is started. The database is initialized by the EntityManagerFactory.

Can you provide the SQL used to create the table Customer?

The SQL of the Customer table is: 

CREATE TABLE Customer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

However in order to make many-to-many relationships between Customers to both Addresses and CreditCards we need two joint tables (Address-Customer, and CreditCard-Customer).


# Problems:

After initially completing part 1 of the assignment and doing the steps of the JPA-tutorial I encountered problems with part 2. The main problem was inspecting changes in the database.

I had trouble inspecting changes to the database file after persistance. Attempting with simple domain class implementations without any relationships first. After trying different solutions to inspect the database tables I couldnt figure out the problem of why my objects weren't persisted after being created in the CreditCardsMain class.

After this I wanted to continue the implementation of the objects and attempt to create the correct relationships between the tables/classes, so that they would correspond with the model in the problem description. I ended up implementing the createObjects method that persists objects with relationships, and the required methods, getters and setters in the different domain classes. When I run the test I get different results than what is expected. This is likely because there are unsolved issues with correctly persisting the objects to the database.
