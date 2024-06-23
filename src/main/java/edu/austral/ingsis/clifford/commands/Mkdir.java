package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.files.Directory;

public class Mkdir implements Command {


  private final String name;
  private final FileSystem fileSystem;

  public Mkdir(FileSystem fileSystem, String name) {
    this.name = name;
    this.fileSystem = fileSystem;
  }

  @Override
  public String execute() {
    new Directory(name,fileSystem.getCurrentDirectory());
    return  "'"+name+"'"+ " directory created";
  }



}
