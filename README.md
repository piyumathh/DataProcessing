## DataProcessing

# Set up

Database.java has the Database class which utilizes a map to store and process data. 

The DBTests.java file contains three unit tests containing the sample code from the assignment pdf.

Junit is needed to run the tests. (Only the tests require any additional setup)
To setup JUnit in IntelliJ,

    File -> Project Structure -> Modules -> Dependencies -> "+" icon -> Library -> From Maven -> copy and paste "org.junit.jupiter:junit-jupiter-api:5.0.0" (or later version) -> ok

I haven't used other IDEs myself, but this should help for VSCode
    https://stackoverflow.com/questions/60961140/how-i-can-install-junit-5-on-vscode

# Suggestions

- Clarifying the instructions a bit could help. I assumed I wasn't expected to implement the second portion of the sample code, except for my own testing purposes. 
- So I took the opportunity to write some unit tests with them. 
- Further methods for data processing could make this a more challenging assignment as well, as a map data structure already had most of them. 
