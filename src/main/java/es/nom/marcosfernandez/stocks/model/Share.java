package es.nom.marcosfernandez.stocks.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@NoArgsConstructor
@Data
@Document
public class Share {

    @Id
    private String id;

    private String tick;

    private String name;

    private Date date;

    private Double price;

    private Long volume;

    private Double todayHigh;

    private Double todayLow;

    private Double previousClose;

    private Double yearHigh;

    private Double yearLow;

    public Share(String tick, String name, Date date, Double price, Long volume, Double todayHigh, Double todayLow, Double previousClose, Double yearHigh, Double yearLow) {
        this.tick = tick;
        this.name = name;
        this.date = date;
        this.price = price;
        this.volume = volume;
        this.todayHigh = todayHigh;
        this.todayLow = todayLow;
        this.previousClose = previousClose;
        this.yearHigh = yearHigh;
        this.yearLow = yearLow;
    }

    public Share(String tick) {
        this.tick = tick;
    }
}
