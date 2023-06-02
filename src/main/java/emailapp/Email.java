package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail;
    private String companySuffix = "company.com";
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 8;

    // Construtor para receber o nome e o sobrenome
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Chame um método pedindo o departamento - devolver o departamento
        this.department = setDepartment();

        // Chame um método que retorne uma senha aleatória
        this.password = randomPassword(defaultPasswordLength);

        // Combine elementos para gerar e-mail
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
    }

    // Pergunte ao departamento
    private String setDepartment() {
        System.out.print("DIGITE O CÓDIGO DO DEPARTAMENTO\n1. para Vendas\n2. para Desenvolvimento\n3. para Contabilidade\n0. para nenhum\n.: ");
        Scanner input = new Scanner(System.in);
        int depChoice = input.nextInt();
        if (depChoice == 1) {return "vendas.";}
        else if (depChoice == 2) {return "dev.";}
        else if (depChoice == 3) {return "contabil.";}
        else {return "";}
    }

    // Gerar uma senha aleatória
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz!@#$&";
        char[] password = new char[length];
        for (int i=0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Definir a capacidade da caixa de email
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // Definir o e-mail alternativo
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Mude a senha
    public void chancePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "NOME: " + firstName + " " + lastName + "\n" +
                "EMAIL DA EMPRESA: " + email + "\n" +
                "SENHA DO E-MAIL DA EMPRESA: " + password + "\n" +
                "CAPACIDADE DA CAIXA DE E-MAIL: " + mailboxCapacity + "mb";
    }

}
