import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class GeneralSubstitutionCipher extends Cipher {
    public static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ|";
    public static String[] alphabet = letters.split("");
    double[] freqAnalysisForAlphabet = new double[27];
    int[] shifts = new int[27];
    String finalString = "";
    int highestMatchNumber = 0;
    String highestFinalString = "";
    ArrayList<String> matchWords = new ArrayList<String>();
    public GeneralSubstitutionCipher(String sourceFile, String targetFile) {
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
        readSourceFile();
        //Add frequency analysis data for alphabet
        File file = new File("sourceFiles/tess27.txt");
        String alphabetString = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String st = "";
            while ((st = bufferedReader.readLine()) != null) {
                alphabetString += st;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] tess27 = alphabetString.split("");
        for (int i = 0; i < tess27.length;i++) {
            freqAnalysisForAlphabet[findPosition(tess27[i])]++;
        }
        for(int i=0; i < freqAnalysisForAlphabet.length; i++) {
            freqAnalysisForAlphabet[i] = freqAnalysisForAlphabet[i]/tess27.length;
            System.out.println(alphabet[i] + " " + freqAnalysisForAlphabet[i]);
        }
        addMatchWords();
        decrypt();
        System.out.println(highestFinalString);
        writeTargetFile();
    }

    @Override
    public void decrypt() {
        //To begin find the frequency distribution of the source
        String[] sourceLetters = sourceString.split("");
        double[] frequency = new double[27];
        int position = 0;
        for (int i = 0; i < sourceLetters.length; i++) {
            position = findPosition(sourceLetters[i]);
            //System.out.println(sourceLetters[i] + " " + findPosition(sourceLetters[i]));
            if (position >= 0) {
                frequency[position]++;
            }
        }
        //Turn the numbers into decimals
        for (int i = 0; i < frequency.length; i++) {
            frequency[i] = frequency[i] / (sourceLetters.length);
            System.out.println(alphabet[i] + " " + frequency[i]);
        }
        //Find the closest frequencies and map them
        int shift = 0;
        double freq = 0;
        double highFreq = 1;
        double lowFreq = 0;
        double highDiff = 0;
        double lowDiff = 0;
        int highFreqShift = 0;
        int lowFreqShift = 0;
        String letter = "";
        Double englishFreq = 0.0;
        for (int i = 0; i < frequency.length; i++) {
            letter = alphabet[i];
            freq = frequency[i];
            //Find closest highest
            for (int j = 0; j < freqAnalysisForAlphabet.length; j++) {
                englishFreq = freqAnalysisForAlphabet[j];
                if (englishFreq > freq && englishFreq < highFreq) {
                    highFreq = englishFreq;
                    highFreqShift = j;
                }
                if (englishFreq < freq && englishFreq > lowFreq) {
                    lowFreq = englishFreq;
                    lowFreqShift = j;
                }
            }
            if (highFreq == 1 || lowFreq == 0) {
                if (highFreq == 1) {
                    shifts[i] = lowFreqShift;
                } else {
                    shifts[i] = highFreqShift;
                }
            } else {
                highDiff = highFreq - freq;
                lowDiff = freq - lowFreq;
                //Find the closer frequency
                if (highDiff > lowDiff) {
                    //The lower frequeucy is closer
                    shifts[i] = lowFreqShift;
                } else {
                    //The higher frequency is closer
                    shifts[i] = highFreqShift;
                }
            }
            highFreq = 1;
            lowFreq = 0;

        }
        decryptString();
    }

    public void changeShift(String shiftString) {
        String[] newShifts = shiftString.split("");
        for(int i =0; i < shifts.length;i++) {
            shifts[i] = findPosition(newShifts[i]);
        }
        decryptString();
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

    public void decryptString() {
        String[] sourceLetters = sourceString.split("");
        int position = 0;
        String newString = "";
        for(int i =0; i < alphabet.length;i++) {
            //System.out.println(alphabet[i] + " - " + alphabet[shifts[i]]);
        }
        newString = "";
        for(int i=0; i < sourceLetters.length;i++) {
            position = findPosition(sourceLetters[i]);
            if(position >=0) {
                newString = newString + alphabet[shifts[position]];
            } else {
                newString = newString + "|";
            }
        }
        int localMatches = 0;
        for(int i=0;i<matchWords.size();i++) {
            if(newString.contains(matchWords.get(i))) {
                localMatches++;
            }
        }
        if(localMatches > highestMatchNumber) {
            System.out.println(newString);
            highestFinalString = newString;
            highestMatchNumber = localMatches;
        }
        //System.out.println(newString);

    }
}
