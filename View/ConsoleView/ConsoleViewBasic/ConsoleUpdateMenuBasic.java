package View.ConsoleView.ConsoleViewBasic;

import View.ConsoleView.Interfaces.ConsoleUpdateMenu;
import Controller.Interfaces.Controller;
import Model.Entities.AbstractClasses.Entity;
import Model.Entities.Toys.Toy;


public class ConsoleUpdateMenuBasic implements ConsoleUpdateMenu{

    Controller controller;
    Utilities util;
    TextMenu menu;

    public ConsoleUpdateMenuBasic(Controller controller, Utilities util, TextMenu menu){
        this.controller = controller;
        this.util = util;
        this.menu = menu;
    }

    @Override
    public void runUpdateMenu() {
        Toy toy = getToy();
        if (toy == null) return;
        util.showText(toy.getData());
        String name = toy.getName();
        int count = toy.getCount();
        int weight = toy.getWeight();
        int temp = 0;
        while (true) {
            int answer = util.getPositiveIntAnswer(menu.updateMenu, 0, 4);
            switch (answer) {
                case 1:
                    util.showText(menu.requestData);
                    name = util.inputString();
                    break;
                case 2:
                    temp = util.getPositiveIntAnswer(menu.requestData, 0, Integer.MAX_VALUE);
                    count = temp > 0? temp: count;
                    break;
                case 3:
                    temp = util.getPositiveIntAnswer(menu.requestData, 0, 100);
                    weight = temp > 0? temp: weight;
                    break;
                case 4:
                    tryUpdateToy(menu.previewText, toy, name, count, weight);
                    break;
                case 0:
                    return;
            }
        }
    }
    

    public Toy getToy(){
        Entity entity;
        Toy toy;
        while (true) {
            util.showText(menu.requestId);
            int id = util.inputInt();
            if(id == 0) return null;
            else if(id > 0){
                entity = controller.getEntityById(id);
                if (entity != null){
                    try {
                        toy = (Toy) entity;
                        return toy;
                    } catch (Exception e) {
                        util.showText(menu.notFound);
                    }
                }
                else util.showText(menu.notFound);
            }
            else util.showText(menu.errorText);
        }
    }

    public void tryUpdateToy(String request, Toy toy, String name, int count, int weight){
        util.showText(request);
        util.preview(name, count, weight);
        if(util.checkMenu()){
            String data = Integer.toString(toy.getId()) + ":" + name + ":" + Integer.toString(count) + ":" + Integer.toString(weight);
            controller.updateEntity(data);
        }
    }
}