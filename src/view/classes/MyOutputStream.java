package view.classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MyOutputStream extends OutputStream {

    public final static StringProperty SIMPLE_STRING_PROPERTY = new SimpleStringProperty(" ");
    private final static MyOutputStream MY_OUTPUT_STREAM = new MyOutputStream();
    private MyOutputStream(){ super();
    System.setOut(new PrintStream(this));
    }

    @Override
    public void write(int b) throws IOException {
        SIMPLE_STRING_PROPERTY.setValue(SIMPLE_STRING_PROPERTY.getValue() + (char) b);
    }

}
