import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;

public class Valid implements Validable {

    private static final DateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    private String[] arr;

    public Valid(String[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean validStr() {
        try {
            for (int i = 0; i < 3; i++) {
                String string = arr[i];
                if (!string.matches("[a-zA-Z]+")) {
                    //Вы ввели невалидные данные
                    throw new RuntimeException("You have entered invalid data");
                }
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean validDate() {
        try {
            String date = arr[3];
            FORMAT.setLenient(false);
            FORMAT.parse(date);
            if (Integer.parseInt(date.split("\\.")[2]) > Year.now().getValue()) {
                throw new ParseException("The year cannot be greater than the current one", Year.now().getValue());
                //Год не может быть больше текущего
            }
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            //Вы ввели невалидные данные
            return false;
        }
        return true;
    }

    @Override
    public boolean validNumber() {
        try {
            if (!arr[arr.length - 2].matches("\\d+")) {
                //Номер телефона должен содержать только цифры
                throw new RuntimeException("The phone number must contain only numbers");
            }
            return true;
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean validSexual() {
        String sex = arr[arr.length - 1];
        try {
            if (!sex.matches("[fmFM]")) {
                //Вы ввели невалидные данные
                throw new RuntimeException("You have entered invalid data");
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
}
