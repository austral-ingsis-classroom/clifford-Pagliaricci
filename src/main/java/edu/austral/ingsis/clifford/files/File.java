package edu.austral.ingsis.clifford.files;

import java.util.Date;
import java.util.List;

public class File implements Node{

private String name;
private Directory directory;
private Date creationDate;


public File(String name, Directory directory) {
    this.name = name;
    this.directory = directory;
    this.creationDate = new Date();
}

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Node getParentDirectory() {
    return directory;
  }

  @Override
  public List<Node> getSubDirectories() {
    return null;
  }

  @Override
  public Date getCreationDate() {
    return creationDate;
  }

}
