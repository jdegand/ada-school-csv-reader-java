package com.example;

import java.io.FileReader;
import java.io.FileNotFoundException;

import java.util.List;

import com.example.model.Product;
import com.opencsv.bean.CsvToBeanBuilder;

/*  

// this is the code provided to get you started

public class App {
    public static void main(String[] args) {
        try {
            File file = new File("resources/inventory.csv");
            Scanner fileScanner = new Scanner(file);
            fileScanner.nextLine();
            // Not really a fan of doing this separately to skip the header
            // better to have the logic bound together using readLine and skip ?
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productInfo = line.split(",");
                System.out.println(productInfo[0]);
                System.out.println(line);
                // implement the logic to transform this code so it can convert the
                // information in each line into a Product object
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
*/

/* 
public class App {
    public static void main(String[] args) {
        List<Product> result = new ArrayList<>();

        try {
            File file = new File("resources/inventory.csv");
            Scanner fileScanner = new Scanner(file);
            fileScanner.nextLine();
            // Not really a fan of doing this separately to skip the header
            // better to have the logic bound together using readLine and skip ?
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] productInfo = line.split(",");
                // System.out.println(productInfo[0]);
                // System.out.println(line);
                // implement the logic to transform this code so it can convert the
                // information in each line into a Product object

                try {
                    Product product = new Product(productInfo[0], productInfo[1], productInfo[2], productInfo[3],
                            Float.parseFloat(productInfo[4]), productInfo[5]);
                    result.add(product);
                } catch (NumberFormatException nfe) {
                    continue;
                } catch (ArrayIndexOutOfBoundsException exception) {
                    continue;
                }
            }
            fileScanner.close(); // need to close the scanner otherwise memory leak
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (Product product : result) {
            System.out.println(product.toString());
        }
    }
}
*/

/* 

// https://mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
// tweaked to remove multi-line functionality 

public class App {
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DOUBLE_QUOTES = '"';
    private static final char DEFAULT_QUOTE_CHAR = DOUBLE_QUOTES;

    public static void main(String[] args) throws Exception {

        File file = new File("resources/inventory.csv");

        App obj = new App();
        List<String[]> result = obj.readFile(file, 1);

        int listIndex = 0;
        for (String[] arrays : result) {
            System.out.println("\nString[" + listIndex++ + "] : " +
                    Arrays.toString(arrays));

            int index = 0;
            for (String array : arrays) {
                System.out.println(index++ + " : " + array);
            }
        }
    }

    public List<String[]> readFile(File csvFile) throws Exception {
        return readFile(csvFile, 0);
    }

    public List<String[]> readFile(File csvFile, int skipLine) throws Exception {

        List<String[]> result = new ArrayList<>();
        int indexLine = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String line;
            while ((line = br.readLine()) != null) {

                if (indexLine++ <= skipLine) {
                    continue;
                }

                String[] csvLineInArray = parseLine(line);

                result.add(csvLineInArray);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String[] parseLine(String line) throws Exception {
        return parseLine(line, DEFAULT_SEPARATOR);
    }

    public String[] parseLine(String line, char separator) throws Exception {
        return parse(line, separator, DEFAULT_QUOTE_CHAR).toArray(String[]::new);
    }

    private List<String> parse(String line, char separator, char quoteChar)
            throws Exception {

        List<String> result = new ArrayList<>();

        boolean inQuotes = false;
        boolean isFieldWithEmbeddedDoubleQuotes = false;

        StringBuilder field = new StringBuilder();

        for (char c : line.toCharArray()) {

            // if / else hell here -> definitely could be improved
            // break out logic into a separate function ?

            if (c == DOUBLE_QUOTES) { // handle embedded double quotes ""
                if (isFieldWithEmbeddedDoubleQuotes) {

                    if (field.length() > 0) { // handle for empty field like "",""
                        field.append(DOUBLE_QUOTES);
                        isFieldWithEmbeddedDoubleQuotes = false;
                    }

                } else {
                    isFieldWithEmbeddedDoubleQuotes = true;
                }
            } else {
                isFieldWithEmbeddedDoubleQuotes = false;
            }

            if (c == quoteChar) {
                inQuotes = !inQuotes;
            } else {
                if (c == separator && !inQuotes) { // if find separator and not in quotes,
                    // add field to the list
                    result.add(field.toString());
                    field.setLength(0); // empty the field and ready for the next
                } else {
                    field.append(c); // else append the char into a field
                }
            }
        }

        result.add(field.toString());
        return result;
    }
}
*/

/* 

// many problems here
// loses order of products
// not really handling missing values

public class App {
    private static Map<String, Product> products = new HashMap<>();

    public static void main(String[] args) throws Exception {
        createproducts();
        print(products);
    }

    private static void createproducts() {

        Path inventoryFilePath = Paths.get("resources/inventory.csv");

        try {

            List<String> inventoryLines = Files.readAllLines(inventoryFilePath);

            int index = 0;

            for (String inventory : inventoryLines) {
                String[] inventoryArray = inventory.split(",");

                // name, description, category, tags, price, urlImage

                if (inventoryArray.length == 6) {

                    String name = inventoryArray[0];
                    String description = inventoryArray[1];
                    String category = inventoryArray[2];
                    String tags = inventoryArray[3];
                    String price = inventoryArray[4];
                    String urlImage = inventoryArray[5];

                    Float floatPrice = (float) 0; // can't initialize without a value

                    // conversions
                    try {
                        floatPrice = Float.parseFloat(price);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    // would need to add empty constructor to Product

                    // Product product = new Product();
                    // product.setName(name);
                    // product.setDescription(description);
                    // product.setCategory(category);
                    // product.setTags(tags);
                    // product.setPrice(floatPrice);
                    // product.setImageUrl(urlImage);

                    Product product = new Product(name, description, category, tags, floatPrice,
                            urlImage);

                    products.put(String.valueOf(index), product);
                    index++;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void print(Map<String, Product> map) {

        // using keySet() for iteration over keys
        for (String name : map.keySet())
            System.out.println("key: " + name);

        // using values() for iteration over values
        for (Product value : map.values())
            System.out.println("value: " + value);
    }
}
*/

/* 
// This works but will fail if any line is incorrectly formed
// It handles NumberFormatException
// Uncomment the limit to see the code actually work before an exception occurs
public class App {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "inventory.csv");

        List<Product> products = Files.lines(path)
                .skip(1)
                // .limit(10)
                .map(App::getProduct)
                .collect(Collectors.toList());

        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    private static Product getProduct(String line) {
        String[] fields = line.split(",");

        if (fields.length != 6) {
            throw new RuntimeException("Invalid CSV line - " + line);
            // System.out.println("Incorrect Format -" + line);
            // comment out the RuntimeException and you get an
            // ArrayIndexOutOfBoundsException that stops execution of whole list
        }

        try {
            return new Product(fields[0], fields[1], fields[2], fields[3],
                    Float.parseFloat(fields[4]), fields[5]);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormat Exception " + line);
            return new Product(fields[0], fields[1], fields[2], fields[3], 0, fields[5]);
        }
    }
}
*/

public class App {
    public static void main(String[] args) {

        try {
            List<Product> products = new CsvToBeanBuilder<Product>(new FileReader("resources/inventory.csv"))
                    .withType(Product.class).build().parse();

            for (Product p : products) {
                System.out.println(p.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}