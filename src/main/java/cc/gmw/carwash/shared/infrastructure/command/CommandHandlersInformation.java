package cc.gmw.carwash.shared.infrastructure.command;

import cc.gmw.carwash.shared.model.command.Command;
import cc.gmw.carwash.shared.model.command.CommandHandler;
import cc.gmw.carwash.shared.model.command.CommandNotRegisteredError;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public final class CommandHandlersInformation {
    private final Map<Class<? extends Command>, Class<? extends CommandHandler<?>>> commands;

    public CommandHandlersInformation() {
        commands = collectCommands();
    }

    public Class<? extends CommandHandler<?>> search(Class<? extends Command> commandClass) throws CommandNotRegisteredError {
        Class<? extends CommandHandler<?>> commandHandlerClass = commands.get(commandClass);
        if (null == commandHandlerClass) {
            throw new CommandNotRegisteredError(commandClass);
        }
        return commandHandlerClass;
    }

    @SuppressWarnings("unchecked")
    private Map<Class<? extends Command>, Class<? extends CommandHandler<?>>> collectCommands() {
        Reflections reflections = new Reflections("cc.gmw.carwash");
        return reflections.getSubTypesOf(CommandHandler.class).stream()
                .collect(Collectors.toMap(this::getCommandClass, handler ->(Class<? extends CommandHandler<?>>) handler));
    }

    @SuppressWarnings("unchecked")
    private Class<? extends Command> getCommandClass(Class<?> handler) {
        ParameterizedType parameterizedType = (ParameterizedType) handler.getGenericInterfaces()[0];
        return (Class<? extends Command>) parameterizedType.getActualTypeArguments()[0];
    }
}
