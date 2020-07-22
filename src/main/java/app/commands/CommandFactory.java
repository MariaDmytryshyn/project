package app.commands;

public class CommandFactory {

    private static CommandFactory instance;

    private CommandFactory() {}

    public CommandFactory getInstance() {
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
        }
        return command;
    }
}
