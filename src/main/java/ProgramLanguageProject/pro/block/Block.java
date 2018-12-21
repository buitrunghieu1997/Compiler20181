/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro.block - IntelliJ IDEA
 * block.java
 * Created at 14:28 ~ 27/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.block;

import ProgramLanguageProject.pro.Variable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Đại diện cho một khối code
 *
 * @author Bùi Trung Hiếu Created: 14:28 ~ 27/11/2018
 */
public abstract class Block {
  // Khối cha, một khối lệnh chỉ có thể có 1 khối cha
  private Block superBlock;
  // Một khối có thể có nhiều khối con
  private ArrayList<Block> subBlocks;
  // Một khối có thể có nhiều biến (variable)
  private ArrayList<Variable> variables;

  /**
   * Instantiates a new Block.
   *
   * @param superBlock the super block
   */
  public Block(Block superBlock) {
    this.superBlock = superBlock;
    this.subBlocks = new ArrayList<>();
    this.variables = new ArrayList<>();
  }

  /**
   * Gets super block.
   *
   * @return the super block
   */
  public Block getSuperBlock() {
    return superBlock;
  } // có thể null nếu k có

  public Block[] getSubBlocks() {
  	return subBlocks.toArray(new Block[subBlocks.size()]);
  }
  
  public ArrayList<Block> getBlockTree() {
    ArrayList<Block>blocks = new ArrayList<>();
    Block block = this;
    do {
      blocks.add(block);
      block = block.getSuperBlock();
    } while (block != null);
    Collections.reverse(blocks);
    return blocks;
  }
  
  /**
   * Thêm một khối lệnh vào list các khối lệnh con
   *
   * @param block new block
   */
  public void addBlock(Block block) {
    subBlocks.add(block);
  }

  public Variable getVariable(String name) {
    // Lưu ý Kiểm tra khối cha trước xem có biến đó k vì biến nằm ở khối cha vẫn có thể truy nhập được ở khối con
    for (Variable v : variables) {
      if (v.getName().equals(name)) {
        return v;
      }
    }
    return null;
  }

  public void addVariable(Variable v) {
    variables.add(v);
  }

  public abstract void run();
}
