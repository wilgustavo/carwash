package cc.gmw.carwash.shared.infrastructure.command;

import cc.gmw.carwash.shared.model.command.Command;
import cc.gmw.carwash.shared.model.command.CommandBus;
import cc.gmw.carwash.shared.model.command.CommandHandler;
import cc.gmw.carwash.shared.model.command.CommandHandlerExecutionError;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public final class InMemoryCommandBus implements CommandBus {
    private final CommandHandlersInformation information;
    private final ApplicationContext context;

    public InMemoryCommandBus(CommandHandlersInformation information, ApplicationContext context) {
        this.information = information;
        this.context = context;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void dispatch(Command command) throws CommandHandlerExecutionError {
        try {
            Class<? extends CommandHandler<?>> commandHandlerClass = information.search(command.getClass());
            CommandHandler<Command> handler = (CommandHandler<Command>) context.getBean(commandHandlerClass);
            handler.handle(command);
        } catch (Throwable error) {
            throw new CommandHandlerExecutionError(error);
        }
    }
}
