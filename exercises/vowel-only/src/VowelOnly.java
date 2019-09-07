public class VowelOnly {
    public static String vowelOnly(String input){
        String vowel = "aeiou";
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()){
            if (vowel.contains(String.valueOf(ch).toLowerCase())){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
