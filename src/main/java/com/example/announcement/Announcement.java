package com.example.announcement;

import jakarta.persistence.*;

@Entity
@Table(name = "announcements")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String message;

	public Announcement(Long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}

    // Getters and setters
    public Announcement() {
    	
    }
    
    public Announcement(String message) {
    	this.message=message;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
}
