package com.example.javademo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bank_accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BankAccount {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id; 
	
	@Column(name = "accountNumber")
	 private String accountNumber;
	
	@Column(name = "accountType")
	private String accountType; //savings,current etc.
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
