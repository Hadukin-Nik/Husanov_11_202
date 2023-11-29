package fourthTask;

import fourthTask.sockets.ReadingThread;
import fourthTask.sockets.WritingThread;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatController {
    private static StringProperty messages;

    @FXML
    private TextField messageField;

    @FXML
    private TextArea chatField;

    private static ReadingThread readingThread;
    private static WritingThread writingThread;

    boolean isBind;
    @FXML
    public void initialize() {
        isBind = false;
    }
    public static void init() {
        messages = readingThread.getMessages();
    }
    public static void WritingThread(WritingThread writingAddThread) {
        writingThread = writingAddThread;
    }


    public static void ReadingThread(ReadingThread readingAddThread) {
        readingThread = readingAddThread;
    }

    @FXML
    public void onAction() {
        if(!isBind) {
            isBind = true;

            messages = readingThread.getMessages();
            chatField.textProperty().bind(messages);
        }
        writingThread.sendMessage(messageField.getText());
    }
}
