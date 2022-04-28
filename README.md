src/main/java coverage: 77%

# Record Collection: A CRUD-Based Web Application

A full-stack web application with a multi-tier architecture. The user can create, read, update and delete entries from the relational database containing the records.

## Getting Started

These instructions will allow you to host a copy of the project on your own machine for development and testing purposes.

### Prerequisites

#### Java

You can use the following link to [download the JDK](https://www.oracle.com/java/technologies/downloads/)  
Click the download link that corresponds to your operating system  
```e.g. jdk-18_windows-x64_bin.exe```

Run the installer with admin privileges and follow the instructions.  
Check if the installer set the PATH variable for you, as JDK15+ should do this automatically.  

If you need to set the PATH variable, press the windows key and search for **Environment Variables**.  
Click on the shortcut to the control panel with the title "Edit the system environment variables".  
Add the location of the JDK installation to the **System variables** section with the name "JAVE_HOME".  
This will typically be:  
```C:\Program Files\Java\jdk-18```

You will then need to open the variable named "Path", and add a new variable with the location of the JDK bin.  
```e.g. %JAVA_HOME%\bin```

To verify your JDK installation, launch a command prompt window and type:  
```java -version```

#### Maven

You can use the following link to [download Maven](https://maven.apache.org/download.cgi)  
Under "Files", click the download for the Binary zip archive.  
```e.g. apache-maven-3.8.5-bin.zip```

Once the download has completed, extract the .zip into your Program Files folder.  
```C:\Program Files\```

You will need to set the PATH variable for Maven.  
Press the windows key and search for **Environment Variables**.  
Click on the shortcut to the control panel with the title "Edit the system environment variables".  
Add the location of the Maven installation to the **System variables** section with the name "M2_HOME".  
This will typically be:  
```C:\Program Files\apache-maven-3.8.5```

You will then need to open the variable named "Path", and add a new variable with the location of the Maven bin.  
```e.g. %M2_HOME%\bin```

To verify your Maven installation, launch a command prompt window and type:  
```mvn -version```

#### Eclipse

You can use the following link to [download Eclipse](https://www.eclipse.org/downloads/)  
Download the x86_64 executable.  
Once the downlaod has completed, run the .exe and complete the setup wizard to install Eclipse, default/java options will be adequate.

#### Spring Boot

Once you have installed Eclipse, you can navigate to *Help > Eclipse Marketplace...*  
Use the search bar at the top to find "Spring Tools 4 (aka Spring Tool Suite 4)"  
Click on the Install button on the right hand side.  
Confirm the selected features.  
Accept the license agreement and then click Finish.

#### MySQL Server

You can use the following link to [download MySQL](https://dev.mysql.com/downloads/windows/installer/8.0.html)  
Download *mysql-installer-community-8.0.29.0.msi*  
Complete the setup wizard, making sure to select MySQL server.  
All default options are okay, with a default password of **root** for the server.

## Installing

### Clone the project from GitHub

Use the following command to clone this repository to your local machine:  
```git clone git@github.com:RyanS186/BAE14_ProjectOne.git```

### Import the project in to Eclipse

In Eclipse, choose *File > Import*  
Expand the **Maven** folder and select **Existing Maven Projects**.  
Select the cloned repository as the root directory.  
Ensure the pom.xml file is visible and selected, then click Import.

### Run the application

To run the application from Eclipse, right click on the project folder in the package explorer and click *Run as > Spring Boot App*  

You can now launch the index.html file contained within the project:  
```src/main/resources/static/html/index.html```  
This will allow you to interact with the application.  

## Testing

To run all tests on the system, right click on the project in the package explorer and click *Run as > JUnit Test*

### Unit Tests

Each of the unit tests can be run individually.

For example, to test only the functionality of the RecordsController class:  
Browse to the *src/test/java/com.qa.baespring.controller* package using the package explorer.  
Locate the *RecordsControllerUnitTest* file and *Right click > Run as > JUnit Test*  
This will unit test the Records Controller class in isolation, by testing each method functions correctly.

## Project Management Board

[Jira Board](https://ryansharp-qa.atlassian.net/jira/software/projects/BAE1/boards/1)

## Built with

[Maven](https://maven.apache.org/) - Dependecy Management

## Author

[Ryan Sharp](https://github.com/RyanS186)
