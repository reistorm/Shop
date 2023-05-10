import Controller.ControllerBasic.ControllerBasic;
import Controller.Interfaces.Controller;
import Database.Interfaces.DbRequest;
import Database.Txt.TxtDbApi.TxtDbRequest;
import Model.Entities.Games.Lottery;
import Model.Entities.Interfaces.Game;
import Model.Entities.Toys.Toy;
import Model.Infrastructure.InfrastructureBasic.InfrastructureBasic;
import Model.Infrastructure.InfrastructureBasic.Factories.ToyFactoryBasic;
import Model.Infrastructure.Interfaces.EntityFactory;
import Model.Infrastructure.Interfaces.Infrastructure;
import View.ConsoleView.ConsoleViewBasic.ConsoleMainMenuBasic;
import View.Interfaces.View;

/**
 * Program
 */
public class Program {
    public static void main(String[] args) {
        String path = "Database/Txt/TxtDb/";
        EntityFactory<Toy> factory = new ToyFactoryBasic();
        Game<Toy> game = new Lottery<Toy>();
        DbRequest<Toy> db = new TxtDbRequest<Toy>(path, factory);
        Infrastructure infrastructure = new InfrastructureBasic(db, factory, game);
        Controller controller = new ControllerBasic(infrastructure);
        View view = new ConsoleMainMenuBasic(controller);

        view.runMainMenu();
    }
}