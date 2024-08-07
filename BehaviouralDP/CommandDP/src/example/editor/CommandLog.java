package example.editor;

import java.util.ArrayList;
import java.util.List;

public class CommandLog {
    List<String> logs;

    public CommandLog(){
        logs = new ArrayList<>();
    }

    public void log(String logMessage){
        logs.add(logMessage);
    }

    public void printLogs(){
        System.out.println("Command logs:");
        for(String log: logs){
            System.out.println(log);
        }
    }

    public void clear(){
        logs.clear();
    }
}
