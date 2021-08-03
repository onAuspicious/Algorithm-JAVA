package problems;

import java.util.HashMap;

public class PhoneNumberList {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> hashOfPhoneBook = new HashMap<>();
        String tmp = "";
        for (String s : phone_book) {
            hashOfPhoneBook.put(s, true);
        }

        for (String s : phone_book) {

            for (int i = 0; i < s.length(); i++){
                tmp += s.charAt(i);
                if (hashOfPhoneBook.containsKey(tmp) && i != s.length()-1) {
                    return false;
                }
            }
            tmp = "";
        }
        return true;
    }

    public static void main(String[] args) {
        String[] phoneBook = {"119", "97674223", "1195524421"};
        PhoneNumberList phoneNumberList = new PhoneNumberList();
        System.out.println(phoneNumberList.solution(phoneBook));
    }
}
