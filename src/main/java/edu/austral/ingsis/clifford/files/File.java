package edu.austral.ingsis.clifford.files;

import java.util.Date;
import java.util.List;

public class File implements Node {

  private final String name;
  private final Directory parent;
  private final Date creationDate;

  public File(String name, Directory parent) {
    parent.addNode(this);
    this.name = name;
    this.parent = parent;
    this.creationDate = new Date();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Node getParentDirectory() {
    return parent;
  }

  @Override
  public List<Node> getSubDirectories() {
    return null;
  }

  @Override
  public Date getCreationDate() {
    return creationDate;
  }

  public String getPath() {
    if (parent == null || parent.getName().equals("root")) {
      return "/" + name;
    }
    return parent.getPath() + "/" + name;
  }
}
