package aulasteste;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConectaBanco {
private Connection connect = null;
private Statement statement = null;
private ResultSet resultSet = null;
final private String host = "localhost";
final private String user = "root";
final private String passwd = "968574";
public void readDataBase() throws Exception {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
connect = DriverManager.getConnection("jdbc:mysql://" + host +
"/Teste?" + "user=" + user + "&password=" + passwd);
statement = connect.createStatement();
resultSet = statement.executeQuery("select * from aluno");
writeResultSet(resultSet);
System.out.println("Banco de Dados Conectado com sucesso!");
} catch (Exception e) {
throw e;
} finally {
close();
}
}
private void writeResultSet(ResultSet resultSet) throws SQLException {
while (resultSet.next()) {
String meuID = resultSet.getString("id");
String meuNome = resultSet.getString("nome");
System.out.println("id: " + meuID);
System.out.println("nome: " + meuNome);
}
}
void close() {
try {
if (resultSet != null) {
resultSet.close();
}
if (statement != null) {
statement.close();
}
if (connect != null) {
connect.close();
}
} catch (Exception e) {
}
return;
}
}
