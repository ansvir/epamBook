package part.two.chapter.thirteen;

import java.io.IOException;

public class Execute {

    private Command command;

    Execute(Command command) {
        this.command = command;
    }

    public void executeCommand() throws IOException {
        command.execute();
    }
}
