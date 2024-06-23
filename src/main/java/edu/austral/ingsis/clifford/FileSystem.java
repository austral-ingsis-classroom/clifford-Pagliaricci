package edu.austral.ingsis.clifford;


import edu.austral.ingsis.clifford.files.Directory;


public class FileSystem {

  private String rootPath;
  private Directory currentDirectory = new Directory("root");

    public FileSystem(String rootPath) {

        this.rootPath = rootPath;
    }

    public String executeCommand(Command command) {
        return command.execute();
    }
    public void changeDirectory(Directory dir) {
      if(dir != null){
        currentDirectory = dir;
      }
      throw new RuntimeException("Directory not found");
    }
    public Directory getCurrentDirectory() {
        return currentDirectory;

    }
    public String getRootPath() {
        return rootPath;
    }




}
