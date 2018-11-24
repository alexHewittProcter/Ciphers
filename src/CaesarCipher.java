public class CaesarCipher extends Cipher {


    public CaesarCipher(String sourceFile, String targetFile) {
        this.sourceFile = sourceFile;
        this.targetFile = targetFile;
        readSourceFile();
        decrypt();
        writeTargetFile();
    }





    @Override
    public void decrypt() {
        frequencyDistributon();
        //System.out.println(findPosition("E"));
        //System.out.println(findMaxFreqDistribution());
        int shift = findMaxFreqDistribution() - findPosition("E");
        System.out.println(shift);
        String[] sourceLetters = sourceString.split("");
        sourceString = "";
        int length = 0;
        if(sourceLetters.length > 30) {
            length = 30;
        } else {
            length = sourceLetters.length;
        }
        for(int i =0; i < length;i++) {
            int letterPositionShift = (findPosition(sourceLetters[i]) - shift)+26;
            //System.out.println(letterPositionShift);
            int decrpyLetterPosition = letterPositionShift%26;
            //System.out.println(decrpyLetterPosition);
            sourceString = sourceString + alphabet[decrpyLetterPosition];
        }
    }
}
