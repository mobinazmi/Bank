package Controller;

import Entity.AccountE;
import Entity.StaffE;
import GUI.*;
import Service.AccountS;
import Service.StaffS;

import javax.swing.*;
import java.util.Random;

public class StaffC {
    public void login(String username, String pass) throws Exception{
        try (StaffLogin staffLogin=new StaffLogin(new JFrame(), true)){

            StaffE staffE=new StaffE();
            staffE.setPassword(pass);
            staffE.setUsername(username);

            StaffE staffE1=new StaffE();
            staffE1.setUsername(username);

            StaffS staffS=new StaffS();
            staffS.login(staffE1);

            if (staffE.getPassword().equals(staffE1.getPassword()) && staffE.getUsername().equals(staffE1.getUsername())){

                MainMenu mm = new MainMenu();
                StaffMenu stm = new StaffMenu(mm, true);
                stm.setVisible(true);
            }
            else{
                StringBuilder warning = new StringBuilder();
                warning.append("\tusername or password incorrect.");
                JOptionPane.showMessageDialog(staffLogin, warning.toString(), "Input Error", JOptionPane.WARNING_MESSAGE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void createAccount() throws Exception {
        Random dice = new Random();
        long number = 0;
        for (long counter = 1; counter <= 10; counter++) {
            number = dice.nextLong(10);
        }

        try (CustomerLogin customerLogin = new CustomerLogin()) {
            AccountS accountS = new AccountS();
            AccountE accountE = new AccountE();

            AccountS.getInstance().save(accountE.setId(number));
            JOptionPane.showMessageDialog(new CreateAccountForm(new JFrame(), true), accountE.getAccountNumber(), "Card Info", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}