package View.ConsoleView.ConsoleViewBasic;

import View.ConsoleView.Interfaces.ConsoleSelectMenu;

import java.util.List;

import Controller.Interfaces.Controller;
import Model.Entities.AbstractClasses.Entity;


public class ConsoleSelectMenuBasic implements ConsoleSelectMenu{
 
    Controller controller;
    Utilities util;
    TextMenu menu;

    public ConsoleSelectMenuBasic(Controller controller, Utilities util, TextMenu menu){
        this.controller = controller;
        this.util = util;
        this.menu = menu;
    }


    @Override
    public void runSelectMenu() {
        while (true) {
            util.showText(menu.selectMenu);
            int answer = util.inputInt();
            switch (answer) {
                case 1:
                    selectById();
                    break;
                case 2:
                    selectByName();
                    break;
                case 0:
                    return;
                default:
                    util.showText(menu.errorText);
                    break;
            }
        }
    }

    public void selectById(){
        util.showText(menu.requestData);
        int id = util.inputInt();
        if(id > 0){
            Entity entity = controller.getEntityById(id);
            if (entity != null){
                util.requestToContinue(entity.getData());
            }
            else util.showText(menu.notFound);
        }
        else util.showText(menu.errorText);
    }

    public void selectByName(){
        util.showText(menu.requestData);
        String name = util.inputString();
        if(!name.equals("")){
            List<Entity> entities = controller.getEntitiesByName(name);
            if (entities.size() != 0){
                entities.stream().forEach(e -> util.showText(e.getData()));
                util.requestToContinue("");
            }
            else util.showText(menu.notFound);
        }
        else util.showText(menu.errorText);
    }
    
}