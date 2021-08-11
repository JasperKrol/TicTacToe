package nl.novi.tictactoe;

public class Player {

    // Attributes
        // save the values
    private String name;
    private String token;
    private int score;

    // Constructors - start of the class
    public Player(String name, String token){
        //save values from parameters to
        this.name = name;
        this.token = token;
        this.score = 0;
    }

    // Functions/Methods
        // getters
    public int getScore(){
        return this.score;
    }
    public String getName(){
        return this.name;
    }
    public String getToken(){
        return this.token;
    }

        // setters
    public void setScore(int extraPoints){
        score = score + extraPoints;
    }
}
