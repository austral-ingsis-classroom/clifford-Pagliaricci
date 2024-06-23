package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.files.File;
import edu.austral.ingsis.clifford.files.Node;

public class Touch implements Command {

  private String name;
  private FileSystem fileSystem;


    public Touch(FileSystem fileSystem, String name) {
        this.name = name;
        this.fileSystem = fileSystem;
    }
  @Override
  public String execute() {
      Node file = new File(name, fileSystem.getCurrentDirectory());
      return name + ".txt" + "file created";
  }


}
