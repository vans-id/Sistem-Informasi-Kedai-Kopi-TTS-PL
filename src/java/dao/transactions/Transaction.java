package dao.transactions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author IdeaPad
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction implements Serializable {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "timestamp")
    private String timestamp;
    @Column(name = "description")
    private String description;
    
    public Transaction() {}
    
    public Transaction(int id, String timestamp, String description) {
        this.id = id;
        this.timestamp = timestamp;
        this.description = description;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
