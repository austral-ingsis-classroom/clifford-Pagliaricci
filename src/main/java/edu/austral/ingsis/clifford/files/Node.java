package edu.austral.ingsis.clifford.files;

import java.util.Date;
import java.util.List;

public interface Node {
  public String getName();

  public Node getParentDirectory();
  public List<Node> getSubDirectories();
  Date getCreationDate();

}
