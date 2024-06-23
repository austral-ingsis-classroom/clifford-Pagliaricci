package edu.austral.ingsis.clifford.files;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory implements Node {

    private final String name;
    private final Directory parent;
    private final ArrayList<Node>  subFiles = new ArrayList<>();
    private final Date creationDate;


    public Directory(String name, Directory parent) {
      parent.addNode(this);
      this.name = name;
      this.parent = parent;
      this.creationDate = new Date();
    }

    public Directory(String name){
      this.name = name;
      this.parent = null;
      this.creationDate = new Date();
    }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Directory getParentDirectory() {
    return parent;
  }

  @Override
  public ArrayList<Node> getSubDirectories() {
    return new ArrayList<>(subFiles);
  }

  @Override
  public Date getCreationDate() {
    return creationDate;
  }

  public void addNode(Node node){
    System.out.println(subFiles.size());
      subFiles.add(node);
    System.out.println(subFiles.size());
    }
  public void removeNode(Node node) {
      subFiles.remove(node);
    }

}
