package nl.novi.tictactoe;

public class Field {

    // Attributes
    private String token;
    private boolean isOccupied;

    // Constructors
    public Field(String token){
        this.token = token;
        // upon creating object status is false
        isOccupied = false;
    }

    // methods
        // setter
    public void setToken(String token){
        if (!isOccupied) {
            this.token = token;
        }
        isOccupied = true;
    }

        // getter
    public String getToken(){
        return token;
    }
}
