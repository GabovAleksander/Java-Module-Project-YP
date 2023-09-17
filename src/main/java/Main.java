import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {


    private static String getCurrencyText(BigDecimal price){
        String roundPrice=price.toBigInteger().toString();
        String currency;
        int lastDigit=Integer.parseInt(roundPrice.substring(roundPrice.length()-1));
        if (lastDigit==1){
            currency="рубль";
        }else if (lastDigit==2 || lastDigit==3 || lastDigit==4){
            currency="рубля";
        }else {
            currency="рублей";
        }
        return currency;
    }
    public static void main(String[] args) {

        Check check;
        Integer countPerson;

        NumberFormat nf = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) nf).getDecimalFormatSymbols();
        decimalFormatSymbols.setCurrencySymbol("");
        ((DecimalFormat) nf).setDecimalFormatSymbols(decimalFormatSymbols);


        //Ввод количества гостей
        countPerson= EnterData.enterCountOfGuests();

        //Создаем чек
        check = new Check();
        check.setCountPerson(countPerson);

        while (true){

            String nameDish;
            BigDecimal price;
            Integer person;

            //Ввод названия блюда
            nameDish= EnterData.enterDish();

            //Ввод цены
            price= EnterData.enterPrice();

            //Ввод гостя
            person= EnterData.enterGuest(check.getCountPerson());

            //Приводим к валюте и убираем обозначение валюты
            Position position=new Position(nameDish,price,person);
            check.addPosition(position);



            System.out.println(
                    String.format("Добавленные товары: %s. %-50s  %20s %s  Гость №%s",
                            check.getPositionList().size(), position.getName(), nf.format(price), getCurrencyText(price), position.getGuest()));
            System.out.println("Добавить еще один товар?");
            if(new Scanner(System.in).nextLine().trim().toLowerCase().equals("завершить")){
                break;
            }

        }

        System.out.println("\n\n\n\nЧек:");
        for(int i=1;i<=check.getCountPerson();i++){
            int count=0;
            BigDecimal itog=BigDecimal.ZERO;
            for (Position position:check.getPositionList()
                 ) {
                if (position.getGuest().equals(i)){
                    count++;
                    itog=itog.add(position.getPrice());
                    System.out.println(
                    String.format("%s. %-50.45s  %20s %s",
                            count, position.getName(), nf.format(position.getPrice()), getCurrencyText(position.getPrice())));
                }
            }
            System.out.println(String.format("Итого по  Гость %s :%-35s %20s %s ",i, " ",nf.format(itog),getCurrencyText(itog)));
        }
        System.out.print(String.format("Общий итог: %-42s %20s %s\n\n"," ",nf.format(check.getTotalSum()),getCurrencyText(check.getTotalSum())));

        BigDecimal devidedSum=check.getTotalSum().divide(new BigDecimal(check.getCountPerson()),2,RoundingMode.HALF_UP);
        System.out.println("При делении на всех, каждый должен заплатить: "+nf.format(devidedSum)+getCurrencyText(devidedSum));
    }
}
