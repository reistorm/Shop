package View.ConsoleView.ConsoleViewBasic;

import Controller.Interfaces.Controller;
import View.ConsoleView.Interfaces.ConsoleAddMenu;


public class ConsoleAddMenuBasic implements ConsoleAddMenu{

    Controller controller;
    Utilities util;
    TextMenu menu;

    public ConsoleAddMenuBasic(Controller controller, Utilities util, TextMenu menu){
        this.controller = controller;
        this.util = util;
        this.menu = menu;
    }

    @Override
    public void runAddMenu() {
        String name = "Noname";
        int count = 0;
        int weight = 0;
        int temp = 0;
        while (true) {
            int answer = util.getPositiveIntAnswer(menu.addMenu, 0, 4);
            switch (answer) {
                case 1:
                    util.showText(menu.requestData);
                    name = util.inputString();
                    break;
                case 2:
                    temp = util.getPositiveIntAnswer(menu.requestData, 0, Integer.MAX_VALUE);
                    count = temp > 0? temp: 0;
                    break;
                case 3:
                    temp = util.getPositiveIntAnswer(menu.requestData, 0, 100);
                    weight = temp > 0? temp: 0;
                break;
                case 4:
                    tryAddToy(menu.previewText, name, count, weight);
                    break;
                case 0:
                    return;
            }
        }
    }

    public void tryAddToy(String request, String name, int count, int weight){
        util.showText(menu.previewText);
        util.preview(name, count, weight);
        if(util.checkMenu()){
            String data = name + ":" + Integer.toString(count) + ":" + Integer.toString(weight);
            controller.addEntity(data);
        }
    }
    
}