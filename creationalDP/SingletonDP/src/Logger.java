import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static Logger logger;

    private static Object lock = new Object();
    private Logger() {}
    public static synchronized  Logger getInstance() {
        if(logger==null){
            synchronized(lock) {
                if(logger==null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }
    public void log(String msg){
        synchronized(lock) {
            try {
                FileWriter fw = new FileWriter("log.txt", true);
                String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                fw.write(timestamp + ": " + msg + "\n");
                fw.close();
                System.out.println(msg);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
