import java.util.ArrayList;
import java.util.List;

public class Data {
 
  //Lists
  public static List<Driver> drivers = new ArrayList<Driver>();
  public static List<Brand> brands = new ArrayList<Brand>();
  public static List<Sponsor> sponsors = new ArrayList<Sponsor>();
  
  //Array for storing car details
  public static Car car[]  = new Car[6];

  //Fake datas functions
  public static void fakeDriData(){
    x.println(" ");
    drivers.add(new Driver("D01", "Kumar", "1992033849", "25", "078204020", "DL029444"));
    drivers.add(new Driver("D02", "Hevan", "1995035484", "25", "076204520", "DL337453"));
    drivers.add(new Driver("D03", "Alash", "1992033435", "24", "077204025", "DL734834"));
    drivers.add(new Driver("D04", "kamal", "1993438472", "26", "078204324", "DL843783"));
    drivers.add(new Driver("D05", "Kapil", "1994438473", "26", "076204326", "DL273555"));
    drivers.add(new Driver("D06", "Rames", "1992438475", "26", "078223327", "DL443525"));
  }

  public static void fakeBranData(){
    brands.add(new Brand("B01","BMW","Britain"));
    brands.add(new Brand("B02","BENZ","USA"));
    brands.add(new Brand("B03","AUDI","Sweden"));
    brands.add(new Brand("B04","SUZUKI","India"));
  }

  public static void fakeSponData(){
    sponsors.add(new Sponsor("S01", "CocaCola", "coco9@outlook.com"));
    sponsors.add(new Sponsor("S02", "Milo", "milo1029@oulook.com"));
    sponsors.add(new Sponsor("S03", "PayTm", "paytm1203@gmail.com"));
  }

  // public static void fakeCar(){
  //   car[0] = new Car("C01",null,null,null); 
  //   car[1] = new Car("C02",null,null,null); 
  //   car[2] = new Car("C03",null,null,null); 
  //   car[3] = new Car("C04",null,null,null); 
  //   car[4] = new Car("C05",null,null,null); 
  //   car[5] = new Car("C06",null,null,null); 
  // }

}
