import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static java.lang.String.valueOf;

public class Second extends Application
{
  private Button one;
  private Button two;
  private Button three;
  private Button four;
  private Button five;
  private Button six;
  private Button seven;
  private Button eight;
  private Button nine;
  private Button zero;
  private Button lomitko;
  private Button multiply;
  private Button minus;
  private Button plus;
  private Button equals;
  private Button dot;
  private Button clear;
  private TextField input;
  private GridPane grid;
  private Scene scene;
  private VBox box;
  private MyListener listener;

  public void start(Stage window)
  {
    listener = new MyListener();
    one = new Button("1");
    two = new Button("2");
    three = new Button("3");
    four = new Button("4");
    five = new Button("5");
    six = new Button("6");
    seven = new Button("7");
    eight = new Button("8");
    nine = new Button("9");
    zero = new Button("0");
    lomitko = new Button("/");
    multiply = new Button("*");
    minus = new Button("-");
    plus = new Button("+");
    equals = new Button("=");
    dot = new Button(".");

    clear = new Button("C");

    one.setOnAction(listener);
    two.setOnAction(listener);
    three.setOnAction(listener);
    four.setOnAction(listener);
    five.setOnAction(listener);
    six.setOnAction(listener);
    seven.setOnAction(listener);
    eight.setOnAction(listener);
    nine.setOnAction(listener);
    zero.setOnAction(listener);
    lomitko.setOnAction(listener);
    multiply.setOnAction(listener);
    minus.setOnAction(listener);
    plus.setOnAction(listener);
    equals.setOnAction(listener);
    dot.setOnAction(listener);
    clear.setOnAction(listener);
    input = new TextField();
    window.setTitle("Calculator");
    grid = new GridPane();
    grid.addRow(0, seven, eight, nine, lomitko, clear);
    grid.addRow(1, four, five, six, multiply);
    grid.addRow(2, one, two, three, minus);
    grid.addRow(3, zero, dot, equals, plus);
    grid.setPrefWidth(70);
    grid.setPrefHeight(70);
    for (Object button : grid.getChildren())
    {
      ((Button) button).setMinHeight(grid.getPrefHeight());
      ((Button) button).setMinWidth(grid.getPrefWidth());
    }

    box = new VBox();
    box.getChildren().addAll(input, grid);
    scene = new Scene(box);

    window.setScene(scene);
    window.setResizable(false);
    window.show();

  }

  private class MyListener implements EventHandler<ActionEvent>
  {
    String field = "";
    String temp = "";
    char operation;
    String lastValue;

    public void handle(ActionEvent e)
    {
      if (e.getSource() == clear)
      {
        field = "";
        operation = '0';
        temp = "";
        input.setText("");
      }
      if (e.getSource() == one)
      {
        field = field + "1";
        input.setText(field);
      }
      if (e.getSource() == two)
      {
        field += "2";
        input.setText(field);
      }
      if (e.getSource() == three)
      {
        field += "3";
        input.setText(field);
      }
      if (e.getSource() == four)
      {
        field += "4";
        input.setText(field);
      }
      if (e.getSource() == five)
      {
        field += "5";
        input.setText(field);
      }
      if (e.getSource() == six)
      {
        field += "6";
        input.setText(field);
      }
      if (e.getSource() == seven)
      {
        field += "7";
        input.setText(field);
      }
      if (e.getSource() == eight)
      {
        field += "8";
        input.setText(field);
      }
      if (e.getSource() == nine)
      {
        field += "9";
        input.setText(field);
      }
      if (e.getSource() == zero)
      {
        field += "0";
        input.setText(field);
      }

      if (e.getSource() == dot)
      {
        field += ".";
        input.setText(field);
      }
      if (e.getSource() == lomitko)
      {
        operation = '/';
        field = "";
        input.setText("");
      }
      if (e.getSource() == plus)
      {

        operation = '+';
        field = "";
        input.setText("");
      }
      if (e.getSource() == minus)
      {
        operation = '-';
        field = "";
        input.setText("");
      }
      if (e.getSource() == multiply)
      {
        operation = '*';
        field = "";
        input.setText("");
      }

      if (e.getSource() == equals)
      {
        if (operation == '/')
        {
          temp = valueOf(Double.parseDouble(temp) / Double.parseDouble(field));
          input.setText(temp);
        }
        else if (operation == '+')
        {
          field = valueOf(Double.parseDouble(temp) + Double.parseDouble(field));
          input.setText(field);
        }
        else if (operation == '-')
        {
          temp = valueOf(Double.parseDouble(temp) - Double.parseDouble(field));
          input.setText(temp);
        }
        else if (operation == '*')
        {
          temp = valueOf(Double.parseDouble(temp) * Double.parseDouble(field));
          input.setText(temp);
        }
      }
    }
  }
}