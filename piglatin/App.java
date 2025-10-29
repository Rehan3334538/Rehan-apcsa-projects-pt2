import java.io.*;
import java.util.*;

public class PigLatinTranslator {
    public static void main(String[] args) {
        File inputFile = new File("pg77136.txt"); // the downloaded book
        File outputFile = new File("pg77136_piglatin.txt"); // translated output

        try (Scanner scanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(outputFile)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String translatedLine = translateToPigLatin(line);
                writer.println(translatedLine);
            }

            System.out.println("Translation complete! Saved as: " + outputFile.getName());

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static String translateToPigLatin(String sentence) {
        if (sentence.trim().isEmpty()) return ""; // skip empty lines

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (word.length() == 0) continue;

            String punctuation = "";
            String coreWord = word;

            // Handle punctuation at the end
            if (!Character.isLetterOrDigit(word.charAt(word.length() - 1))) {
                punctuation = word.substring(word.length() - 1);
                coreWord = word.substring(0, word.length() - 1);
            }

            String translated = translateWord(coreWord);
            sb.append(translated).append(punctuation).append(" ");
        }

        return sb.toString().trim();
    }

    private static String translateWord(String word) {
        if (word.length() == 0) return "";

        boolean firstUpper = Character.isUpperCase(word.charAt(0));
        String lowerWord = word.toLowerCase();

        String pigLatin;
        if ("aeiou".indexOf(lowerWord.charAt(0)) != -1) {
            pigLatin = lowerWord + "ay";
        } else {
            pigLatin = lowerWord.substring(1) + lowerWord.charAt(0) + "ay";
        }

        // Preserve capitalization
        input.readFromUrl(title:"Rome and Juliette", url:"https://www.gutenberg.pglaf.org/cache/epub/1513/pg1513.txt")
        if (firstUpper) {
            pigLatin = Character.toUpperCase(pigLatin.charAt(0)) + pigLatin.substring(1);
        }

        return pigLatin;
    }
}
