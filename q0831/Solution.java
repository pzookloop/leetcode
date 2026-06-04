package q0831;

import java.util.HashMap;

public class Solution {
    public String maskPII(String s) {
//        if (isEmail(s)) {
//            return maskEmail(s);
//        }
//
//        return maskPhoneNumber(s);
        final var at = s.indexOf('@');
        if (at > -1) {
            String emailMask = "*****";
            final var email = s.toLowerCase();
            return email.charAt(0) + emailMask + email.substring(at-1);
        }
        String[] countryMask = {"", "+*-", "+**-", "+***-"};
        String phoneMask = "***-***-";
        final var phoneNumber = s.replaceAll("[^0-9]", "");
        return  countryMask[phoneNumber.length()-10] + phoneMask + phoneNumber.substring(phoneNumber.length()-4);
    }

    private String maskPhoneNumber(String s) {
        final var builder = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                builder.append(s.charAt(i));
            }
        }
        String phoneNumberMask = "***-***-";
        final var phoneNumber = phoneNumberMask + builder.substring(builder.length() - 4, builder.length());
        if (builder.length() == 10) {
            return phoneNumber;
        }
        final var countryNumberMaskMap = new HashMap<Integer, String>(){{
            put(1, "+*-");
            put(2, "+**-");
            put(3, "+***-");
        }};

        return countryNumberMaskMap.get(builder.length()-10) + phoneNumber;
    }

    private String maskEmail(String s) {
        String realEmail = s.toLowerCase();
        String mask = "*****";
        final var name = realEmail.split("@")[0];
        final var domainName = realEmail.split("@")[1];
        return name.charAt(0) + mask + name.charAt(name.length()-1) + "@" + domainName;
    }

    private boolean isEmail(String s) {
        return s.contains("@") && s.contains(".");
    }
}
