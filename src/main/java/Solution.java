import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int width = maxWidth;
            List<String> temp = new ArrayList<>();
            int tempLengthsSum = 0;
            while (i < words.length && (width - words[i].length() >= 0 || (temp.isEmpty() && words[i].length() == maxWidth))) {
                temp.add(words[i]);
                tempLengthsSum += words[i].length();
                width = width - words[i].length() - 1;
                i++;

            }
            if (i == words.length){
                StringBuilder lastLine = new StringBuilder(temp.get(0));
                for (int j = 1; j < temp.size(); j++) {
                    lastLine.append(" ").append(temp.get(j));
                }
                while (lastLine.length() != maxWidth){
                    lastLine.append(" ");
                }
                result.add(lastLine.toString());
                return result;
            }
            if (temp.size() == 1) {
                StringBuilder sb = new StringBuilder(temp.get(0));
                while (sb.length() != maxWidth) {
                    sb.append(" ");
                }
                result.add(sb.toString());
            } else if (temp.size() > 1) {
                int spaces = maxWidth - tempLengthsSum;
                String left = temp.get(0);
                String right = temp.get(temp.size() - 1);
                char[] line = new char[maxWidth];
                for (int j = 0; j < left.length(); j++) {
                    line[j] = left.charAt(j);
                }

                for (int j = right.length() - 1, k = line.length - 1; j >= 0; j--, k--) {
                    line[k] = right.charAt(j);
                }
                int numberOfNecessarySpaceSlots = temp.size() - 2 + 1;
                int min = spaces / numberOfNecessarySpaceSlots;
                int[] spacesAfterWords = new int[numberOfNecessarySpaceSlots];
                Arrays.fill(spacesAfterWords, min);
                int leftOverSpaces = spaces % numberOfNecessarySpaceSlots;
                for (int j = 0; leftOverSpaces > 0; j++, leftOverSpaces--) {
                    spacesAfterWords[j]++;
                }
                int s = 0;
                int t = 1;
                for (int j = temp.get(0).length(); j < line.length - temp.get(temp.size() - 1).length(); ) {
                    while (spacesAfterWords[s] != 0) {
                        line[j] = ' ';
                        j++;
                        spacesAfterWords[s]--;
                    }
                    s++;
                    if (t == temp.size() - 1) {
                        break;
                    }

                    for (int k = 0; k < temp.get(t).length(); k++) {
                        line[j] = temp.get(t).charAt(k);
                        j++;
                    }
                    t++;


                }
                result.add(new String(line));

            }
        }
        return result;
    }

}
