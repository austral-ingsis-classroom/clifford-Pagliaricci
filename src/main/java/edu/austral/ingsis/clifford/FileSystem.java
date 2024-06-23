package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.files.Directory;

public class FileSystem {
  private StringBuilder rootPath;
  private Directory rootDirectory;
  private Directory currentDirectory;

  public FileSystem(String rootPath) {
    this.rootPath = new StringBuilder(rootPath);
    this.rootDirectory = new Directory("/");
    this.currentDirectory = rootDirectory;
  }

  public String executeCommand(Command command) {
    return command.execute();
  }

  public void changeDirectory(Directory dir) {
    currentDirectory = dir;
    rootPath = new StringBuilder(currentDirectory.getPath());
  }

  public Directory getCurrentDirectory() {
    return currentDirectory;
  }

  public Directory getRoot() {
    return rootDirectory;
  }

  public String getRootPath() {
    return rootPath.toString();
  }
}
