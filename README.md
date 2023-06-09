# JournalEntryApp

A simple Journal System for capturing journals and ledgers.

WorkFlow:
1. Create an Account using the accounts url (You can skip this step, as it has been populated with demo accounts)
```
http://localhost:8080/api/v1/accounts
```
2. Get account numbers to be used for creating journals
```
http://localhost:8080/api/v1/accounts
```
3. Use the accounts to create a journal using the journals api
```
http://localhost:8080/api/v1/journal
```
Once the journal has been created. A General Ledger will create an entry for Debit and another entry for Credit.

4. Use journal id to reverse a transaction
```
http://localhost:8080/api/v1/journal/{id}
```
Once the journal has been reversed. The journal ledger status changes to reversed and a General Ledger will create a reverse entry for Debit and another entry for Credit.
5. View all the General Ledger items

```
http://localhost:8080/api/v1/ledger
```

## Local Development
Requirements:
1. Docker
2. Java JDK 17

To start your application run:

```
docker-compose up
```

that will spin a docker container running a mysql instance with the default configuration.

Run the application:

```
mvn spring-boot:run
```

Once you run the application, you can find the swagger documentation at the below URL:
```
http://localhost:8080/swagger-ui/index.html
```

## Building for production

### Packaging as jar

To build the final jar and optimize the JournalEntryApp application for production, run:

```
./mvnw -Pprod clean verify
```

To ensure everything worked, run:

```
java -jar target/*.jar
```

### Packaging as war

To package your application as a war in order to deploy it to an application server, run:

```
./mvnw -Pprod,war clean verify
```


