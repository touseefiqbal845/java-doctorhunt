# Doctor Hunt Project - Java & Groovy API

This project integrates **Java** and **Groovy** to develop the **Doctor Hunt Project APIs**, a system where patients can make appointments with doctors, maintain medical records, and receive diagnosis offers. It includes features like user authentication, doctor management, and appointment scheduling.

The application is built using **Spring Boot** for the backend, with **PostgreSQL** as the database. The project uses **DTO (Data Transfer Objects)** for managing data flow between layers, ensuring smooth communication between components.

## Project Overview

This project includes:

- **Patient Appointment Management**: Patients can book appointments with doctors.
- **Medical Records Management**: Store and manage patient medical records for ongoing and historical reference.
- **Doctor Diagnosis Offers**: Doctors can create and manage diagnostic tests offered to patients.
- **User Authentication**: Secure login and registration for both patients and doctors.
- **Spring Boot Backend**: RESTful APIs using Spring Boot framework to handle business logic and database interaction.
- **PostgreSQL Database**: Reliable relational database to store patient, doctor, appointment, and medical record data.
- **Groovy Scripting**: Groovy is used to dynamically script and enhance functionality, allowing quick changes or new features to be implemented easily.

## Features

- **User Authentication**: Patients and doctors can register, log in, and authenticate via JWT (JSON Web Tokens).
- **Appointment Booking**: Patients can view available doctors and book appointments based on time slots.
- **Medical Records**: Patients' medical records are stored securely, allowing doctors to add or view historical information.
- **Diagnosis Test Offers**: Doctors can add available diagnostic tests to their profiles for patients to select.
- **Spring Boot & PostgreSQL**: The project uses Spring Boot to create robust backend APIs and PostgreSQL for data persistence.
- **DTO (Data Transfer Objects)**: DTOs are used to transfer data between layers efficiently, ensuring proper structuring of API responses.

## API Endpoints
The following API routes are available:

## Appointments:
@RequestMapping("/api/appointments")
Endpoints for managing patient appointments.

## Diagnosis Offers:
@RequestMapping("/api/diagnosis-offers")
Endpoints for managing diagnosis offers by doctors.

## Doctors:
@RequestMapping("/api/doctors")
Endpoints for managing doctor profiles and information.

## Medical Records:
@RequestMapping("/api/medical-records")
Endpoints for managing patient medical records.

## Users:
@RequestMapping("/api/users")
Endpoints for user registration, login, and authentication.


## Requirements

- Java 8 or higher
- Groovy 2.5.0 or higher
- Apache Maven (or Gradle) for dependency management and building the project

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/touseefiqbal3681/java-doctorhunt
   cd java-groovy-project
   ```

2. Install dependencies using Maven:
   ```bash
   mvn install
   ```

   Alternatively, if you're using Gradle, run:
   ```bash
   gradle build
   ```

## Project Structure

```
JAVA-DOCTORHUNT:.
|   .gitattributes
|   .gitignore
|   build.gradle
|   Dockerfile
|   gradlew
|   gradlew.bat
|   HELP.md
|   pom.xml
|   README.md
|   settings.gradle
|
+---.gradle
|   |   file-system.probe
|   |
|   +---8.12.1
|   |   |   gc.properties
|   |   |
|   |   +---checksums
|   |   |       checksums.lock
|   |   |       md5-checksums.bin
|   |   |       sha1-checksums.bin
|   |   |
|   |   +---executionHistory
|   |   |       executionHistory.bin
|   |   |       executionHistory.lock
|   |   |
|   |   +---expanded
|   |   +---fileChanges
|   |   |       last-build.bin
|   |   |
|   |   +---fileHashes
|   |   |       fileHashes.bin
|   |   |       fileHashes.lock
|   |   |       resourceHashesCache.bin
|   |   |
|   |   \---vcsMetadata
|   +---buildOutputCleanup
|   |       buildOutputCleanup.lock
|   |       cache.properties
|   |       outputFiles.bin
|   |
|   \---vcs-1
|           gc.properties
|
+---bin
|   +---main
|   |   |   application.properties
|   |   |
|   |   \---com
|   |       \---example
|   |           \---doctorhunt
|   |               |   application.properties
|   |               |   application.yml
|   |               |   DoctorHuntApplication.class
|   |               |
|   |               +---config
|   |               +---controller
|   |               |       HomeController.class
|   |               |
|   |               +---db
|   |               |   \---migration
|   |               +---dto
|   |               +---exception
|   |               +---model
|   |               +---repository
|   |               +---resources
|   |               +---security
|   |               +---service
|   |               +---templates
|   |               \---utils
|   \---test
|       \---com
|           \---example
|               \---demo
|                       DemoApplicationTests.class
|
+---build
|   |   resolvedMainClassName
|   |
|   +---classes
|   |   \---java
|   |       +---main
|   |       |   \---com
|   |       |       \---example
|   |       |           \---doctorhunt
|   |       |               |   DoctorHuntApplication.class
|   |       |               |
|   |       |               +---config
|   |       |               |       MailConfig.class
|   |       |               |
|   |       |               +---controller
|   |       |               |       AppointmentController.class
|   |       |               |       DiagnosisOfferController.class
|   |       |               |       DoctorController.class
|   |       |               |       HomeController.class
|   |       |               |       MedicalRecordController.class
|   |       |               |       PatientController.class
|   |       |               |       UserController.class
|   |       |               |
|   |       |               +---dto
|   |       |               |       MedicalRecordDTO.class
|   |       |               |       PatientDTO.class
|   |       |               |
|   |       |               +---model
|   |       |               |       Appointment$Status.class
|   |       |               |       Appointment.class
|   |       |               |       DiagnosisOffer.class
|   |       |               |       Doctor.class
|   |       |               |       MedicalRecord.class
|   |       |               |       Patient.class
|   |       |               |       User.class
|   |       |               |
|   |       |               +---repository
|   |       |               |       AppointmentRepository.class
|   |       |               |       DiagnosisOfferRepository.class
|   |       |               |       DoctorRepository.class
|   |       |               |       MedicalRecordRepository.class
|   |       |               |       PatientRepository.class
|   |       |               |       UserRepository.class
|   |       |               |
|   |       |               +---security
|   |       |               |       SecurityConfig.class
|   |       |               |
|   |       |               \---service
|   |       |                       EmailService.class
|   |       |                       JwtService.class
|   |       |                       PatientService.class
|   |       |                       UserService.class
|   |       |
|   |       \---test
|   |           \---com
|   |               \---example
|   |                   \---demo
|   |                           DemoApplicationTests.class
|   |
|   +---generated
|   |   \---sources
|   |       +---annotationProcessor
|   |       |   \---java
|   |       |       +---main
|   |       |       \---test
|   |       \---headers
|   |           \---java
|   |               +---main
|   |               \---test
|   +---libs
|   |       demo-1.0.0-plain.jar
|   |       demo-1.0.0.jar
|   |
|   +---reports
|   |   +---problems
|   |   |       problems-report.html
|   |   |
|   |   \---tests
|   |       \---test
|   |           |   index.html
|   |           |
|   |           +---css
|   |           |       base-style.css
|   |           |       style.css
|   |           |
|   |           \---js
|   |                   report.js
|   |
|   +---resources
|   |   \---main
|   |       |   application.properties
|   |       |   application.yml
|   |       |
|   |       \---migration
|   |           \---db
|   |                   V1__create_users_table.sql
|   |                   V2__init.sql
|   |                   V3__Create_doctors_table.sql
|   |                   V4__Create_patients_table.sql
|   |                   V5__Create_doctor_patient_relationship.sql
|   |                   V6__Create_medical_records_table.sql
|   |                   V7__Create_appointments_table.sql
|   |                   V8__Create_diagnosis_offers_table.sql
|   |
|   +---test-results
|   |   \---test
|   |       \---binary
|   |               output.bin
|   |               output.bin.idx
|   |               results.bin
|   |
|   \---tmp
|       +---bootJar
|       |       MANIFEST.MF
|       |
|       +---compileJava
|       |   |   previous-compilation-data.bin
|       |   |
|       |   \---compileTransaction
|       |       +---backup-dir
|       |       \---stash-dir
|       |               MedicalRecordController.class.uniqueId1
|       |               PatientController.class.uniqueId2
|       |               PatientRepository.class.uniqueId0
|       |               PatientService.class.uniqueId3
|       |
|       +---compileTestJava
|       |       previous-compilation-data.bin
|       |
|       +---jar
|       |       MANIFEST.MF
|       |
|       \---test
+---gradle
|   \---wrapper
|           gradle-wrapper.jar
|           gradle-wrapper.properties
|
+---logs
|       app.log
|       app.log.2025-02-18.0.gz
|       app.log.2025-02-19.0.gz
|
+---scripts
+---src
|   +---main
|   |   +---java
|   |   |   \---com
|   |   |       \---example
|   |   |           \---doctorhunt
|   |   |               |   DoctorHuntApplication.java
|   |   |               |
|   |   |               +---config
|   |   |               |   |   MailConfig.java
|   |   |               |   |
|   |   |               |   \---MailConfig
|   |   |               +---controller
|   |   |               |       AppointmentController.java
|   |   |               |       DiagnosisOfferController.java
|   |   |               |       DoctorController.java
|   |   |               |       HomeController.java
|   |   |               |       MedicalRecordController.java
|   |   |               |       PatientController.java
|   |   |               |       UserController.java
|   |   |               |
|   |   |               +---db
|   |   |               |   \---migration
|   |   |               +---dto
|   |   |               |       MedicalRecordDTO.java
|   |   |               |       PatientDTO.java
|   |   |               |
|   |   |               +---exception
|   |   |               +---model
|   |   |               |       Appointment.java
|   |   |               |       DiagnosisOffer.java
|   |   |               |       Doctor.java
|   |   |               |       MedicalRecord.java
|   |   |               |       Patient.java
|   |   |               |       User.java
|   |   |               |
|   |   |               +---repository
|   |   |               |       AppointmentRepository.java
|   |   |               |       DiagnosisOfferRepository.java
|   |   |               |       DoctorRepository.java
|   |   |               |       MedicalRecordRepository.java
|   |   |               |       PatientRepository.java
|   |   |               |       UserRepository.java
|   |   |               |
|   |   |               +---security
|   |   |               |       SecurityConfig.java
|   |   |               |
|   |   |               +---service
|   |   |               |       EmailService.java
|   |   |               |       JwtService.java
|   |   |               |       PatientService.java
|   |   |               |       UserService.java
|   |   |               |
|   |   |               +---static
|   |   |               +---templates
|   |   |               \---utils
|   |   \---resources
|   |       |   application.properties
|   |       |   application.yml
|   |       |
|   |       \---migration
|   |           \---db
|   |                   V1__create_users_table.sql
|   |                   V2__init.sql
|   |                   V3__Create_doctors_table.sql
|   |                   V4__Create_patients_table.sql
|   |                   V5__Create_doctor_patient_relationship.sql
|   |                   V6__Create_medical_records_table.sql
|   |                   V7__Create_appointments_table.sql
|   |                   V8__Create_diagnosis_offers_table.sql
|   |
|   \---test
|       \---java
|           \---com
|               \---example
|           \---com
|               \---example
|                   \---demo
|                           DemoApplicationTests.java
|
\---targets

D:\Web Development\java-docorhunt>




|           \---com
|               \---example
|                   \---demo
|                           DemoApplicationTests.java
|                   \---demo
|                           DemoApplicationTests.java
|
\---targets

```

- **Main.java**: The entry point of the Java application.
- **Script.groovy**: A Groovy script for dynamic execution.
- **MainTest.java**: Java unit tests for the application.
- **ScriptTest.groovy**: Groovy unit tests for the Groovy scripts.

## How to Run

### Running the Java Application

To run the Java application:

```bash
mvn exec:java
```

Or, using Gradle:

```bash
gradle run
```

### Running the Groovy Script

If you want to run the Groovy script directly, execute:

```bash
groovy src/main/groovy/com/example/Script.groovy
```

Alternatively, if you want to run the Groovy code from within Java, you can use the GroovyShell class like this:

```java
import groovy.lang.GroovyShell;

public class Main {
    public static void main(String[] args) {
        GroovyShell shell = new GroovyShell();
        shell.evaluate(new File("src/main/groovy/com/example/Script.groovy"));
    }
}
```

## Testing

To run unit tests for Java:

```bash
mvn test
```

For Groovy tests:

```bash
groovy -cp src/test/groovy com.example.ScriptTest
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
