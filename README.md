# Customer Account Management System (CAMS) CLI Application

This is a Java-based command-line interface (CLI) application for a banking system that manages customers and accounts, calculates liquidity positions, classifies accounts into tiers, and outputs data in JSON format.

---

## 📅 System Requirements & Runtime Tools

To build and run this application, you need the following tools:

*   **Java Development Kit (JDK):** Version **25** (OpenJDK 25 or newer is recommended and configured in the project).
*   **Build Tool:** **Apache Maven 3.9+** (or use the included Maven wrapper `./mvnw` / `mvn`).
*   **Operating System:** macOS, Linux, or Windows.

---

## 🚀 How to Build and Run

### 1. Build the Executable Artifact
The project is configured to use the `maven-shade-plugin` to compile and package the application into a single executable fat JAR file.

Run the following command in the project root directory:
```bash
mvn clean package
```
This generates the executable JAR in the `target/` directory:
*   `target/cams-cli-app-1.0-SNAPSHOT.jar`

### 2. Run the Application

The application supports both **Interactive Mode** and **Command-Line Arguments Mode**.

#### A. Interactive Mode (Menu-driven)
Run the executable JAR without arguments to start the interactive console:
```bash
java -jar target/cams-cli-app-1.0-SNAPSHOT.jar
```
This opens the menu-driven CLI:
```text
==================================================
     Customer Account Management System (CAMS)    
==================================================
1. Display All Accounts (Sorted by Balance Desc)
2. Display Platinum Tier Accounts Only
3. Exit
==================================================
Enter your choice (1-3): 
```

#### B. Command-Line Arguments Mode
You can query lists directly by passing commands to bypass the interactive menu:

*   **To display all accounts** (sorted by balance descending, with the bank's liquidity position at the bottom):
    ```bash
    java -jar target/cams-cli-app-1.0-SNAPSHOT.jar all
    ```
*   **To display only Platinum tier accounts**:
    ```bash
    java -jar target/cams-cli-app-1.0-SNAPSHOT.jar platinum
    ```