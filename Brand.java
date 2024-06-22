public class Brand {
  //Properties
  private String id;
  private String name;
  private String location;
  
  //Getting Methods
  public String getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getLocation() {
    return location;
  }

  //Setting Methods
  public void setId(String id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setLocation(String location) {
    this.location = location;
  }


  //Empty Constructor
  public Brand(){

  }
 //Constructor
  public Brand(String id,String name,String loc){
    this.id = id;
    this.name = name;
    this.location = loc;
  }

  //Diplay Functions
  public void Display(){
    x.println("ID : "+ this.id + " Name : " + this.name + " Location : " + this.location);
  }

  public static void DisplayAll(){
    x.println(" ");
    x.println("|BRAND|");
    for (Brand br : Data.brands) {
      br.Display();
    }
  }

  //Search Functions
  private static Brand searchDataByID(String brId){
    for (Brand b : Data.brands) {
      if (b.getId().equals(brId)) {
        return b;
      } 
    }
    return null;
  }

  public static Brand getBrand() {
    DisplayAll();
    return searchDataByID(x.input("Enter the Brand ID :"));
  }

  public void search() {
    Brand brand = searchDataByID(x.input("Enter the Brand ID : "));      
      if (brand != null) {
        brand.Display();
      } 
      else {
        x.println("Invalid Brand ID");   
      }
  }


  //Save Functions
  public void saveDB(){
    Data.brands.add(this);
  }

  public void saveBrandData(){
    this.id = x.input("Enter Brand ID : "); 
    this.name = x.input("Enter Brand name : ");
    this.location = x.input("Enter Brand Location : ");   
   
    saveDB();
  }

//Menu Function
public void menu() {
       
  x.println(" ");
  x.println("\033[1m\033[34mHOME > BRAND \033[0m\033[0m"); 
  x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m"); 
  x.print("\033[1m<1.New Brand> \033[0m");
  x.print("\033[1m<2.Update> \033[0m");
  x.print("\033[1m<3.Show> \033[0m");
  x.println("\033[1m<4.Find> \033[0m");
  x.print("\033[1m<5.Delete> \033[0m");
  x.print("\033[1m<6.Main Menu> \033[0m");
  x.println("\033[1m<7.Exit> \033[0m");
  x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m");      

  
  String opt = x.input("Enter Your Selection: ");
  switch (opt) {
      case "1":
          saveBrandData();
          break;
      case "2":
          //update();
          break;
          
      case "3":
          DisplayAll();
          break;
      case "4":
          search();
      case "5":
          //delete();
          break;
      case "6":
          run.dashmenu();   
          break;     

      default:
          break;
  }
}


}
