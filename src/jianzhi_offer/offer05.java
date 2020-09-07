package jianzhi_offer;

public class offer05 {
    public String replaceSpace(String s){
        StringBuilder sb = new StringBuilder();
        for(Character c:s.toCharArray()){
            if(c == ' '){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
