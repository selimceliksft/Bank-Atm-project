package com.model;
import java.sql.Date;
import java.util.Scanner;

//import org.apache.commons.lang3.time.StopWatch; // package need download

public class Session{

    private int idCounter = 0;
    private final int sessionID;
    private final Date sessionStart;
    private Date sessionEnd;

    Scanner keyboard =  new Scanner(System.in);

    public Session(){
        idCounter ++;
        sessionID = idCounter;
        sessionStart = new Date(System.currentTimeMillis());  
        //countTime(); 
    }

    public void SessionEnd(){
        sessionEnd = new Date(System.currentTimeMillis());
    }
    /* 
    public void countTime(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        while(stopWatch.getTime() < 60000){ // this needs to work in background.
            if(keyboard.next().isEmpty()){
                continue;
            }
            else{
                break;
            }
        }

        stopWatch.stop();
    }
    */

    public int getSessionID(){
        return sessionID;
    }
    public Date getSessionStart(){
        return sessionStart;
    }
    public Date getSessionEnd() throws IllegalStateException {
        if (sessionEnd == null) {
            throw new IllegalStateException("Session end time has not been set");
        }
        return sessionEnd;
    }


}