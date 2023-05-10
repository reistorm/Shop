package View.ConsoleView.ConsoleViewBasic;

import java.util.Scanner;

public class Utilities {
    Scanner scanner;
    TextMenu menu;

    public Utilities(){
        this.scanner = new Scanner(System.in, "Cp866");
        menu = new TextMenu();
    }
    
    public int inputInt(){
        int num;
        try
        {
            num = Integer.valueOf(scanner.next());
        }
        catch (Exception e)
        {
            num = -1;
        }
        return num;
    }

    public String inputString(){
        String answer;
        try
        {
            answer = scanner.next();
        }
        catch (Exception e)
        {
            answer = "";
        }
        return answer;
    }

    public int getPositiveIntAnswer(String request, int min, int max){
        showText(request);
        int answer = inputInt();
        if (answer < min || answer > max){
            showText(menu.errorText);
            return -1;
        }
        return answer;
    }



    public void showText(String text){
        System.out.println(text);
    }

    public void preview(String name, int count, int weight){
        String text = "Название: " + name + "\n"
                    + "Количество: " + Integer.toString(count) + "\n"
                    + "Вес вероятности выпадения в %: " + Integer.toString(weight) + "\n";
        showText(text);
    }


    public boolean checkMenu(){
        int answer;
        while (true) {
            showText(menu.checkMenu);
            answer = inputInt();
            switch (answer) {
                case 1:
                    return true;
                case 0:
                    return false;
                default:
                    showText(menu.errorText);
                    break;
            }   
        }
    }

    public void requestToContinue(String request){
        showText(request);
        showText(menu.requestToContinue);
        inputString();
    }
}