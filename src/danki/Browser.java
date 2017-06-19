package danki;

import static danki.PreCarga._BrowserCB;
import static danki.PreCarga._BrowserT;
import java.awt.Toolkit;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.web.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.awt.datatransfer.StringSelection;
import javafx.scene.control.Alert.AlertType;


public class Browser extends Application {
    static int h,w;
    Stage stage1 = new Stage();
  public static void Web(String[] args) { launch(args); }

  @Override 
  public void start(final Stage stage) {
        otro();
  }
  
  public void otro(){
      Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //
             final WebView webview = new WebView();
              VBox layout = new VBox();
              layout.getChildren().setAll(
                      createProgressReport(webview.getEngine()),
                      webview
              );
              stage1.setScene(new Scene(layout));   
              stage1.getIcons().add(new Image("/Img/Icono.png"));
              stage1.setTitle(_BrowserT);
              stage1.setResizable(false);
              danki.Main.Principal.setVisible(false);
              stage1.show();
              webview.getEngine().load(Update.Address);              
              stage1.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @SuppressWarnings("override")
                    public void handle(WindowEvent we) {
                        danki.Main.Principal.close_method();
                    }
                }); 
            }
        });
  }
  
  

  private HBox createProgressReport(WebEngine engine) {
    final LongProperty startTime   = new SimpleLongProperty();
    final LongProperty endTime     = new SimpleLongProperty();
    final LongProperty elapsedTime = new SimpleLongProperty();

    final ProgressBar loadProgress = new ProgressBar();
    loadProgress.progressProperty().bind(engine.getLoadWorker().progressProperty());

    final Label loadTimeLabel = new Label();
    loadTimeLabel.textProperty().bind(
        Bindings.when(
            elapsedTime.greaterThan(0))
              .then(
                  Bindings.concat(danki.PreCarga._Browser1+" ", elapsedTime.divide(1_000_000), "ms")
              )
              .otherwise(
                  danki.PreCarga._Browser2
              )
    );

    elapsedTime.bind(Bindings.subtract(endTime, startTime));
   
    engine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
      @Override
      public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State oldState, Worker.State state) {
        switch (state) {
          case RUNNING:
            startTime.set(System.nanoTime());
            break;
          case SUCCEEDED:
            endTime.set(System.nanoTime());
            Toolkit.getDefaultToolkit().getSystemClipboard()
            .setContents(new StringSelection(danki.Log.Clipboard), null);
            Alert alert = new Alert(AlertType.NONE, _BrowserCB, ButtonType.OK);
            Stage stages = (Stage) alert.getDialogPane().getScene().getWindow();
            stages.getIcons().add(new Image("/Img/Icono.png"));
            stages.setTitle(_BrowserT);
            stage1.setAlwaysOnTop(true);
            stages.setAlwaysOnTop(true);
            stage1.setAlwaysOnTop(false);
            stages.setAlwaysOnTop(false);
            alert.showAndWait();
            
            break;
        }
      }
    });

    HBox progressReport = new HBox(10);
    progressReport.getChildren().setAll(
        loadProgress,
        loadTimeLabel
    );
    progressReport.setPadding(new Insets(5));
    progressReport.setAlignment(Pos.CENTER_LEFT);
    return progressReport;
  }
}