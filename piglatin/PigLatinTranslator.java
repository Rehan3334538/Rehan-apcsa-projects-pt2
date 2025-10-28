private static String translateWord(String word) {
    if (word.isEmpty()) return "";

    // Separate punctuation at the end
    String punctuation = "";
    int len = word.length();
    while (len > 0 && !Character.isLetterOrDigit(word.charAt(len - 1))) {
        punctuation = word.charAt(len - 1) + punctuation;
        len--;
    }
    String coreWord = word.substring(0, len);

    // Hyphenated words
    if (coreWord.contains("-")) {
        String[] parts = coreWord.split("-");
        StringBuilder hyphenResult = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            hyphenResult.append(translateWord(parts[i]));
            if (i < parts.length - 1) hyphenResult.append("-");
        }
        return hyphenResult.toString() + punctuation;
    }

    if (coreWord.isEmpty()) return punctuation;

    // Remember capitalization of each letter
    boolean[] upperFlags = new boolean[coreWord.length()];
    for (int i = 0; i < coreWord.length(); i++) {
        upperFlags[i] = Character.isUpperCase(coreWord.charAt(i));
    }

    // Find leading consonant cluster
    int firstVowelIndex = 0;
    while (firstVowelIndex < coreWord.length() &&
            "aeiouAEIOU".indexOf(coreWord.charAt(firstVowelIndex)) == -1) {
        firstVowelIndex++;
    }

    String translated;
    if (firstVowelIndex == 0) {
        translated = coreWord + "ay";
    } else {
        String consonantCluster = coreWord.substring(0, firstVowelIndex);
        String rest = coreWord.substring(firstVowelIndex);
        translated = rest + consonantCluster + "ay";
    }

    // Restore capitalization pattern
    char[] resultChars = translated.toCharArray();
    for (int i = 0; i < resultChars.length; i++) {
        if (i < coreWord.length()) {
            if (upperFlags[(i + firstVowelIndex) % coreWord.length()]) {
                resultChars[i] = Character.toUpperCase(resultChars[i]);
            } else {
                resultChars[i] = Character.toLowerCase(resultChars[i]);
            }
        } else {
            resultChars[i] = Character.toLowerCase(resultChars[i]);
        }
    }

    return new String(resultChars) + punctuation;
}
