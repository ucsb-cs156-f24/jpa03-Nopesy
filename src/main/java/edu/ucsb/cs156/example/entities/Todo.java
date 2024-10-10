package edu.ucsb.cs156.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 * This is a JPA entity that represents a todo.
 * 
 * A "todo" is a task that a user wants to accomplish.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "todos")
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  // This establishes that many todos can belong to one user
  // Only the user_id is stored in the table, and through it we
  // can access the user's details

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  private String title;
  private String details;
  private boolean done;
}