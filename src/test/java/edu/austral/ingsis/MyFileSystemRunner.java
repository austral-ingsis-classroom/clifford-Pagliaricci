package edu.austral.ingsis;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.commands.*;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

public class MyFileSystemRunner implements FileSystemRunner{
  FileSystem fileSystem = new FileSystem("");
  @Override
  public List<String> executeCommands(List<String> commands) {

    List<String> results = new ArrayList<>();
      for (String command : commands) {
        Command cmd = strToCommand(command, fileSystem);
        results.add(fileSystem.executeCommand(cmd));
      }
      return results;
  }

  private Command strToCommand(String command, FileSystem fileSystem) {
      List<String> commandParts = List.of(command.split(" "));
    if (commandParts.get(0).equals("ls")) {
      if(commandParts.size() >1){
        return new Ls(fileSystem, commandParts.get(1));
      }
      return new Ls(fileSystem, "");
    }
    if (commandParts.get(0).equals("mkdir")) {
      return new Mkdir(fileSystem, commandParts.get(1));
    }
    if (commandParts.get(0).equals("cd")) {
      return new Cd(fileSystem,commandParts.get(1));
    }
    if (commandParts.get(0).equals("pwd")) {
      return new Pwd(fileSystem);
    }
    if (commandParts.get(0).equals("touch")) {
      return new Touch(fileSystem, commandParts.get(1));
    }
    if (commandParts.get(0).equals("rm")) {
      return new Rm(fileSystem,commandParts.subList(1, commandParts.size()));
    }
    throw new IllegalFormatCodePointException(0);
    }
}
