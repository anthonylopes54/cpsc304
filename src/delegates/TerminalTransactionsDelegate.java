package delegates;

import models.Model;

import java.sql.Connection;

public interface TerminalTransactionsDelegate {
    public void databaseSetup();

    public void insert(Model model, Connection connection);
    public void delete(Model model, Connection connection);
    public void update(Model model, Connection connection);
    public void show();

    public void tripManagerFinished();
}
