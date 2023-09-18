import java.math.BigDecimal;
import java.util.Scanner;

public class EnterData {
    public static int enterGuest(Integer countInCheck){
        int person;
        while (true) {

            System.out.println("Введите гостя: ");
            try {
                Scanner scanner = new Scanner(System.in);
                person = scanner.nextInt();
                if ((person > 0)&&(person<=countInCheck)) {
                    break;
                }
            } catch (Exception ex) {
            }
            System.out.println("Введите число от 1 до "+countInCheck);
        }
        return person;
    }

    public static BigDecimal enterPrice(){
        BigDecimal price;
        String readLine;
        while (true) {
            System.out.println("Введите цену блюда: ");
            try {
                Scanner scanner = new Scanner(System.in);
                readLine = scanner.nextLine();
                if(readLine.trim().length()-readLine.trim().indexOf(".")<=3||readLine.trim().indexOf(".")==-1) {
                    price = new BigDecimal(readLine);
                    //Предыдущее условие >= соответствовало критериям задачи, стоимость не могла быть отрицательной, в данном случае она не может быть и нулевой,
                    //хотя вполне могут быть подарки от заведения, акции или просто замена блюда.
                    if(price.compareTo(BigDecimal.ZERO)>0){
                        break;
                    }
                }
            } catch (Exception ex) {
            }
            System.out.println("Введена некорректная цена");
        }
        return price;
    }

    public static String enterDish(){
        String nameDish;
        //Ввод наименования блюда
        while(true) {
            System.out.println("Введите наименование блюда: ");
            Scanner scanner = new Scanner(System.in);
            nameDish = scanner.nextLine();
            if(nameDish.length()>0){
                break;
            }
        }
        return nameDish;
    }

    public static Integer enterCountOfGuests(){
        Integer countPerson;
        while (true) {

            System.out.println("Введите количество гостей (> 1): ");
            try {
                Scanner scanner = new Scanner(System.in);
                countPerson = scanner.nextInt();
                if (countPerson > 1) {
                    break;
                }else {
                    System.out.println("Ошибка: Введено число не удовлетворяющее требованиям!");
                }
            } catch (Exception ex) {
                System.out.println("Ошибка: Введено некорректное значение!");
            }
        }
        return countPerson;
    }
}
