package duke.commands;

import duke.gui.Ui;
import duke.storage.Storage;
import duke.tasks.ToDo;

/**
 * Class to handle the todo command.
 */
public class ToDoCommand extends Command {
    private ToDo toDo;

    /**
     * Construct a new ToDoCommand instance with the specified toDo task stored.
     *
     * @param toDo the ToDo task to be stored.
     */
    public ToDoCommand(ToDo toDo) {
        this.toDo = toDo;
    }

    /**
     * Add the task to the list and print out reply message
     *
     * @param ui The Ui instance for printing
     * @param storage The Storage instance to add the task to
     * @return A boolean of false to indicate the main while loop should not be broken
     */
    @Override
    public String execute(Ui ui, Storage storage) {
        storage.addToList(toDo);
        storage.save();
        return ui.print("Got it! I've added this task to the list: \n"
                + "  " + toDo.toString() + '\n'
                + String.format("Now you have %d tasks in the list", storage.getSize()));
    }
}
