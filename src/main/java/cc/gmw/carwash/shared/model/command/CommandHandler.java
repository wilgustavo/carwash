package cc.gmw.carwash.shared.model.command;

public interface CommandHandler<T extends Command> {
    void handle(T command);
}
