package piglatin;

public class PigLatinTranslator {

    // ✅ Translate a full Book (line by line)
    public static Book translate(Book input) {
        Book translatedBook = new Book();
        translatedBook.setTitle(input.getTitle() + " (Pig Latin)");

        // Loop through each line of the input book
        for (int i = 0; i < input.getLineCount(); i++) {
            String line = input.getLine(i);
            String translatedLine = translate(line);
            translatedBook.appendLine(translatedLine);
        }

        return translatedBook;
    }

    // ✅ Translate an entire sentence or line of text
    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s+"); // split by whitespace

        for (int i = 0; i < words.length; i++) {
            result.append(translateWord(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    // ✅ Translate a single word to Pig Latin
    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        if (input.isEmpty()) return input;

        // Handle punctuation (e.g., “word,” → “ordway,”)
        String word = input;
        String punctuation = "";
        if (!Character.isLetter(word.charAt(word.length() - 1))) {
            punctuation = word.substring(word.length() - 1);
            word = word.substring(0, word.length() - 1);
        }

        // Check capitalization
        boolean isCapitalized = Character.isUpperCase(word.charAt(0));
        word = word.toLowerCase();

        String result;
        char firstChar = word.charAt(0);

        if ("aeiou".indexOf(firstChar) != -1) {
            // Starts with vowel
            result = word + "yay";
        } else {
            // Starts with consonant(s)
            int vowelIndex = findFirstVowel(word);
            if (vowelIndex == -1) {
                result = word + "ay"; // no vowels
            } else {
                result = word.substring(vowelIndex) + word.substring(0, vowelIndex) + "ay";
            }
        }

        // Restore capitalization
        if (isCapitalized) {
            result = capitalizeFirstLetter(result);
        }

        // Add punctuation back
        return result + punctuation;
    }

    // ✅ Helper: find index of first vowel
    private static int findFirstVowel(String word) {
        String vowels = "aeiou";
        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                return i;
            }
        }
        return -1;
    }

    // ✅ Helper: capitalize first letter
    private static String capitalizeFirstLetter(String input) {
        if (input.isEmpty()) return input;
        return Character.toUpperCase(input.charAt(0)) + input.substring(1);
    }
}
