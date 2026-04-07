/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */

import java.util.Scanner;

public class TicketMachine
{
    
     Scanner sc = new Scanner(System.in);
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine(int ticketCost)
    {
        
        if (ticketCost <= 0) {
            System.out.println("Aviso: O preço do bilhete deve ser maior que zero. Definindo preço para 1.");
            this.price = 1; // Define um preço padrão seguro.
        } else {
            this.price = ticketCost;
        }

        this.balance = 0;
        this.total = 0;
    }

    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer.
     */
    public void insertMoney(int amount)
    {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Não é possível inserir valores negativos. Por favor, insira um valor positivo.");
        }
    }

    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        if (balance < price) {
            int needed = price - balance;
            System.out.println("Erro: Saldo insuficiente. Faltam " + needed + " centavos para comprar o bilhete.");
            return;
        }
        
        // Simulate the printing of a ticket.
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();

        int change = balance - price;
       total = total + price;

        if (change > 0) {
            System.out.println("Seu troco é: " + change + " centavos.");
        }
        balance = 0;
    }
    public int emptyMachine()
    {
        int collected = total;
        total = 0;
        return collected;
    }
}}
