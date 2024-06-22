public class Driver {
  //Properties
  private String id;
  private String name;
  private String nic;
  private String age;
  private String contact;
  private String Lisence_no;
   
  //Getting Methods
  public String getId() {
     return id;
   }
  public String getName() {
     return name;
   }
  public String getNic() {
     return nic;
   }
  public String getAge() {
     return age;
   }
  public String getContact() {
     return contact;
   }
  public String getLisence_no() {
     return Lisence_no;
   }
 
  //Setting Methods
  public void setId(String id) {
     this.id = id;
   }
  public void setName(String name) {
     this.name = name;
   }
  public void setNic(String nic) {
     this.nic = nic;
   }
  public void setAge(String age) {
     this.age = age;
   }
  public void setContact(String contact) {
     this.contact = contact;
   }
  public void setLisence_no(String lisence_no) {
     Lisence_no = lisence_no;
   }
 
  //Empty Constructor
  public Driver(){

   }
   
  //Constructor
  public Driver(String id,String name,String NIC,String age,String contact,String Lisence_no){
    this.id = id;
    this.name = name;
    this.age = age;
    this.nic = NIC;
    this.contact = contact;
    this.Lisence_no = Lisence_no; 
  }
 
  //Display Functions
  public void Display(){
     x.println("ID : "+ this.id + " Name : " + this.name + " NIC : " + this.nic + " Age : " + this.age + " Contact : " + this.contact + " Lisence No : " + this.Lisence_no );
   }
  
  public static void DisplayAll(){
    x.println(" ");
    x.println("|DRIVER|");
     for (Driver dr : Data.drivers) {
       dr.Display();
     }
  }
 
  //Search Functions
  private static Driver searchDataByID(String drId){
    for (Driver d : Data.drivers) {
      if (d.getId().equals(drId)) {
        return d;
      } 
    }
    return null;
  }
  
  public void search() {
    Driver driver = searchDataByID(x.input("Enter the Driver ID : "));      
      if (driver != null) {
        driver.Display();
      } 
      else {
        x.println("Invalid Car Unique number");   
      }
  }

  //Get Driver Object
  public static Driver getDriver() {
     DisplayAll();
     return searchDataByID(x.input("Enter the Driver ID :"));
   }

  //Save Functions
  public void saveDB(){
    Data.drivers.add(this);
  }

  public void saveDriData(){
    this.id = x.input("Enter your ID : "); 
    this.name = x.input("Enter your name: ");
    this.age = x.input("Enter your age : "); 
    this.nic = x.input("Enter your NIC : ");
    this.contact = x.input("Enter your contact no : "); 
    this.Lisence_no = x.input("Enter your Lisence no : ");      
    saveDB();
  }



  //Update Function
  public void update(){
      Driver driver = searchDataByID(x.input("Enter the Driver ID: "));
      
      for (Driver d : Data.drivers) {
        if (driver.id == d.getId()) {
          

          x.println("Updated Successfully");
        }
        else{
          x.println("Invalid Data");
        }
      }
  }

 
  public void delete(){
    for (Driver d : Data.drivers) {
      if(d.getId() == id){
        Data.drivers.remove(d);
        x.println("Deleted Successfully");
        break;
      }
      else{
        x.println("Invalid Data");
      }
    }
  }

//Menu Function
public void menu() {
       
  x.println(" ");
  x.println("\033[1m\033[34mHOME > DRIVER \033[0m\033[0m"); 
  x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m"); 
  x.print("\033[1m<1.New Driver> \033[0m");
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
          saveDriData();
          break;
      case "2":
          update();
          break;
      case "3":
          DisplayAll();
          break;
      case "4":
          search();
          break;
      case "5":
          //delete();
      case "6":
          run.dashmenu();        

      default:
          break;
  }
}
}
