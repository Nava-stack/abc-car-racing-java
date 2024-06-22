import java.util.NoSuchElementException;

public class Car {
   
    //Properties
    private String uniqueNo;
    private Driver driver;
    private Brand brand;
    private Sponsor sponsor;
    private float totalTime;
    private float[] roundFinishTime = new float[3];


    //Constructor 
    public Car(String uniqueNo,Brand brand,Driver driver,Sponsor sponsor){
        this.uniqueNo = uniqueNo;
        this.brand = brand;
        this.driver = driver;
        this.sponsor = sponsor;
    }

    //Empty Constructor
    public Car(){
        
    }

    //Getting Methods
    public String getUniqueNo() {
      return uniqueNo;
    }
    public Brand getBrand() {
      return brand;
    }
    public Driver getDriver() {
      return driver;
    }
    public Sponsor getSponsor() {
      return sponsor;
    }
    public float getTotalTime() {
      return totalTime;
    }


    //Setting Methods
    public void setUniqueNo(String uniqueNo) {
      this.uniqueNo = uniqueNo;
    }
    public void setBrand(Brand brand) {
      this.brand = brand;
    }
    public void setDriver(Driver driver) {
      this.driver = driver;
    }
    public void setSponsor(Sponsor sponsor) {
      this.sponsor = sponsor;
    }
    public void setTotalTime(float totalTime) {
      this.totalTime = totalTime;
    }
    
    //SAVE Functions
    public void save() {
        try {
            boolean registered = false;
            for (int i = 0; i < Data.car.length; i++) {
                if (Data.car[i] == null) {
                    Data.car[i] = new Car(); // Create a new Car object for each registration
                    Data.car[i].setUniqueNo(this.getUniqueNo()); // Set the unique number for the car
                    Data.car[i].setDriver(this.getDriver()); // Set the driver for the car
                    Data.car[i].setSponsor(this.getSponsor()); // Set the sponsor for the car
                    Data.car[i].setBrand(this.getBrand()); // Set the brand for the car
                    
                    registered = true;
                    x.println("\033[32m\033[1mSuccessfully Registered...!\033[0m\033[0m");
                    x.println(" ");
                    break;
                }
            }
            if (!registered) {
                x.println("\033[31m\033[1mEvent is fully registered, can't add any car now...!\033[0m\033[0m");
            }
        } catch (ArrayIndexOutOfBoundsException ai) {
            errorHand.errorHand(ai);
        } catch (NullPointerException nulp) {
            errorHand.errorHand(nulp);
        } catch (NoSuchElementException noel) {
            errorHand.errorHand(noel);
        } catch (Exception ex) {
            errorHand.errorHand(ex);
        } finally {
            //menu();
        }
    }
    
    public void addCar(Car car) {
        try {
            if (Data.car[Data.car.length - 1] != null) {
                x.println("\033[31m\033[1mEvent is fully registered, can't add any car now...!\033[0m\033[0m");
                return;
            } else {
                car.setUniqueNo(x.input("Enter Car Unique Number: "));
                car.setDriver(Driver.getDriver());
                car.setSponsor(Sponsor.getSponsor());
                car.setBrand(Brand.getBrand());
                
                x.println(" ");
                String opt = x.input("Do you want to add another car [y/n]? ");
                if (opt.equals("y")) {
                    car.save();
                    addCar(new Car()); // Create a new Car object for the next car registration
                } else {
                    car.save();
                    menu();
                }
            }
        } catch (NullPointerException nulp) {
            errorHand.errorHand(nulp);
        } catch (NoSuchElementException noel) {
            errorHand.errorHand(noel);
        } catch (Exception ex) {
            errorHand.errorHand(ex);
        } finally {
            menu();
        }
    }
    
    public void saveAll() {
        addCar(new Car());
    }

    //Search Function
    private static Car searchDataById(String uniqueNo) {
        for (Car car : Data.car) {
            if (car.getUniqueNo().equals(uniqueNo)) {
                return car;
            }
        }
        return null;
    }

    public void search() {
        try {
            Car car = searchDataById(x.input("Enter Car Unique Number: "));      
            if (car!=null) {
               car.display();
            } else {
               x.println("\033[31m\033[1mInvalid Car Unique number...!\033[0m\033[0m");   
            }
        } catch (ArrayIndexOutOfBoundsException ai) {
            errorHand.errorHand(ai);
        } catch (NullPointerException nullp){
            errorHand.errorHand(nullp);
        } catch (Exception ex){
            errorHand.errorHand(ex);
        }
        finally{
            menu();
        }
    }

    //Update Function
    public void update(){
        try {
            Car car = searchDataById(x.input("Enter Car unique number: "));
            
            if (car != null) {
                car.setBrand(Brand.getBrand());
                car.setDriver(Driver.getDriver());
                car.setSponsor(Sponsor.getSponsor());
                
                x.println("\033[32m\033[1mUpdated Successfully...!\033[0m\033[0m");
            }
            else{
                x.println("\033[31m\033[1mInvalid Data provided...!\033[0m\033[0m");
            }
        } catch (ArrayIndexOutOfBoundsException ai) {
            errorHand.errorHand(ai);
        } catch (NullPointerException nullp){
            errorHand.errorHand(nullp);
        } catch (Exception ex){
            errorHand.errorHand(ex);
        }
        finally{
            menu();
        }
    }

    
    // Diplay Functions
    public static void DisplayAll() {
        if (isEmpty()) {
            x.println("\033[31m\033[1mCars not added in the list yet...!\033[0m\033[0m");
        } else {
            for (int i = Data.car.length - 1; i >= 0; i--) {
                if (Data.car[i] != null) {
                    Data.car[i].display();
                }
            }
        }
    }

    public static boolean isEmpty() {
        for (Car car : Data.car) {
            if (car != null) {
                return false;
            }else{
                x.println("\033[31m\033[1mCars not added in the list yet...!\033[0m\033[0m");
            }
        }
        return true;
    }

    public void display() {
        x.println("Car Unique Number: [" + uniqueNo + "] Driver : [" + driver.getName() + "] Brand : [" + brand.getName() + "] Sponsor : [" + sponsor.getName() + "]");
    }

    // Getting Car Object
    public static Car getCar(String id) {
        return searchDataById(id);
    }
            
    // Delete Function with Pop
    public static void delete() {
        try {
            boolean status = true;
            String uniqueNo = x.input("Enter Car Unique Number: ");
                
            for (int i = 0; i < Data.car.length; i++) {
                if (isEmpty() == false) {
                    if (Data.car[i].getUniqueNo().equals(uniqueNo)) {
                        Data.car[i] = null;
                        x.println("\033[32m\033[1mCar Deleted Successfully...!\033[0m\033[0m");
                        // Pop operation: Shift the array to remove the null elements
                        valueTransform(i);
                        status = false;
                        break;  
                    }
                }
            }
            if(!status){
                String ch = x.input("Invalid Data. Do you want to try again [y/n]?: ");
                if (ch.toLowerCase().equals("y")) {
                    delete();
                }
            }
        }
            catch (ArrayIndexOutOfBoundsException ai) {
            errorHand.errorHand(ai);
        } catch (NullPointerException nullp) {
            errorHand.errorHand(nullp);
        } catch (Exception ex) {
            errorHand.errorHand(ex);
        } finally {
            x.println(" ");
            x.println("|CARS LIST|");
            DisplayAll();
        }
    }

    //Changes the value of elements in index position from the deleted positon
    public static void valueTransform(int dltIndex) {
        for (int i = dltIndex; i < Data.car.length-1; i++) {
            Data.car[i]= Data.car[i+1];
            Data.car[i+1] = null;
        }
    }

    //Adding Each Round - Results
    public void addRoundResult() {
        try {
            if (Car.isEmpty()) {
                x.println("Please add all 6 cars in the race list...");
                return;
            }
            for (int i = 0; i < Data.car.length; i++) {
                String uniqueNo = Data.car[i].getUniqueNo(); // Get the unique number of the current car
                x.println("\033[1m|<< " + uniqueNo + " >>|\033[0m ");
                Data.car[i].setTotalTime(0);
                for (int j = 0; j < roundFinishTime.length; j++) {
                    x.print(" ");
                    float roundTime = x.inputFloat("Round [" + (j + 1) + "] finished time:");
                    Data.car[i].roundFinishTime[j] = roundTime;
                    Data.car[i].setTotalTime(getTotalTime() + roundTime); // Add the round finish time to the total time for the current car
                }
                
            }
            
            x.println("\033[32m\033[1mSuccessfully added Round results...!\033[0m\033[0m");
            x.println(" ");
            findWinner();


        } catch (ArrayIndexOutOfBoundsException ai) {
            errorHand.errorHand(ai);
        } catch (NullPointerException nullp) {
            errorHand.errorHand(nullp);
        } catch (Exception ex) {
            errorHand.errorHand(ex);
        }
    }
    
    // Bubble Sort
    public static void bubbleSort(){
        for (int i = 0; i < Data.car.length - 1; i++) {
            for (int j = 0; j < Data.car.length - i - 1; j++) {
                if (Data.car[j].getTotalTime() > Data.car[j + 1].getTotalTime()) {
                    Car temp = Data.car[j];
                    Data.car[j] = Data.car[j + 1];
                    Data.car[j + 1] = temp;
                }
            }
        }
    }
    
    // Selection Sort
    public static void selectionSort(){
        for (int i = 0; i < Data.car.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < Data.car.length; j++) {
                if (Data.car[j].getTotalTime() < Data.car[minIndex].getTotalTime()) {
                    minIndex = j;
                }
            }
            Car temp = Data.car[i];
            Data.car[i] = Data.car[minIndex];
            Data.car[minIndex] = temp;
        }
    }

    public static WinnerList setWinner() {
        WinnerList winnerList = new WinnerList();
        String sort = x.input("Winner Sorting Method [ Bubble(b) / Selection(s) ]:");
        if (sort.equals("b")) {
            bubbleSort();
        }
        else if(sort.equals("s")){
            selectionSort();
        }
        for (Car c : Data.car) {
            winnerList.addWinner(c);
        }
        return winnerList;
    }

    public void findWinner() {
        WinnerList w = setWinner();
        x.println("");
        x.println("\033[32m\033[1m|====================================== First Place ======================================|\033[0m\033[0m");
        w.getWinner().display();
        x.println("");
        x.println("\033[32m\033[1m|====================================== Second Place =====================================|\033[0m\033[0m");
        w.getWinner().display();
        x.println("");
        x.println("\033[32m\033[1m|====================================== Third Place ======================================|\033[0m\033[0m");
        w.getWinner().display();
    }

    // public void winnerList(){
    //     String sort = x.input("Winner Sorting Method [ Bubble(b) / Selection(s) ]:");
    //     if (sort.equals("b")) {
    //         bubbleSort();
    //     }
    //     else if(sort.equals("s")){
    //         selectionSort();
    //     }
    //     // x.println("\033[32m\033[1m|====================================== Winners List =====================================|\033[0m\033[0m");
    //     // for (int i = 0; i < 3; i++) {
    //     //     if (Data.car[i] != null) {
    //     //         x.println("\033[1m|<< " + Data.car[i].getUniqueNo() + " >>|\033[0m ");
    //     //         Data.car[i].display();
    //     //         x.println("");
    //     //     }
    //     // }
    //     x.println("\033[32m\033[1m|====================================== First Place ======================================|\033[0m\033[0m");
    //     Data.car[0].display();
    //     x.println("");
    //     x.println("\033[32m\033[1m|====================================== Second Place =====================================|\033[0m\033[0m");
    //     Data.car[1].display();
    //     x.println("");
    //     x.println("\033[32m\033[1m|====================================== Third Place ======================================|\033[0m\033[0m");
    //     Data.car[2].display();
    //     x.println("");
    // }

    //Menu Function
    public void menu() {

        x.println(" ");
        x.println("\033[1m\033[34mHOME > CAR \033[0m\033[0m"); 
        x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m"); 
        x.print("\033[1m<1.Register> \033[0m");
        x.print("\033[1m<2.Update> \033[0m");
        x.print("\033[1m<3.Show> \033[0m");
        x.println("\033[1m<4.Find Car> \033[0m");
        x.print("\033[1m<5.Delete> \033[0m");
        x.print("\033[1m<6.Find Winner> \033[0m");
        x.print("\033[1m<7.Main Menu> \033[0m");
        x.println("\033[1m<8.Exit> \033[0m");
        x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m");      

        
        String opt = x.input("Enter Your Selection: ");
        switch (opt) {
            case "1":
                x.println(" ");
                x.println("\033[1m\033[34mHOME > CAR > REGISTER \033[0m\033[0m"); 
                x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m");
                saveAll();
                break;
            case "2":
                x.println(" ");
                x.println("\033[1m\033[34mHOME > CAR > UPDATE \033[0m\033[0m"); 
                x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m");
                update();
                break;
            case "3":
                x.println(" ");
                x.println("\033[1m\033[34mHOME > CAR > SHOW \033[0m\033[0m"); 
                x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m");
                DisplayAll();
                break;
            case "4":
                x.println(" ");
                x.println("\033[1m\033[34mHOME > CAR > FIND CAR \033[0m\033[0m"); 
                x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m");
                search();
                break;
            case "5":
                x.println(" ");
                x.println("\033[1m\033[34mHOME > CAR > DELETE \033[0m\033[0m"); 
                x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m");
                delete();
                break;
            case "6":
                x.println(" ");
                x.println("\033[1m\033[34mHOME > CAR > FIND WINNER \033[0m\033[0m"); 
                x.println("\033[1m\033[34m--------------------------------------------------\033[0m\033[0m");
                addRoundResult();
                break;
            case "7":
                run.dashmenu();
                break;
            case "8":
                System.exit(0);
                break;
            default:
                break;
        }
    }
}