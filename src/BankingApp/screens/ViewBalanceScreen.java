package BankingApp.screens;

import BankingApp.beans.ConnectionUtility;
import BankingApp.beans.User;
import BankingApp.factories.ScreenFactory;

import java.sql.*;

/**
 * Functionality: Manages the screen displaying the view balance function.
 */
public class ViewBalanceScreen implements Screen {
    @Override
    public void prompt() {
        double bal;
        try (Connection c = ConnectionUtility.getConnection()){
            PreparedStatement ps = c.prepareCall("SELECT balance FROM bank_users WHERE uname = ?");
            ps.setString(1, String.valueOf(User.getUname()));
            ResultSet rs = ps.executeQuery();
            rs.next();
            bal = rs.getDouble(1);
            System.out.printf("Current balance is: $%.2f\n", bal);
            if(bal < 5000) System.out.println("Your business here is appreciated.");
            else if (bal < 10000) System.out.println("Thank you for trusting Faceless Banking Corporation.");
            else if (bal < 50000) System.out.println("You are an appreciated member of the Faceless family.");
            else if (bal < 100000) System.out.println("Remember to make use of our new VIP lounge, only open to committed members like yourself.");
        } catch (SQLException e) {
            System.out.println("Something went wrong. Try again later.");
            e.printStackTrace();
        }
        ScreenFactory.getScreenFactory().setCurrentScreen("mainLogIn");
    }
}
