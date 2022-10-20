package KuchB;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SQL_add {
	Scanner sa = new Scanner(System.in);

    String qt,s_name,type_name,p_name,l_name;
	Connection conn;                                         
	Statement stmt;
	ResultSet rs;

	public SQL_add() {
		System.out.println("Enter question text : ");
		qt = sa.nextLine();
		System.out.println("Enter sub_name : ");
		s_name = sa.nextLine();
		System.out.println("Enter type_name : ");
		type_name = sa.nextLine();
		System.out.println("Enter policy_name : ");
		p_name = sa.nextLine();
		System.out.println("Enter level_name: ");
		l_name = sa.nextLine();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assessment","root","monster2.0");
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("SELECT * FROM question");
			rs.moveToInsertRow();
			rs.updateString("question_text", qt);
			rs.updateString("subject_id", s_name);
			rs.updateString("question_type_id", type_name);
			rs.updateString("policy_id", p_name);
			rs.updateString("level_id", l_name);
			rs.insertRow();
			rs.moveToCurrentRow();
			conn.close();
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		} catch(SQLException e) {
			System.out.println(e);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new SQL_add();
	}
}