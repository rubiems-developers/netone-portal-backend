package zw.co.rubiem.netone.portal.commons.demographics;

import zw.co.rubiem.netone.portal.commons.exceptions.InvalidPhoneNumberException;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable
@Table(uniqueConstraints = @UniqueConstraint(name = "ux_phone", columnNames = {"operator_code", "number", "country_code"}))
public class PhoneNumber {

    @Column(name = "phone_country_code", nullable = false, length = 5)
    private String phoneCountryCode;

    @Column(name = "operator_code", nullable = false, length = 3)
    private String operatorCode;

    @Column(nullable = false, length = 7)
    private String number;

    public static PhoneNumber of(String suppliedPhoneNumber) {
        String verifiedNumber = getVerifiedPhoneNumber(suppliedPhoneNumber);
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneCountryCode(verifiedNumber.substring(0, 4));
        phoneNumber.setOperatorCode(verifiedNumber.substring(4, 7));
        phoneNumber.setNumber(verifiedNumber.substring(7));
        return phoneNumber;
    }

    public static String getTenDigitPhoneNumber(String phoneNumber) {
        String verifiedNumber = getVerifiedPhoneNumber(phoneNumber);

        if (verifiedNumber.startsWith("+263"))
            return verifiedNumber.replace("+", "").replaceAll("263", "0");

        if (verifiedNumber.startsWith("263"))
            return verifiedNumber.replaceAll("263", "0");

        else throw new InvalidPhoneNumberException("Phone number supplied is invalid!");

    }

    private static String getVerifiedPhoneNumber(String suppliedPhoneNumber) {

        if (suppliedPhoneNumber.length() < 9 || suppliedPhoneNumber.length() > 14) {
            throw new InvalidPhoneNumberException("Phone number supplied is invalid!");
        }

        int length = suppliedPhoneNumber.length();
        String verifiedNumber = "";
        final String errorMessage = "Phone number pattern is not valid!";
        suppliedPhoneNumber = suppliedPhoneNumber.trim();

        switch (length) {
            case 14: {
                if (isValidPhoneNumber(suppliedPhoneNumber, "^002637[13478][0-9]{7}$")) {
                    String lastDigits = suppliedPhoneNumber.substring(2);
                    verifiedNumber = "+" + lastDigits;
                    return verifiedNumber;
                }
                throw new InvalidPhoneNumberException(errorMessage);
            }
            case 13: {
                if (isValidPhoneNumber(suppliedPhoneNumber.substring(1), "^\\+2637[13478][0-9]{7}$")) {
                    verifiedNumber = suppliedPhoneNumber;
                    return verifiedNumber;
                }
                throw new InvalidPhoneNumberException(errorMessage);
            }
            case 12: {
                if (isValidPhoneNumber(suppliedPhoneNumber, "^2637[13478][0-9]{7}$")) {
                    verifiedNumber = "+" + suppliedPhoneNumber;
                    return verifiedNumber;
                }
                throw new InvalidPhoneNumberException(errorMessage);
            }
            case 10: {
                if (isValidPhoneNumber(suppliedPhoneNumber, "^07[13478][0-9]{7}$")) {
                    String newNumber = suppliedPhoneNumber.substring(1);
                    verifiedNumber = "+263" + newNumber;
                    return verifiedNumber;
                }
                throw new InvalidPhoneNumberException(errorMessage);
            }
            case 9: {

                if (isValidPhoneNumber(suppliedPhoneNumber, "^7[13478][0-9]{7}$")) {
                    verifiedNumber = "+263" + suppliedPhoneNumber;
                    return verifiedNumber;
                }
                throw new InvalidPhoneNumberException(errorMessage);
            }
            default:
                throw new InvalidPhoneNumberException(errorMessage);
        }
    }

    public static boolean isValidPhoneNumber(String str, String regex) {
        if (str == null) {
            return false;
        }
        if (!onlyDigits(str))
            throw new InvalidPhoneNumberException("Phone number contains characters that aren't digits!");
        Pattern p2 = Pattern.compile(regex);
        Matcher m = p2.matcher(str);
        return m.matches();
    }

    public static boolean onlyDigits(String str) {
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        if (str == null) {
            return false;
        }
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    @Override
    public String toString() {
        return phoneCountryCode + operatorCode + number;
    }
}