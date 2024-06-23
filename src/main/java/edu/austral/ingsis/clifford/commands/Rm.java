package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.files.Directory;
import edu.austral.ingsis.clifford.files.Node;

import java.util.List;

public class Rm implements Command {

    private final List<String> args;
    private FileSystem fileSystem;

    public Rm(FileSystem fileSystem, List<String> args) {
      this.args = args;
        this.fileSystem = fileSystem;
    }

  @Override
  public String execute() {
      if(args.get(0).equals("--recursive")){
        fileSystem.getCurrentDirectory().removeNode(args.get(1));
        return "'" + args.get(1) + "' removed";
      }
      Node node = fileSystem.getCurrentDirectory().getNode(args.get(0));
        if(node instanceof Directory){
          return "cannot remove '" + args.get(0) + "', is a directory";
        }
        fileSystem.getCurrentDirectory().removeNode(args.get(0));
        return "'" + args.get(0) + "' removed";
  }





}
