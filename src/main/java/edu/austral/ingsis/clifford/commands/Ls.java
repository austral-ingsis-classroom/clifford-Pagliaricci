package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.files.Node;
import java.util.*;

public class Ls implements Command {

  private String flag;
  private FileSystem fileSystem;

  public Ls(FileSystem fileSystem, String flag) {
    this.flag = flag;
    this.fileSystem = fileSystem;
  }

  @Override
  public String execute() {
    if (Objects.equals(flag, "")) {
      List<Node> files = creationDateOrder(fileSystem.getCurrentDirectory().getSubDirectories());
      return buildOutput(files);
    } else if (flag.equals("--ord=asc")) {
      List<Node> files = nameOrder(fileSystem.getCurrentDirectory().getSubDirectories());
      return buildOutput(files);
    } else if (flag.equals("--ord=desc")) {
      List<Node> files = nameOrder(fileSystem.getCurrentDirectory().getSubDirectories());
      Collections.reverse(files);
      return buildOutput(files);
    } else {
      return "Invalid command";
    }
  }

  private String buildOutput(List<Node> files) {
    StringBuilder output = new StringBuilder();
    for (Node file : files) {
      output.append(file.getName());
      output.append(" ");
    }
    return output.toString();
  }

  private List<Node> creationDateOrder(List<Node> files) {
    List<Node> orderedFiles = new ArrayList<>();
    Comparator<Node> comparator = Comparator.comparing(Node::getCreationDate);
    if (files == null) {
      return orderedFiles;
    }
    while (!files.isEmpty()) {
      Node newest = files.stream().min(comparator).get();
      orderedFiles.add(newest);
      files.remove(newest);
    }

    return orderedFiles;
  }

  private List<Node> nameOrder(List<Node> files) {
    List<Node> orderedFiles = new ArrayList<>();
    Comparator<Node> comparator = Comparator.comparing(Node::getName);
    while (!files.isEmpty()) {
      Node newest = files.stream().min(comparator).get();
      orderedFiles.add(newest);
      files.remove(newest);
    }

    return orderedFiles;
  }
}
