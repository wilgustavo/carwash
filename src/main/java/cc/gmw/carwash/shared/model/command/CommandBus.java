package cc.gmw.carwash.shared.model.command;

public interface CommandBus {
    void dispatch(Command command) throws CommandHandlerExecutionError;
}
