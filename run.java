public class run {

  private static Car c = new Car();
  private static Driver d = new Driver();
  private static Brand b = new Brand();
  private static Sponsor s = new Sponsor();

  public static void main(String[] args) {



    validateLogin();
  }

  public static void validateLogin() {
    final int max_attempts = 3;
    int attempts = 0;
    
    while (true) {
      attempts++;
      if (attempts > max_attempts) {
        x.println("");
        x.println("\033[32m\033[1mToo many login attempts. Please try again later.\033[0m\033[0m");
        System.exit(0);

      }else{
        x.println("\033[1m\033[31m--------------------------------------------------\033[0m\033[0m");
        x.println("\033[1m\033[31m******    LOGIN TO ABC CAR RACE EVENT    ******\033[0m\033[0m");
        x.println("\033[1m\033[31m--------------------------------------------------\033[0m\033[0m");

        try {
          String uName = x.input("Enter your user name: ");
          String pword = x.input("Enter your password: ");

          if (uName.equals("abc") && pword.equals("abc123")) {
            x.println("\033[32m\033[1mLogin Successful\033[0m\033[0m");

            while (true) {
              Data.fakeSponData();
              Data.fakeDriData();
              Data.fakeBranData();
              // Data.fakeCar();
              dashmenu();
            }

          } else {
              x.println("\033[1m\033[34mPlease enter the correct username or password...!\033[0m\033[0m");
          }
        } catch (NullPointerException nullP) {
            errorHand.errorHand(nullP);
        } catch (NumberFormatException nop) {
            errorHand.errorHand(nop);
        } catch (Exception ex) {
            errorHand.errorHand(ex);
        }
      }
    }  
}
 

  public static void dashmenu() {

    String carAscii = "                       ___\n" +
                     "                      / o \\ \n" +
                     "                     /   o \\\n" +
                     "                    /_______\\\n" +
                     "                    \033[41m\033[5m|[] * []|\n\033[0m\033[0m" +
                     "                  __|_______|__\n" +
                     "                 |:::::::::::::|\n" +
                     "                 `-===========-'";

    x.println(carAscii);
    x.println("\033[1m\033[31m--------------------------------------------------\033[0m\033[0m");
    x.println("\033[1m\033[5m******    WELCOME TO ABC CAR RACE EVENT    ******\033[0m\033[0m");
    x.println("--------------------------------------------------");
    x.print("\033[1m<1.Car> \033[0m");
    x.print("\033[1m<2.Driver> \033[0m");
    x.print("\033[1m<3.Brand> \033[0m");
    x.print("\033[1m<4.Sponsor> \033[0m");
    x.println("\033[1m<5.Exit> \033[0m");
    x.println("\033[1m\033[31m--------------------------------------------------\033[0m\033[0m");

    String opt = x.input("Enter Your Selection: ");
    while (true) {
      switch (opt) {
        case "1":
            c.menu();
            break;
        case "2": 
            d.menu();
            break;
        case "3":
            b.menu();
            break;
        case "4":
            s.menu();
            break;
        case "5":
            x.println("\033[32m\033[1mThank you for using our system...!\033[0m\033[0m");
            System.exit(0);
            break;
        default:
            break;
      }
    }
    
  }
}
 