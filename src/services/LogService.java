package services;

import utils.MongoDBUtil;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

public class LogService {

    private final MongoCollection<Document> logCollection;

    public LogService() {
        MongoDatabase db = MongoDBUtil.getDatabase();
        logCollection = db.getCollection("logs");
    }

    public void info(String message) {
        write("INFO", message, null);
    }

    public void error(String message, Throwable ex) {
        write("ERROR", message, stacktrace(ex));
    }

    private void write(String level, String message, String stacktrace) {
        Document doc = new Document()
                .append("level", level)
                .append("message", message)
                .append("stacktrace", stacktrace)
                .append("timestamp", LocalDateTime.now().toString());

        logCollection.insertOne(doc);
    }

    private String stacktrace(Throwable ex) {
        if (ex == null) return null;
        StringWriter sw = new StringWriter();
        ex.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}

