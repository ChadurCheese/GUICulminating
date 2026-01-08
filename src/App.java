//Peter Mazur
// GUI Culminating Assignment
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class App extends Application {

  // This is the scene
  private static Scene scene;

  // this method sets the root of the scene
  static void setRoot(String fxml) throws Exception {
    scene.setRoot(loadFXML(fxml));
  } 
  
  // This method loads the fxml files
  private static Parent loadFXML(String fxml) throws Exception {
    String path = "resources/FXML/" + fxml + ".fxml";
    
    // Try to load from classpath (works when compiled)
    URL url = App.class.getResource(path);
    
    if (url == null) {
        // Development mode - try to load from source directory
        System.out.println("FXML not found in classpath, trying source directory...");
        File file = new File("src/resources/FXML/" + fxml + ".fxml");
        if (file.exists()) {
            url = file.toURI().toURL();
            System.out.println("Loaded from source: " + file.getAbsolutePath());
        } else {
            throw new IOException("Cannot find FXML file: " + fxml + 
                ".fxml\nLooked in: " + path + " and " + file.getAbsolutePath());
        }
    } else {
        System.out.println("Loaded from classpath: " + url);
    }
    
    FXMLLoader fxmlLoader = new FXMLLoader(url);
    return fxmlLoader.load();
}

  // This method reads the food database and returns an ArrayList of Food objects
  public static ArrayList<Food> foodCategorizer(String category)  {
      Scanner sc;
      try {
          sc = new Scanner(new File("src/resources/text/foods.txt"));
          ArrayList<Food> Foods = new ArrayList<Food>();
          while(sc.hasNextLine()) {
              // if the line contains the category, the next 3 lines are the food's name, price, and restaurant
              if (sc.nextLine().contains(category)) {
                  String name = sc.nextLine().split("=")[1].replaceAll("^\\s+", "");
                  double price = Double.parseDouble(sc.nextLine().split("=")[1].replaceAll("^\\s+", ""));
                  String restaurant = sc.nextLine().split("=")[1].replaceAll("^\\s+", "");
                  Foods.add(new Food(name, price, restaurant));
              }
          }
          sc.close();
          return Foods;
      }
      catch(FileNotFoundException e) {
          System.out.println("Food Database not found");
          return null;
      }
  }
  
  // gets the category of food, and returns the appropriate ArrayList of Food objects
  public static ArrayList<Food> getCategory(String category) {
      switch(category) {
          case "Italian":
              return sThreeController.italian;
          case "American":
              return sThreeController.american;
          case "Mexican":
              return sThreeController.mexican;
          case "Chinese":
              return sThreeController.chinese;
          case "Japanese":
              return sThreeController.japanese;
          case "Indian":
              return sThreeController.indian;
          case "Korean":
              return sThreeController.korean;
          case "Polish":
              return sThreeController.polish;
          default:
              return null;
      }
  }
  
  // This method opens the first scene
  @Override
  public void start(Stage stage) throws Exception{
    scene = new Scene(loadFXML("loginPage"));
    stage.setScene(scene);
    stage.setWidth(610);
    stage.setHeight(440);
    stage.show();
  }

  // This is the main method
  public static void main(String[] args) throws Exception{
    launch(args);
  }

}