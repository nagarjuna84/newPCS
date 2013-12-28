package pcsstandalone.userinterface;




import java.io.File;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.stage.Stage;

public class MediaPlayer extends Application {
     public static String arg1;
     String s=System.getProperty("/home/ubuntu/NetBeansProjects/Video/src"); 
    File f=new File(s, "C://Users/Nagarjun Reddy/Videos/"+arg1+".mp4");
    String MEDIA_URL = f.toURI().toString();
    
    

    @Override public void start(Stage stage) {
        stage.setTitle("Media Player");
        Group root = new Group();
        Scene scene = new Scene(root,600,265);
        // create media player
        Media media = new Media(MEDIA_URL);
        javafx.scene.media.MediaPlayer mediaPlayer = new javafx.scene.media.MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
                
        MediaControl mediaControl = new MediaControl(mediaPlayer);
        scene.setRoot(mediaControl);
        scene.getStylesheets().add(MediaPlayer.class.getResource("mediaplayer.css").toExternalForm());
        // show stage
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args) {
        arg1=args;
        System.out.println(arg1);
        Application.launch(args);
    }
}