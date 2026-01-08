import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class sThreeController implements Initializable{


    // ArrayList for each country's food
    static ArrayList<Food> italian = App.foodCategorizer("Italian");
    static ArrayList<Food> american = App.foodCategorizer("American");
    static ArrayList<Food> mexican = App.foodCategorizer("Mexican");
    static ArrayList<Food> chinese = App.foodCategorizer("Chinese");
    static ArrayList<Food> japanese = App.foodCategorizer("Japanese");
    static ArrayList<Food> indian = App.foodCategorizer("Indian");
    static ArrayList<Food> korean = App.foodCategorizer("Korean");
    static ArrayList<Food> polish = App.foodCategorizer("Polish");
    
    // Cart for food items
    static ArrayList<Food> cart = new ArrayList<Food>();

    @FXML
    private ComboBox<String> categories;

    @FXML
    private BorderPane root;

    @FXML
    private AnchorPane center;

    @FXML
    private ImageView bg, img1, img2, img3;

    @FXML
    private Text food1, food2, food3, confirmation;

    // button for 1st food item
    @FXML
    private void button1(ActionEvent e) throws Exception{
        String category = (String) categories.getValue();
        Food food = App.getCategory(category).get(0);
        cart.add(food);
        sFourController.order.add(food);
        confirmation.setText(food.getName() + " added to cart");
        sTwoController.fadeOut(confirmation, 1000);
    }

    // button for 2nd food item
    @FXML
    private void button2(ActionEvent e) throws Exception{
        String category = (String) categories.getValue();
        Food food = App.getCategory(category).get(1);
        cart.add(food);
        sFourController.order.add(food);
        confirmation.setText(food.getName() + " added to cart");
        sTwoController.fadeOut(confirmation, 1000);
    }
    
    // button for 3rd food item
    @FXML
    private void button3(ActionEvent e) throws Exception{
        String category = (String) categories.getValue();
        Food food = App.getCategory(category).get(2);
        cart.add(food);
        sFourController.order.add(food);
        confirmation.setText(food.getName() + " added to cart");
        sTwoController.fadeOut(confirmation, 1000);
    }
    
    // takes user to cart menu
    @FXML
    private void viewCart(ActionEvent e) throws Exception{
        App.setRoot("cart");
    }

    // takes user to login page
    @FXML
    private void logout(ActionEvent e) throws Exception{
        App.setRoot("loginPage");
    }

    // combobox for each country's food
    @FXML
    private void pickCategory(ActionEvent e) {
        // images food and country images are loaded depending on which country is selected
        String category = (String) categories.getValue(); 
        if (category.equals("Italian")) {
            food1.setText(italian.get(0).getName() + " $" + italian.get(0).getPrice());
            food2.setText(italian.get(1).getName() + " $" + italian.get(1).getPrice());
            food3.setText(italian.get(2).getName() + " $" + italian.get(2).getPrice());
            bg.setImage(new Image("resources/Images/italy.png"));
            img1.setImage(new Image("resources/Images/pizza.jpg"));
            img2.setImage(new Image("resources/Images/spaghetti.jpg"));
            img3.setImage(new Image("resources/Images/lasagna.jpg"));        
        }
        else if (category.equals("American")) {
            food1.setText(american.get(0).getName() + " $" + american.get(0).getPrice());
            food2.setText(american.get(1).getName() + " $" + american.get(1).getPrice());
            food3.setText(american.get(2).getName() + " $" + american.get(2).getPrice());
            bg.setImage(new Image("resources/Images/mexico.png"));
            img1.setImage(new Image("resources/Images/burritto.jpg"));
            img2.setImage(new Image("resources/Images/enchilada.jpg"));
            img3.setImage(new Image("resources/Images/taco.jpg"));
        }
        else if (category.equals("Mexican")) {
            food1.setText(mexican.get(0).getName() + " $" + mexican.get(0).getPrice());
            food2.setText(mexican.get(1).getName() + " $" + mexican.get(1).getPrice());
            food3.setText(mexican.get(2).getName() + " $" + mexican.get(2).getPrice());
            bg.setImage(new Image("E:\\School\\Java Projects\\GUICulminating\\src\\resources\\Images\\mexico.png"));
            img1.setImage(new Image("E:\\School\\Java Projects\\GUICulminating\\src\\resources\\Images\\burritto.jpg"));
            img2.setImage(new Image("E:\\School\\Java Projects\\GUICulminating\\src\\resources\\Images\\enchilada.jpg"));
            img3.setImage(new Image("E:\\School\\Java Projects\\GUICulminating\\src\\resources\\Images\\taco.jpg"));
        }
        else if (category.equals("Chinese")) {
            food1.setText(chinese.get(0).getName() + " $" + chinese.get(0).getPrice());
            food2.setText(chinese.get(1).getName() + " $" + chinese.get(1).getPrice());
            food3.setText(chinese.get(2).getName() + " $" + chinese.get(2).getPrice());
            bg.setImage(new Image("resources/Images/china.jpg"));
            img1.setImage(new Image("resources/Images/dumpling.jpg"));
            img2.setImage(new Image("resources/Images/chowmein.jpg"));
            img3.setImage(new Image("resources/Images/tofu.jpg"));
        }
        else if (category.equals("Japanese")) {
            food1.setText(japanese.get(0).getName() + " $" + japanese.get(0).getPrice());
            food2.setText(japanese.get(1).getName() + " $" + japanese.get(1).getPrice());
            food3.setText(japanese.get(2).getName() + " $" + japanese.get(2).getPrice());
            bg.setImage(new Image("resources/Images/japan.png"));
            img1.setImage(new Image("resources/Images/sushi.jpg"));
            img2.setImage(new Image("resources/Images/sashimi.png"));
            img3.setImage(new Image("resources/Images/ramen.jpg"));
        }
        else if (category.equals("Indian")) {
            food1.setText(indian.get(0).getName() + " $" + indian.get(0).getPrice());
            food2.setText(indian.get(1).getName() + " $" + indian.get(1).getPrice());
            food3.setText(indian.get(2).getName() + " $" + indian.get(2).getPrice());
            bg.setImage(new Image("resources/Images/india.png"));
            img1.setImage(new Image("resources/Images/tikkamasala.jpg"));
            img2.setImage(new Image("resources/Images/butterchicken.jpg"));
            img3.setImage(new Image("resources/Images/biryani.jpg"));
        }
        else if (category.equals("Korean")) {
            food1.setText(korean.get(0).getName() + " $" + korean.get(0).getPrice());
            food2.setText(korean.get(1).getName() + " $" + korean.get(1).getPrice());
            food3.setText(korean.get(2).getName() + " $" + korean.get(2).getPrice()); 
            bg.setImage(new Image("resources/Images/korea.jpg"));
            img1.setImage(new Image("resources/Images/kimchi.jpg"));
            img2.setImage(new Image("resources/Images/bibimbap.jpg"));
            img3.setImage(new Image("resources/Images/redricecake.png"));
        }
        else if (category.equals("Polish")) {
            food1.setText(polish.get(0).getName() + " $" + polish.get(0).getPrice());
            food2.setText(polish.get(1).getName() + " $" + polish.get(1).getPrice());
            food3.setText(polish.get(2).getName() + " $" + polish.get(2).getPrice()); 
            bg.setImage(new Image("resources/Images/poland.png"));
            img1.setImage(new Image("resources/Images/perogies.jpg"));
            img2.setImage(new Image("resources/Images/cabbagerolls.jpg"));
            img3.setImage(new Image("resources/Images/gulasz.jpg"));
        }
       
    }
// runs when scene is initialized
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // combobox ooptions created
        categories.getItems().addAll("American" , "Japanese", "Chinese", "Italian", "Mexican", "Indian", "Korean", "Polish");
        
        // initial images and food names/images are set
        categories.getSelectionModel().select(0);
        food1.setText(american.get(0).getName() + " $" + american.get(0).getPrice());
        food2.setText(american.get(1).getName() + " $" + american.get(1).getPrice());
        food3.setText(american.get(2).getName() + " $" + american.get(2).getPrice());
        bg.setImage(new Image(getClass().getResource("resources/Images/usa.jpg").toExternalForm()));
        img1.setImage(new Image("resources/Images/cheeseburger.jpg"));
        img2.setImage(new Image("resources/Images/hotdog.jpg"));
        img3.setImage(new Image("resources/Images/applepie.jpg"));     
    }
}




