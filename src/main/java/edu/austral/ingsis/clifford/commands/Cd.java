package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.files.Directory;

public class Cd implements Command {


    private final String name;
    private final FileSystem fileSystem;

    public Cd(FileSystem fileSystem, String name) {
      this.name = name;
        this.fileSystem = fileSystem;
    }

  @Override
  public String execute() {
    Directory dir = (Directory) fileSystem.getCurrentDirectory();
    fileSystem.changeDirectory(dir);
    return "Moved to directory:" + dir.getName();
  }

}
