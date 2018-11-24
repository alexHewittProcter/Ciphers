import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Cipher {
    String sourceFile = "";

    String targetFile = "";

    String sourceString = "";

    public static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String[] alphabet = letters.split("");

    public int[] freqDistribution = new int[26];


    public void decrypt() {

    }

    public void readSourceFile() {
        File file = new File(sourceFile);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String st;
            int line = 1;
            while ((st = bufferedReader.readLine()) != null) {
                sourceString = sourceString + st;
                System.out.println(st);
                //System.out.println(line);
                line++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeTargetFile() {
        //System.out.println(sourceString);
        File file = new File(targetFile);
        try {
            if(file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File not created");
            }

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(sourceString);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int findPosition(String letter) {
        for(int i =0; i < alphabet.length;i++) {
            if(letter.equals(alphabet[i])) {
                return i;
            }
        }
        if(letter.contains("|")) {
            return 26;
        }
        return -1;
    }

    public void frequencyDistributon() {
        String[] sourceLetters = sourceString.split("");
        for(int i =0; i < sourceLetters.length;i++) {
            freqDistribution[findPosition(sourceLetters[i])]++;
        }
    }

    public int findMaxFreqDistribution() {
        int max = 0;
        for(int i =0; i < freqDistribution.length;i++) {
            if(max < freqDistribution[i]) {
                max = freqDistribution[i];
            }
        }
        for(int i =0; i < freqDistribution.length; i++) {
            if(freqDistribution[i] == max) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args){
        //new CaesarCipher("sourceFiles/cexercise1.txt","targetFiles/exercise1.txt");
        //new VigenereCipher("sourceFiles/cexercise2.txt","targetFiles/exercise2.txt","TESSOFTHEDURBERVILLES");
        //new VigenereCipher("sourceFiles/cexercise3.txt","targetFiles/exercise3.txt");
        //new VigenereCipher("sourceFiles/cexercise4.txt","targetFiles/exercise4.txt");
        //new TranspositionCipher("sourceFiles/cexercise5.txt","targetFiles/exercise5.txt",4,6);
        //new TranspositionCipher("sourceFiles/cexercise6.txt","targetFiles/exercise6.txt",6);
        GeneralSubstitutionCipher cipher = new GeneralSubstitutionCipher("sourceFiles/cexercise7.txt","targetFiles/exercise7.txt");
        ArrayList<String> aOptions = new ArrayList<String>();
        aOptions.add("U");
        aOptions.add("W");
        ArrayList<String> bOptions = new ArrayList<String>();
        bOptions.add("Q");
        bOptions.add("Z");
        ArrayList<String> cOptions = new ArrayList<String>();
        cOptions.add("X");
        cOptions.add("K");
        ArrayList<String> dOptions = new ArrayList<String>();
        dOptions.add("O");
        dOptions.add("H");
        ArrayList<String> eOptions = new ArrayList<String>();
        eOptions.add("Y");
        eOptions.add("P");
        ArrayList<String> fOptions = new ArrayList<String>();
        fOptions.add("T");
        fOptions.add("A");
        ArrayList<String> gOptions = new ArrayList<String>();
        gOptions.add("T");
        gOptions.add("A");
        ArrayList<String> hOptions = new ArrayList<String>();
        hOptions.add("U");
        hOptions.add("W");
        ArrayList<String> iOptions = new ArrayList<String>();
        iOptions.add("D");
        iOptions.add("R");
        ArrayList<String> jOptions = new ArrayList<String>();
        jOptions.add("Y");
        jOptions.add("P");
        ArrayList<String> kOptions = new ArrayList<String>();
        kOptions.add("O");
        kOptions.add("H");
        ArrayList<String> lOptions = new ArrayList<String>();
        lOptions.add("L");
        lOptions.add("A");
        ArrayList<String> mOptions = new ArrayList<String>();
        mOptions.add("L");
        mOptions.add("V");
        ArrayList<String> nOptions = new ArrayList<String>();
        nOptions.add("Z");
        ArrayList<String> oOptions = new ArrayList<String>();
        oOptions.add("B");
        oOptions.add("V");
        ArrayList<String> pOptions = new ArrayList<String>();
        pOptions.add("Z");
        ArrayList<String> qOptions = new ArrayList<String>();
        qOptions.add("C");
        qOptions.add("F");
        ArrayList<String> rOptions = new ArrayList<String>();
        rOptions.add("B");
        rOptions.add("V");
        ArrayList<String> sOptions = new ArrayList<String>();
        sOptions.add("E");
        sOptions.add("T");
        ArrayList<String> tOptions = new ArrayList<String>();
        tOptions.add("T");
        tOptions.add("A");
        ArrayList<String> uOptions = new ArrayList<String>();
        uOptions.add("U");
        uOptions.add("W");
        ArrayList<String> vOptions = new ArrayList<String>();
        vOptions.add("E");
        vOptions.add("|");
        ArrayList<String> wOptions = new ArrayList<String>();
        wOptions.add("R");
        wOptions.add("D");
        ArrayList<String> xOptions = new ArrayList<String>();
        xOptions.add("K");
        xOptions.add("X");
        ArrayList<String> yOptions = new ArrayList<String>();
        yOptions.add("S");
        yOptions.add("R");
        ArrayList<String> zOptions = new ArrayList<String>();
        zOptions.add("N");
        zOptions.add("I");
        ArrayList<String> spaceOptions = new ArrayList<String>();
        spaceOptions.add("G");
        spaceOptions.add("Y");
        int iterations = 0;
        for (int a = 0; a < aOptions.size(); a++) {
            System.out.println("A changed");
            for (int b = 0; b < bOptions.size(); b++) {
                System.out.println("B changed");
                for (int c = 0; c < cOptions.size(); c++) {
                    System.out.println("C changed");
                    for (int d = 0; d <dOptions.size(); d++) {
                        System.out.println("D changed");
                        for (int e = 0; e < eOptions.size(); e++) {
                            System.out.println("E changed");
                            for (int f = 0; f < fOptions.size(); f++) {
                                System.out.println("F changed");
                                for (int g = 0; g < gOptions.size(); g++) {
                                    System.out.println("G changed");
                                    for (int h = 0; h < hOptions.size(); h++) {

                                        for (int i = 0; i < iOptions.size(); i++) {
                                            for (int j = 0; j < jOptions.size(); j++) {
                                                for (int k = 0; k < kOptions.size(); k++) {
                                                    for (int l = 0; l < lOptions.size(); l++) {
                                                        for (int m = 0; m < mOptions.size(); m++) {
                                                            for (int n = 0; n < nOptions.size(); n++) {
                                                                for (int o = 0; o < oOptions.size(); o++) {
                                                                    for (int p = 0; p < pOptions.size(); p++) {
                                                                        for (int q = 0; q < qOptions.size(); q++) {
                                                                            for (int r = 0; r < rOptions.size(); r++) {
                                                                                for (int s = 0; s < sOptions.size(); s++) {
                                                                                    for (int t = 0; t < tOptions.size(); t++) {
                                                                                        for (int u = 0; u < uOptions.size(); u++) {
                                                                                            for (int v = 0; v < vOptions.size(); v++) {
                                                                                                for (int w = 0; w < wOptions.size(); w++) {
                                                                                                    for (int x = 0; x < xOptions.size(); x++) {
                                                                                                        for (int y = 0; y < yOptions.size(); y++) {
                                                                                                            for (int z = 0; z < zOptions.size(); z++) {
                                                                                                                for (int space = 0; space < spaceOptions.size(); space++) {
                                                                                                                    if(iterations %1000 == 0) {
                                                                                                                        System.out.println("Iterations " + String.format("%,8d%n",iterations));
                                                                                                                    }
                                                                                                                    cipher.changeShift(aOptions.get(a) + bOptions.get(b) + cOptions.get(c) + dOptions.get(d) + eOptions.get(e) + fOptions.get(f) + gOptions.get(g) + hOptions.get(h) + iOptions.get(i) + jOptions.get(j) + kOptions.get(k) + lOptions.get(l) + mOptions.get(m) + nOptions.get(n) + oOptions.get(o) + pOptions.get(p) + qOptions.get(q) + rOptions.get(r) + sOptions.get(s) + tOptions.get(t) + uOptions.get(u) + vOptions.get(v) + wOptions.get(w) + xOptions.get(x) + yOptions.get(y) + zOptions.get(z) + spaceOptions.get(space));
                                                                                                                    iterations++;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cipher.highestFinalString);

    }

}
