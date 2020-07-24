package app.commands;

import app.commands.impl.LoginCommand;
import app.commands.impl.LogoutCommand;
import app.commands.impl.RegistrationCommand;
import app.commands.impl.admin.*;
import app.commands.impl.user.*;

public class CommandFactory {

    private static CommandFactory instance;

    private CommandFactory() {}

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommand(Commands type) {
        Command command = null;
        switch (type) {
            case LOGIN:
                command = new LoginCommand();
                break;
            case LOGOUT:
                command = new LogoutCommand();
                break;
            case REGISTER:
                command = new RegistrationCommand();
                break;
            case ADD_TO_ORDER:
                command = new AddToOrderCommand();
                break;
            case CATEGORY:
                command = new CategoryCommand();
                break;
            case CONFIRM_ORDER:
                command = new ConfirmOrderCommand();
                break;
            case DELETE_FROM_ORDER:
                command = new DeleteFromOrderCommand();
                break;
            case MENU:
                command = new MenuCommand();
                 break;
            case PAY_BILL:
                command = new PayBillCommand();
                break;
            case SELECT_TABLE:
                command = new SelectTableCommand();
                break;
            case SHOW_BILL:
                command = new ShowBillCommand();
                break;
            case ADD_CATEGORY:
                command = new AddCategoryCommand();
                break;
            case ADD_DISH:
                command = new AddDishCommand();
                break;
            case CHANGE_PRICE:
                command = new ChangePriceCommand();
                break;
            case DELETE_DISH:
                command = new DeleteDishCommand();
                break;
            case FIND_USER:
                command = new FindUserCommand();
                break;
        }
        return command;
    }
}
