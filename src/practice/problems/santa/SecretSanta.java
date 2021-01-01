package practice.problems.santa;

import java.util.ArrayList;
import java.util.Collections;

public class SecretSanta {
    public static void main(String[] args){
        ArrayList<String> donor = new ArrayList<String>();
        donor.add("samik");
        donor.add("arindom");
        donor.add("som");
        donor.add("rajesh");
        donor.add("santosh");
        ArrayList<String> receiver = (ArrayList<String>) donor.clone();

        Collections.shuffle(donor);
        for (int i = 0; i < donor.size(); i++) {
            Collections.shuffle(receiver);
            int target = 0;
            if(receiver.get(target).equals(donor.get(i))){
                target++;
            }
            System.out.println(donor.get(i) + " => " + receiver.get(target));
            receiver.remove(receiver.get(target));
        }
    }
}
