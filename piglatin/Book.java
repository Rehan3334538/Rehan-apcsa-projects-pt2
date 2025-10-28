package piglatin;

import java.io.*;
import java.net.*;
import java.util.*;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<>();

    // Empty book constructor
    public Book() {}

    // Print lines (for debugging)
    public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    // Getters / setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    public int getLineCount() {
        return text.size();
    }

    public void appendLine(String line) {
        text.add(line);
    }

    // ✅ Reads book text from a String (split by newlines)
    public void readFromString(String title, String string) {
        this.title = title;

        Scanner scanner = new Scanner(string);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            text.add(line);
        }
        scanner.close();
    }

    // ✅ Reads book text from a URL (line by line)
    public void readFromUrl(String title, String url) {
        this.title = title;

        try {
            URL bookUrl = URI.create(url).toURL();
            Scanner scanner = new Scanner(bookUrl.openStream());
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                text.add(line);
            }
            scanner.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // ✅ Writes book to a text file
    public void writeToFile(String name) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(name))) {
            for (String line : text) {
                writer.println(line);
            }
            System.out.println("Book saved to " + name);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
