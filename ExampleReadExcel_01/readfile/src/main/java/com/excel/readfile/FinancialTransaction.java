package com.excel.readfile;

import java.time.LocalDate;

public class FinancialTransaction {
    private LocalDate operationDate;
    private LocalDate processingDate;
    private String description;
    private double movementValue;
    private double balance;

    // Constructors, getters, and setters
    public FinancialTransaction() {}

    public FinancialTransaction(LocalDate operationDate, LocalDate processingDate,
                                String description, double movementValue, double balance) {
        this.operationDate = operationDate;
        this.processingDate = processingDate;
        this.description = description;
        this.movementValue = movementValue;
        this.balance = balance;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public LocalDate getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(LocalDate processingDate) {
        this.processingDate = processingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMovementValue() {
        return movementValue;
    }

    public void setMovementValue(double movementValue) {
        this.movementValue = movementValue;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "FinancialTransaction{" +
                "operationDate=" + operationDate +
                ", processingDate=" + processingDate +
                ", description='" + description + '\'' +
                ", movementValue=" + movementValue +
                ", balance=" + balance +
                '}';
    }
}
