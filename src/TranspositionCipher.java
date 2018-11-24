import java.util.ArrayList;

public class TranspositionCipher extends Cipher {
    int wordLength = 0;
    int wordLengthMin = 0;
    int wordLengthMax = 0;
    int highestSetOfMatches = 0;
    String matchingString = "";
    ArrayList<String> matchWords = new ArrayList<String>();
    public TranspositionCipher(String sourceFile, String targetFile,int wordLengthMin,int wordLengthMax) {
        this.wordLengthMin = wordLengthMin;
        this.wordLengthMax = wordLengthMax;
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
        addMatchWords();
        readSourceFile();
        decrypt();
        //writeTargetFile();
    }

    public TranspositionCipher(String sourceFile, String targetFile,int wordLength) {
        this.wordLength = wordLength;
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
        addMatchWords();
        readSourceFile();
        decrypt();
        writeTargetFile();
    }

    public void addMatchWords() {
        matchWords.add("ADD");
        matchWords.add("YES");
        matchWords.add("NO");
        matchWords.add("TH");
        matchWords.add("ING");
        matchWords.add("ED");
        matchWords.add("CE");
        matchWords.add("AND");
        matchWords.add("NOT");
        matchWords.add("HER");
        matchWords.add("HIM");
        matchWords.add("HIS");
        matchWords.add("HERS");
        matchWords.add("HE");
        matchWords.add("HER");
        matchWords.add("WAS");
        matchWords.add("THIS");
        matchWords.add("THAN");
        matchWords.add("THERE");
        matchWords.add("WHO");
        matchWords.add("TO");
        matchWords.add("ME");
        matchWords.add("YOU");
        matchWords.add("WHAT");
        matchWords.add("WITH");
    }

    @Override
    public void decrypt() {
        if(wordLength > 0) {
            wordLength(wordLength);
        } else {
            for(int i =wordLengthMin;i<=wordLengthMax;i++){
                wordLength(i);
            }
        }
        System.out.println(matchingString);
        System.out.println(matchingString.substring(0,30));
        sourceString = matchingString.substring(0,30);
    }

    public void wordLength(int length) {
        ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
        for(int i =1; i <=length;i++) {
            usedNumbers.add(i);
            nextNumbers(length,usedNumbers);
            usedNumbers = new ArrayList<Integer>();
        }

    }

    public void nextNumbers(int length, ArrayList<Integer> usedNumbers){
        if(length != usedNumbers.size()) {
            for(int i =1; i<=length;i++) {
                if(!usedNumbers.contains(i)) {
                    ArrayList<Integer> userNumbers2 = (ArrayList<Integer>) usedNumbers.clone();
                    userNumbers2.add(i);
                    nextNumbers(length,userNumbers2);

                }
            }
        } else {
            String combination = "";
            for(int i =0; i < usedNumbers.size();i++) {
                combination += usedNumbers.get(i);
            }
            System.out.println(combination);
            printDecrypted(usedNumbers);
        }
    }



    public void printDecrypted(ArrayList<Integer> combination) {
        String combinationString = "";
        for(int i =0; i < combination.size();i++) {
            combinationString += combination.get(i);
        }
        //System.out.println(combinationString);
        //Split the source String into multiple
        int wordLength = combination.size();
        String[] columns = new String[wordLength];
        for(int i =0; i <columns.length;i++) {
            columns[i] = "";
        }
        String[] sourceLetters = sourceString.split("");
        for(int i=0; i< wordLength;i++) {
            for(int j =0;j < sourceLetters.length/wordLength;j++) {
                columns[i] = columns[i] + sourceLetters[(i*sourceLetters.length/wordLength) + j];
            }

        }

        //Print out columns
        for(int i =0; i<columns.length;i++) {
            //System.out.println(columns[i]);
        }
        String finalString = "";
        String letters = "";
        for(int j=0;j< sourceLetters.length/wordLength;j++) {
            for (int i = 0; i < columns.length; i++) {
                letters = columns[combination.get(i) - 1].substring(j,j +1);
                finalString += letters;
            }
        }

        int matches = 0;
        //Find matching words in string
        for(int i =0; i < matchWords.size();i++) {
            if(finalString.contains(matchWords.get(i))) {
                matches++;
            }
        }

        if(matches > highestSetOfMatches) {
            System.out.println("Match changed");
            highestSetOfMatches = matches;
            matchingString = finalString;
        }
        System.out.println(finalString.substring(0,30));

    }
}
