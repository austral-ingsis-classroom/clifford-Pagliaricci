package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.FileSystem;

public class Pwd implements Command {

    private final FileSystem fileSystem;
    public Pwd(FileSystem fileSystem) {
      this.fileSystem = fileSystem;
    }

  @Override
  public String execute() {
    return fileSystem.getRootPath();
  }


}
