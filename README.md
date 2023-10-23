# Ada School CSV Reader Java

Solution to this [repo](https://github.com/ada-school/csv-reader-java).

## Directions

### Part 1: Implementing a CSV Reader with Java:

1. Download, import and run the code of this repository.
2. Open the TODO tab and implement the code required to transform each line in the file into a Product object.
3. Create a class called *ProductsService* and move your code there to store the list of products loaded from the CSV.
4. Override the *toString* method of the *Product* class and run your code to print your products and verify it works as expected.
5. Create an interface to define how other users could use your library.
6. Change your code on the main method to use the interface and preview how your library works.

### Part 2: Using Maven to avoid re-inventing the wheel:

1. Read the following article to understand how to add *Maven* to the Java project
  * <a target="_blank" href="https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html#add_maven_support">Add Maven Support</a>

2. Once your project has the Maven include import the following library into your dependencies:

  * <a target="_blank" href="https://mvnrepository.com/artifact/com.opencsv/opencsv/5.8.0">MVN Repository Open CSV</a>

3. Read the Open CSV documentation to understand how to use the CSV library:
  * <a target="_blank" href="https://opencsv.sourceforge.net/index.html">Open CSV Documentation</a>
4. Modify your code to use the Open CSV library instead of reading and processing line by line.

## Thoughts

- The maven archetypes are outdated when you create new projects in VS Code.  Nothing has really changed in years. 
- I always use double so I was surprised to see float in the starter code.  
- Double can be overkill and maybe I should use float more often.  
- Scanner is slower than BufferedReader.  
- I looked into various csv libraries. Deephaven CSV seems like an interesting new library.  Super CSV seems to be slightly outdated. 
- I thought about using different branches or different classes but I decided just to comment out different approaches for right now.  
- When you uncomment any section, you will need to add the imports.  
- You need to add an empty constructor to POJO class for opencsv to parse your csv file.  Otherwise, you will get a csv bean introspection exception.

## Continued Development

- Different classes or branches for different approaches

## Useful Resources

- [Scaler](https://www.scaler.com/topics/java-float-vs-double/) - float vs double
- [YouTube](https://www.youtube.com/watch?v=VX9CwPn-BBE) - Reading and parsing delimited CSV data from a file into an Object in Java
- [Stack Overflow](https://stackoverflow.com/questions/55084846/fastest-way-to-read-a-csv-file-java) - fastest way to read a csv file in java
- [How to do in Java](https://howtodoinjava.com/java/io/parse-csv-files-in-java/) - parse csv files in java
- [YouTube](https://www.youtube.com/watch?v=IDMBEcHGeSU) - Reading a CSV in Java
- [YouTube](https://www.youtube.com/watch?v=nZUgaFSl8lQ) - How to read and process CSV file in Java? (with Streams)
- [mkyong](https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/) - how to read and parse csv file in java
- [Geeks for Geeks](https://www.geeksforgeeks.org/iterate-map-java/) - iterate map java
- [Github](https://nrinaudo.github.io/kantan.csv/error_handling.html) - csv error handling strategies
- [North Concepts](https://northconcepts.com/docs/examples/continue-after-an-error) - continue after an error
- [Stack Overflow](https://stackoverflow.com/questions/28659462/how-to-ignore-exceptions-in-java) - how to ignore exceptions in java
- [Source Forge](https://opencsv.sourceforge.net/#quick_start) - open csv quick start
- [Baeldung](https://www.baeldung.com/opencsv) - opencsv
- [YouTube](https://www.youtube.com/watch?v=1SOKpFVPxLA) - Read CSV with Bean Class Java | CSV Bean Builder in Open CSV| CsvBindByName Open CSV |Opencsv Java
- [Stack Overflow](https://stackoverflow.com/questions/50463948/getting-csvbeanintrospectionexception-while-using-opencsv) - csv bean introspection exception