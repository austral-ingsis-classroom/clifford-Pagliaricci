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
    try {
      Node node;
      if (!args.contains("--recursive")) {
        node = fileSystem.getCurrentDirectory().getParentDirectory();
        if (node == null) {
          return "Error: Node does not exist.";
        }
        if (node instanceof Directory) {
          return "Cannot remove directory without --recursive flag";
        }
      } else {
        node = fileSystem.getCurrentDirectory().getParentDirectory();
        if (node == null) {
          return "Error: Node does not exist.";
        }
      }
      System.out.println("HOLAAA");
      //fileSystem.getCurrentDirectory().removeNode(node);
      return node.getName() + " file removed";
    } catch (Exception e) {
      return "Error: " + e.getMessage();
    }
  }





}
