public class CreditCardValidator {

    public boolean validate(String creditCardNumber) {
        if(!(creditCardNumber.matches("^[0-9]+$"))){
            return false;
        }

        if(creditCardNumber.length() < 13 || creditCardNumber.length() > 16) {
            return false;
        }

        if(!(creditCardNumber.startsWith("4") ||
                creditCardNumber.startsWith("5") ||
                creditCardNumber.startsWith("37") ||
                creditCardNumber.startsWith("6"))) {
            return false;
        }

        var reversed = new StringBuilder((creditCardNumber)).reverse().toString();
        int sum = calculateSum(reversed);

        return sum % 10 == 0;
    }

    private int calculateSum(String reversed) {
        var sum = 0;
        for(int i = 0; i < reversed.length(); i++){
            var number = Character.getNumericValue(reversed.charAt(i));

            if((i + 1) % 2 == 0) {
                var doubled = number * 2;
                if (doubled >= 10) {
                    sum += (doubled % 10) + 1;
                } else {
                    sum += doubled;
                }
            } else {
                sum += number;
            }
        }
        return sum;
    }
}
