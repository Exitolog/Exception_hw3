import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Controller {

    private String prompt;

    public Controller() {
        System.out.println("Формат данных через пробел: Фамилия Имя Отчество дата _ рождения номер _ телефона пол");
        prompt = prompt("Введите данные: ");
        ValidFacade check = new ValidFacade(prompt);
        if (check.validAll()) {
            writeFile(prompt.split("\\s"));
        }
    }

    public void writeFile(String[] arr) {
        try (Writer writer = new FileWriter(arr[0], true)) {
            writer.write(Arrays.toString(arr) + "\n");
        } catch (IOException e) {
            System.out.println("Invalid fileName");
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        String result = in.nextLine();
        checkLength(result);
        checkNull(result);
        return result;
    }

        private void checkNull (String str){
            try {
                if (str.isEmpty()) {
                    System.err.println("You haven't entered anything");
                    throw new NullPointerException();
                }
            } catch (NullPointerException e) {
                throw new NullPointerException("Вы ничего не ввели, попробуйте еще раз");
            }
        }

        private void checkLength (String str){
            try {
                int temp = Integer.compare(str.split("\\s").length, 6);
                if (temp < 0) {
                    //Вы ввели не все данные
                    throw new RuntimeException("You have not entered all the data");
                }
                if (temp > 0) {
                    //Вы ввели лишние данные
                    throw new RuntimeException("You have entered unnecessary data");
                }
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }
    }
