package model.exceptions;

public class GraphTypeNotAllowed extends RuntimeException{

    public GraphTypeNotAllowed(String message){
        super(message);
    }

    @Override
    public String toString(){
        return getMessage();
    }
}
