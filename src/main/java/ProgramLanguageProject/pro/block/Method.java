/*
 * Copyright(C) 2018 Bùi Trung Hiếu
 * ProgramLanguageCompiler, ProgramLanguageProject.pro.block - IntelliJ IDEA
 * Method.java
 * Created at 15:18 ~ 27/11/2018 by Bùi Trung Hiếu
 */
package ProgramLanguageProject.pro.block;

import ProgramLanguageProject.pro.Type.Type;
import ProgramLanguageProject.pro.varl.Parameter;
import ProgramLanguageProject.pro.varl.Value;
import ProgramLanguageProject.pro.varl.Variable;

import java.util.Arrays;

/**
 * Khối lệnh là một method
 *
 * @author Bùi Trung Hiếu Created: 15:18 ~ 27/11/2018
 */
public class Method extends Block {
  private String      name;
  private String      type;
  private Parameter[] params;
  private Value       returnValue;

  /**
   * Instantiates a new Method.
   *
   * @param superBlock the super block
   * @param name the name
   * @param type the type
   * @param params the params
   */
  public Method(Block superBlock, String name, String type, Parameter[] params) {
    super(superBlock);
    this.name = name;
    this.type = type;
    this.params = params;
  }

  @Override
  public void run() {
    invoke();
  }

  /**
   * Invoke the method ... mean none, one or many Value can be there
   *
   * @param values the values
   */
  public Value invoke(Value... values) {
    // tìm ra kiểu dl thực từ string type (vì không thể qđ ngay từ khi đọc được token type mà biết được nó là buildin hay là kiểu dl custom)
    Type t = Type.match(type);

    System.out.println("Invoking method " + name + " of type " + t + " with params " + Arrays.toString(params));

    // Gọi hàm với các giá trị được cụ thể
    if (values.length != params.length) { // truyền thừa hoặc thiếu tham số
      throw new IllegalArgumentException(
          "Truyền sai số lượng giá trị cho tham số đầu vào của hàm.");
    }

    for (int i = 0; i < values.length && i < params.length; i++) {
      // Lấy ra tham số thứ i của hàm
      Parameter p = params[i];
      // Lấy ra giá trị được truyền vào cho tham số thứ i
      Value v = values[i];

      if (p.getType() != v.getType()) {
        throw new IllegalStateException(
            "Parameter "
                + p.getName()
                + " nên có kiểu là "
                + p.getType()
                + ". Hiện đang là "
                + v.getType());
      }

      // Thêm biến hợp lệ vào list (Khối cha chính là method này) có kiểu tham os, tên tham số và
      // giá trị của tham số được truyền vào
      addVariable(new Variable(this, p.getType(), p.getName(), v.getValue()));
    }

    // Duyệt các khối con trong chương trình
    for (Block b : getSubBlocks()) {
      // Chạy từng khối
      b.run();

      // Nếu đã return thì thoát chương trình
      if (returnValue != null) {
        // Thoát vòng for
        break;
      }
    }
    // Nếu hàm có kiểu trả về khác void mà lại k có giá trị trả về thì báo lỗi
    if (returnValue == null && t != BuildInType.VOID) {
      throw new IllegalStateException("Cần một giá trị trả về, hiện đang không có giá trị trả về.");
    }

    // Đến đây là đã tìm được giá trị trả về của hàm, gán cho một biến tạm
    Value localReturnValue = returnValue;
    // Reset trạng thái của returnValue về null
    returnValue = null;
    // Trả về giá trị
    return localReturnValue;
  }
  
  public String getName() {
    return name;
  }
  
  public String getType() {
    return type;
  }
  
  public Parameter[] getParams() {
    return params;
  }
  
  public Value getReturnValue() {
    return returnValue;
  }
}
