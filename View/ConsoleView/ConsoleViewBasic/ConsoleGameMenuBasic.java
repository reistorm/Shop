package View.ConsoleView.ConsoleViewBasic;

import View.ConsoleView.Interfaces.ConsoleGameMenu;

import java.util.List;

import Controller.Interfaces.Controller;
import Model.Entities.AbstractClasses.Entity;


public class ConsoleGameMenuBasic implements ConsoleGameMenu{  
   
    Controller controller;
    Utilities util;
    TextMenu menu;

    public ConsoleGameMenuBasic(Controller controller, Utilities util, TextMenu menu){
        this.controller = controller;
        this.util = util;
        this.menu = menu;
    }


    @Override
    public void runGameMenu() {
        while (true) {
            int answer = util.getPositiveIntAnswer(menu.gameMenu, 0, 7);
            switch (answer) {
                case 1:
                    tryGame();
                    break;
                case 2:
                    tryAddEntityToGameList();
                    break;
                case 3:
                    showEntityGameList();
                    break;
                case 4:
                    trySetEntityByIdForGame();
                    break;
                case 5:
                    trySetEntityByIndexForGame();
                    break;
                case 6:
                    tryRemoveEntityByIdFromGameList();
                    break;
                case 7:
                    RemoveAllEntityFromGameList();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void tryGame(){
        if(controller.checkGame()){
            Entity entity = controller.runGame();
            if(entity == null){
                util.requestToContinue(menu.loserText);
            }
            else{
                util.showText(menu.winText);
                util.requestToContinue(entity.getName() + "\n");
            }
        }
        else util.requestToContinue(menu.thereIsNoAward);
    }

    public void tryAddEntityToGameList(){
        util.showText(menu.requestId);
        int id = util.inputInt();
        if(id > 0){
            Entity entity = controller.getEntityById(id);
            if (entity == null) util.showText(menu.notFound);
            else if (entity.getCount() == 0) util.showText(menu.notFound);
            else{
                util.showText(entity.getData());
                if(util.checkMenu()) controller.addEntityToGameList(entity);
            }
        }
        else util.showText(menu.errorText);
    }


    public void showEntityGameList(){
        util.requestToContinue(controller.getGameEntityList());
    }

    public void trySetEntityByIdForGame(){
        util.showText(menu.requestId);
        int id = util.inputInt();
        if (id == 0) return;
        if(controller.trySetEntityByIdForGame(id)) util.requestToContinue(menu.success);
        else util.requestToContinue(menu.errorText);
    }

    public void trySetEntityByIndexForGame(){
        util.showText(menu.requestIndex);
        int index = util.inputInt();
        if (index == 0) return;
        if(controller.trySetEntityByIndexForGame(index)) util.requestToContinue(menu.success);
        else util.requestToContinue(menu.errorText);
    }

    public void tryRemoveEntityByIdFromGameList(){
        util.showText(menu.requestId);
        int id = util.inputInt();
        if (id == 0) return;
        if(controller.tryRemoveEntityByIdFromGameList(id)) util.requestToContinue(menu.success);
        else util.requestToContinue(menu.errorText);
    }

    public void RemoveAllEntityFromGameList(){
        if(util.checkMenu()) controller.tryRemoveAllEntityFromGameList();
    }
    
}