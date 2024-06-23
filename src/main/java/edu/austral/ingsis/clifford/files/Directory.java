package edu.austral.ingsis.clifford.files;

import java.util.ArrayList;
import java.util.Date;

public class Directory implements Node {
  private final String name;
  private final Directory parent;
  private final ArrayList<Node> subFiles = new ArrayList<>();
  private final Date creationDate;

  public Directory(String name, Directory parent) {
    this.name = name;
    this.parent = parent;
    this.creationDate = new Date();
    if (parent != null) {
      parent.addNode(this);
    }
  }

  public Directory(String name) {
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

  public void addNode(Node node) {
    subFiles.add(node);
  }

  public Node getNode(String name) {
    if (name.contains("/")) {
      String[] args = name.split("/");
      Directory current = this;
      for (String arg : args) {
        Node newNode = current.getDirectChild(arg);
        if (newNode == null) {
          return null;
        }
        if (newNode instanceof Directory) {
          current = (Directory) newNode;
        }
      }
      return current;
    }
    return getDirectChild(name);
  }

  public Node getDirectChild(String name) {
    for (Node node : subFiles) {
      if (node.getName().equals(name)) {
        return node;
      }
    }
    return null;
  }

  public void removeNode(String str) {
    for (Node file : subFiles) {
      if (file.getName().equals(str)) {
        subFiles.remove(file);
        return;
      }
    }
    throw new RuntimeException("Node does not exist");
  }

  public String getPath() {
    if (parent == null) {
      return "/";
    }
    String parentPath = parent.getPath();
    return parentPath.equals("/") ? "/" + name : parentPath + "/" + name;
  }
}
