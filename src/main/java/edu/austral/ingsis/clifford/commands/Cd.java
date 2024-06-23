package edu.austral.ingsis.clifford.commands;

import edu.austral.ingsis.clifford.Command;
import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.files.Directory;
import edu.austral.ingsis.clifford.files.Node;

public class Cd implements Command {
    private final String name;
    private final FileSystem fileSystem;

    public Cd(FileSystem fileSystem, String name) {
        this.name = name;
        this.fileSystem = fileSystem;
    }

    @Override
    public String execute() {
        if (name.equals("..")) {
            Directory parent = fileSystem.getCurrentDirectory().getParentDirectory();
            if (parent != null) {
                fileSystem.changeDirectory(parent);
            } else {
                fileSystem.changeDirectory(fileSystem.getRoot());
            }
            return "moved to directory '" + fileSystem.getCurrentDirectory().getPath() + "'";
        }
        if (name.equals("/")) {
            fileSystem.changeDirectory(fileSystem.getRoot());
            return "moved to directory '/'";
        }
        String[] directories;
        if (name.startsWith("/")) {
            directories = name.substring(1).split("/");
            fileSystem.changeDirectory(fileSystem.getRoot());
        } else {
            directories = name.split("/");
        }
        Directory current = fileSystem.getCurrentDirectory();
        for (String dir : directories) {
            Node node = current.getNode(dir);
            if (!(node instanceof Directory)) {
                return "Directory not found";
            }
            current = (Directory) node;
        }
        fileSystem.changeDirectory(current);
        if(current.getPath().startsWith("/")){
            String output = current.getPath().substring(1);
            if(output.contains("/")){
                return "moved to directory '" + output.substring(output.indexOf("/")+1) + "'";
            }
            return "moved to directory '" + output + "'";
        }
        return "moved to directory '" + current.getName() + "'";
    }
}
