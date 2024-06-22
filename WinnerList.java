public class WinnerList {
     
    int SIZE = 6;
    Car myCars [] = new Car[SIZE];
    int front, rear;

    WinnerList(){
        front = -1;
        rear = -1;
    }

    // check if the winner_list is full
    public boolean isFull(){
        if(front == 0 && rear == SIZE - 1){
            return true;
        }
        return false;
    }

    // check if the winnerlist is empty
    public boolean isEmpty(){
        if(front== -1){
            return true;
        }
        else
            return false;
    }

    //insert elements to the winnerList
    public void addWinner(Car c){
        //if winnerList is full
        if(isFull()){
            x.println("winnerList is full");
        }
        else{
            if(front == -1){
                //mark front denote first element of winnerList
                front = 0;
            }
            rear++;
            //insert element at the rear
            myCars[rear] = c;
            // x.println("Insert" + c.getUniqueNo());
        }
    }

    //delete element from the winnerList
    Car getWinner(){
        Car c;
        //if winnerList is empty
        if(isEmpty()){
            x.println("WinnerList is empty");
            return null;
        }else{
            //remove element from the front of winnerList
            c = myCars[front];
            //if the winnerList has only one element
            if(front>=rear){
                front = -1;
                rear = -1;
            }
            else{
                //mark next element as the front
                front++;
            }
            return(c);
        }
    }

    //display element of the winnerlist
    public void display(){
        int i;
        if(isEmpty()){
            x.println("Empty winnerList");
        }
        else{
            x.println("winner list");
            x.println("================");
            for (i = front; i<=rear ; i++) {
                myCars[i].display();
            }
        }
    }
}