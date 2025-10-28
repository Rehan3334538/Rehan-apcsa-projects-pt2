package piglatin;

public class PigLatinTranslator {

    // Translate a whole Book
    public static Book translate(Book input) {
        Book translatedBook = new Book();
        translatedBook.setTitle(input.getTitle() + " (Pig Latin)");

        for (int i = 0; i < input.getLineCount(); i++) {
            String line = input.getLine(i);
            translatedBook.appendLine(translate(line));
        }

        return translatedBook;
    }

    // Translate a line or sentence
    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        if (input.trim().isEmpty()) return "";

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

    // Translate a single word to Pig Latin
    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        if (input.isEmpty()) return input;

        // Handle punctuation at the end
        String punctuation = "";
        if (!Character.isLetterOrDigit(input.charAt(input.length() - 1))) {
            punctuation = input.substring(input.length() - 1);
            input = input.substring(0, input.length() - 1);
        }

        // Handle hyphenated words separately
        if (input.contains("-")) {
            String[] parts = input.split("-");
            StringBuilder hyphenResult = new StringBuilder();
            for (int i = 0; i < parts.length; i++) {
                hyphenResult.append(translateWord(parts[i]));
                if (i < parts.length - 1) {
                    hyphenResult.append("-");
                }
            }
            return hyphenResult.toString() + punctuation;
        }

        // Detect capitalization of the first letter
        boolean isCapital = Character.isUpperCase(input.charAt(0));
        String lower = input.toLowerCase();

        String result;
        if ("aeiou".indexOf(lower.charAt(0)) != -1) {
            result = lower + "ay"; // vowel rule
        } else {
            result = lower.substring(1) + lower.charAt(0) + "ay"; // consonant rule
        }

        // Apply capitalization to first letter
        if (isCapital && result.length() > 0) {
            result = Character.toUpperCase(result.charAt(0)) + result.substring(1);
        }

        return result + punctuation;
    }
}
