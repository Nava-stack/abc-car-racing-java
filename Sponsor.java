public class Sponsor {
  //Properties
  private String id;
  private String name;
  private String mail;
  
  //Getting Methods
  public String getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getMail() {
    return mail;
  }

  //Setting Methods
  public void setId(String id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setMail(String mail) {
    this.mail = mail;
  }


  public Sponsor() {
    
  }

  
  public Sponsor(String id,String name,String mail) {
    this.id = id;
    this.name = name;
    this.mail = mail;
  }


  public void Display(){
    x.println("ID : "+ this.id + " Name : " + this.name + " Mail : " + this.mail);
  }


  public static void DisplayAll(){
    x.println(" ");
    x.println("|SPONSORS|");
    for (Sponsor sr : Data.sponsors) {
      sr.Display();
    }
  }

  private static Sponsor searchDataByID(String id2){
    for (Sponsor s : Data.sponsors) {
      if (s.getId().equals(id2)) {
        return s;
      } 
    }
    return null;
  }

  public static Sponsor getSponsor() {
    DisplayAll();
    return searchDataByID(x.input("Enter the Sponsor ID :"));
  }

    //Save Functions
    public void saveDB(){
      Data.sponsors.add(this);
    }
  
    public void saveSponData(){
      this.id = x.input("Enter Sponsor ID : "); 
      this.name = x.input("Enter Sponsor Name: ");
      this.mail = x.input("Enter Sponsor Mail : ");   
     
      saveDB();
    }
  
//Menu Function
public void menu() {
       
  x.println(" ");
  x.println("\033[1m\033[34mHOME > SPONSOR \033[0m\033[0m"); 
  x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m"); 
  x.print("\033[1m<1.New Sponsor> \033[0m");
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
          saveSponData();
          break;
      case "2":
          //update();
          break;
          
      case "3":
          DisplayAll();
          break;
      case "4":
          //search();
          break;
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
